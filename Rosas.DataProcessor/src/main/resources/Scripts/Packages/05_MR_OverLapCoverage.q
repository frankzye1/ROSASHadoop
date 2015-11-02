add jar .\Rosas.DataProcessor.jar;
use rosas;
--------------重叠覆盖---------------
CREATE TEMPORARY FUNCTION ev1 as 'rosas.dataprocessor.Compare_UDF';
CREATE TEMPORARY FUNCTION ev2 as 'rosas.dataprocessor.MR_OverLapCoverageIndex_UDAF';

drop table T6_1;
drop table T6_2;
drop table T6_3;
drop table T6_4;
drop table T6_5;
drop table t6_5_1;
drop table t6_p1;
drop table t6_p2;
drop table t6_p3;


CREATE TABLE T6_P1 AS
SELECT value1 as v1,operator1 as op1 FROM PARAM_CONFIG
WHERE PARAM='COV_THRES';
CREATE TABLE T6_P2 AS
SELECT value1 as v2,operator1 as op2 FROM PARAM_CONFIG
WHERE PARAM='RSRP_DIFF';
CREATE TABLE T6_P3 AS
SELECT value1 as v3,operator1 as op3 FROM PARAM_CONFIG
WHERE PARAM='OL_NBRNUM_THRES';



CREATE TABLE T6_1 AS
select DEF_MO1 as MO,substring(fileheader_starttime,0,10) as day,MR_LteNcEarfcn,MR_LteNcPci,MR_LteNcRSRP,MR_LteScRSRP,ev1(MR_LteScRSRP,op1,v1) as Flag1 
from 
T6_P1,MRO WHERE substring(fileheader_starttime,0,10)='{select_date}';


-------符合条件1的样本T6_2-------------------------------
CREATE TABLE T6_2 AS
select *
from
T6_1 where Flag1=1;

------符合条件1的样本总数 YB_totle1-------------------------
CREATE TABLE T6_3 AS
select MO as MO4,day as day2,COUNT(*) as YB_totle1
from
T6_2 group by MO,day;

DROP TABLE T6_4_1;
CREATE TABLE T6_4_1 AS
select MO,day,MR_LteNcEarfcn,MR_LteNcPci from T6_2
GROUP BY
MO,day,MR_LteNcEarfcn,MR_LteNcPci;

DROP TABLE T6_4_2;
CREATE TABLE T6_4_2 AS
select MO,day,count(*) as LQ_totle from
T6_4_1
GROUP BY MO,day;


---------------T6_4(选择符合条件3的小区)---------------
----------每个小区包含的邻区数 LQ_totle  符合条件3 Flag3=1 否则 =0------------
drop table T6_4;
CREATE TABLE T6_4 AS
select MO as MO1,day as day3,ev1(LQ_totle,op3,v3) as Flag3
from T6_P3,T6_4_2;

drop table T6_5_1;
CREATE TABLE T6_5_1 AS
SELECT * FROM
T6_2 t1 join T6_4 t2 on
t1.MO=t2.MO1 and t1.day=t2.day3 join T6_3 t4 on t1.MO=t4.MO4 and t1.day=t4.day2;

insert overwrite table mr_index_6
select MO,day,'AllDay',ev2(MR_LteNcRSRP,MR_LteScRSRP,op2,v2,YB_totle1,Flag3) as mr_overlap_index
from
T6_P2,T6_5_1
GROUP BY MO,day;


drop table T6_1;
drop table T6_2;
drop table T6_3;
drop table T6_4;
drop table T6_5;
drop table t6_5_1;
drop table t6_p1;
drop table t6_p2;
drop table t6_p3;
DROP TABLE T6_4_1;
DROP TABLE T6_4_2;


