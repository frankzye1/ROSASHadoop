add jar .\Rosas.DataProcessor.jar;
use rosas;

CREATE TEMPORARY FUNCTION ev1 as "rosas.dataprocessor.Antenna_Reverse_Analysis_1_UDF";
CREATE TEMPORARY FUNCTION ev2 as "rosas.dataprocessor.Antenna_Reverse_Analysis_UDF";

drop table T7_1;
create table T7_1 as
select * from
(select * from mr_index_3 where THOUR="AllDay") t1
join
SITE_INFO t2
on
t1.mo=t2.DEF_ECI;

drop table PROPERTIES_DB_1;
CREATE TABLE PROPERTIES_DB_1 AS
select DEF_CELLNAME,"隐性故障" as TYPE1,"疑似天线故障" as TYPE2,"天线接反" as TYPE3,
DEF_CELLNAME as FAULT_OBJECT,TTIME,CITY,REGION,TOWN,GRID,
concat("规划方向角与实际覆盖方向偏差",FAULT_DESCRIPTION1,"度") as FAULT_DESCRIPTION,
"原因" as LABEL,
"AllDay" as THOUR,DEF_CELLNAME_CHINESE
from
(select *,ev2(DIR,MR_SECTOR_BEARING) as Flag,ev1(DIR,MR_SECTOR_BEARING) as FAULT_DESCRIPTION1 from T7_1) t4
where Flag=1;


drop table T7_1;
