add jar .\Rosas.DataProcessor.jar;
use rosas;
--------------天线接反分析---MR_INDEX_7------------
CREATE TEMPORARY FUNCTION ev1 as 'rosas.dataprocessor.Antenna_Reverse_Analysis_1_UDF';
CREATE TEMPORARY FUNCTION ev2 as 'rosas.dataprocessor.Antenna_Reverse_Analysis_UDF';

drop table T7_1;
create table T7_1 as
select * from
(select * from mr_index_3 where THOUR='AllDay') t1
join
SITE_INFO t2
on
t1.mo=t2.DEF_ECI;

drop table MR_INDEX_7;
CREATE TABLE MR_INDEX_7 AS
select t4.MO,'隐性故障' as TYPE1,'疑似天线故障' as TYPE2,'天线接反' as TYPE3,DEF_CELLNAME,TTIME,CITY,REGION,TOWN,GRID,concat('规划方向角与实际覆盖方向偏差',FAULT_DESCRIPTION1,'度') as FAULT_DESCRIPTION,'原因' as LABEL,'AllDay' as THOUR,DEF_CELLNAME_CHINESE
from
(select *,ev2(DIR,MR_SECTOR_BEARING) as Flag,ev1(DIR,MR_SECTOR_BEARING) as FAULT_DESCRIPTION1 from T7_1) t4
where Flag=1;


drop table T7_1;
