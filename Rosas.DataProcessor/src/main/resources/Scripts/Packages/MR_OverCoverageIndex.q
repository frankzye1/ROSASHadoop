add jar .\Rosas.DataProcessor.jar;
use rosas;
CREATE TEMPORARY FUNCTION ev1 as 'rosas.dataprocessor.MR_OverCoverageIndex_UDAF';
--------------¹ý¸²¸Ç---------------

drop table T5_1;
drop table T5_2;
drop table T5_3;
drop table T5_4;
drop table T5_P1;
drop table T5_P2;
drop table T5_P3;
drop table T5_11;
drop table T5_12;


CREATE TABLE T5_P1 AS
SELECT value1 as v1,operator1 as op1 FROM PARAM_CONFIG
WHERE PARAM='COV_THRES';
CREATE TABLE T5_P2 AS
SELECT value1 as v2,operator1 as op2 FROM PARAM_CONFIG
WHERE PARAM='RSRP_DIFF';
CREATE TABLE T5_P3 AS
SELECT value1 as v3,operator1 as op3 FROM PARAM_CONFIG
WHERE PARAM='SR_SAMPLE_RATIO';



CREATE TABLE T5_11 AS
select substring(fileheader_starttime,0,10) as day,DEF_MO1 as MO,
MR_LteNcEarfcn,MR_LteNcPci,MR_LteScRSRP,MR_LteNcRSRP,ev3(MR_LteScRSRP,v1,op1) as flag2
from T5_P1,MRO;

CREATE TABLE T5_12 AS
select * from T5_11 where flag2=1;

CREATE TABLE T5_1 AS 
select MO,day,COUNT(*) as totle
from
T5_12
group by day,MO;

CREATE TABLE T5_2 AS 
select *,day as day1,MO as MO1 FROM T5_12;

CREATE TABLE T5_3 AS 
select * from 
T5_1 t1 join T5_2 t2
on t1.MO=t2.MO1 and t2.day1=t1.day;

CREATE TABLE T5_4 AS
select day,MO,MR_LteNcEarfcn,MR_LteNcPci,
ev1(MR_LteScRSRP,MR_LteNcRSRP,totle,v1,op1,v2,op2,v3,op3) as Flag
from 
T5_P1,T5_P2,T5_P3,T5_3
group by day,MO,MR_LteNcEarfcn,MR_LteNcPci;

insert overwrite table MR_INDEX_5
select MO,day,'AllDay',sum(Flag) as MR_OVERCOV_INDEX from T5_4 
group by day,MO;


drop table T5_1;
drop table T5_2;
drop table T5_3;
drop table T5_4;
drop table T5_P1;
drop table T5_P2;
drop table T5_P3;
drop table T5_11;
drop table T5_12;
