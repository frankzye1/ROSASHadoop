add jar .\Rosas.DataProcessor.jar;
use rosas;
--------------GSM_邻区漏定义分析--MR_INDEX_10-------------
CREATE TEMPORARY FUNCTION ev1 as 'rosas.dataprocessor.Compare_UDF';
CREATE TEMPORARY FUNCTION ev2 as 'rosas.dataprocessor.GSM_AdjacentAreaLeakageDefinition_UDAF';


CREATE TABLE T10_1 AS
SELECT * FROM PARAM_CONFIG,MRO WHERE MR_GsmNcellNcc<>NULL ADN PARAM=‘COV_THRES’;

CREATE TABLE T10_2 AS
SELECT *,ev1(MR_LteScRSRP,op1,v1) as Flag1 FROM T10_1;
----记录U
CREATE TABLE T10_3 AS
SELECT *,LPad(fileheader_starttime,10,'') as day FROM T10_2 where Flag1=1;
----记录UN
CREATE TABLE T10_4 AS
SELECT *,COUNT(*) as totle FROM T10_3 GROUP BY day,DEF_MO1,MR_GsmNcellNcc,MR_GsmNcellBcc,MR_GsmNcellBcch;

CREATE TABLE T10_5 AS
SELECT day,DEF_MO1,MR_GsmNcellNcc,MR_GsmNcellBcc,MR_GsmNcellBcch,ev2(MR_GsmNcellCarrierRSSI,op2,v2,totle,op3,v3) as Flag2
FROM
T10_4 GROUP BY
day,DEF_MO1,MR_GsmNcellNcc,MR_GsmNcellBcc,MR_GsmNcellBcch;

CREATE TABLE T10_6 AS
SELECT * FROM T10_5 WHERE Flag2=1;

----T10_7表中的MO属于GSM邻区漏定义的小区
CREATE TABLE T10_7 AS
select * from
NRM-GsmRelation t1 left outer join T10_6 t2 on t1.Ncc=t2.MR_GsmNcellNcc,t1.Bcc=t2.MR_GsmNcellBcc,t1.BcchFrequency=t2.MR_GsmNcellBcch
where t2.Falg2<>1;

----把T10_7的结果写入MR_INDEX_9中



drop table T10_1;
drop table T10_2;
drop table T10_3;
drop table T10_4;
drop table T10_5;
drop table T10_6;
drop table T10_7;
