use rosas;
drop table t10_1;
drop table t10_2;
drop table t10_3;
drop table t10_4;

CREATE TABLE T10_1 AS
select *,regexp_replace(substring(fileheader_datetime,0,10),'-','') as day from NRM_EutranCellTdd;

CREATE TABLE T10_2 AS
select max(day) as maxday from T10_1;

---------ѡ��NRM_EutranCellTdd�����������ڵ�����----------
CREATE TABLE T10_3 AS
select * from T10_2 t2,T10_1 t1 WHERE t1.day=t2.maxday;

-----����PI_TEMP��������------
insert overwrite table PI_TEMP 
select DEF_CELLNAME,
CASE
	WHEN BANDWIDTH=1.4 THEN 6 
	ELSE 5*BANDWIDTH  
END AS TotalPrb,
CASE
	WHEN SFASSIGNMENT=0 THEN 6 
	WHEN SFASSIGNMENT=1 THEN 4 
	WHEN SFASSIGNMENT=2 THEN 2 
	WHEN SFASSIGNMENT=3 THEN 3 
	WHEN SFASSIGNMENT=4 THEN 2 
	WHEN SFASSIGNMENT=5 THEN 1 
	WHEN SFASSIGNMENT=6 THEN 5 
	ELSE 0
END AS X,
CASE
	WHEN SFASSIGNMENT=0 THEN 2 
	WHEN SFASSIGNMENT=1 THEN 4 
	WHEN SFASSIGNMENT=2 THEN 6 
	WHEN SFASSIGNMENT=3 THEN 6 
	WHEN SFASSIGNMENT=4 THEN 7 
	WHEN SFASSIGNMENT=5 THEN 8 
	WHEN SFASSIGNMENT=6 THEN 3 
	ELSE 0
END AS Y 
FROM t10_3;

----�޸�PI_TEMP��DEF_CELLNAME����---
ALTER TABLE PI_TEMP 
CHANGE COLUMN DEF_CELLNAME PI_TEMP_DEF_CELLNAME String; 

----����SITE_INFO����ʱ��----
CREATE TABLE t10_4 AS 
SELECT * FROM SITE_INFO;

----�޸�t10_4����DEF_CELLNAME,guid����------
ALTER TABLE t10_4 
CHANGE COLUMN DEF_CELLNAME SITE_INFO_DEF_CELLNAME String;
ALTER TABLE t10_4 
CHANGE COLUMN GUID SITE_INFO_GUID String; 
ALTER TABLE t10_4 
CHANGE COLUMN DEF_CELLID SITE_INFO_DEF_CELLID String;
ALTER TABLE t10_4 
CHANGE COLUMN def_enbid SITE_INFO_def_enbid String;
ALTER TABLE t10_4 
CHANGE COLUMN def_eci SITE_INFO_def_eci String;
ALTER TABLE t10_4 
CHANGE COLUMN def_sitename SITE_INFO_def_sitename String;
ALTER TABLE t10_4 
CHANGE COLUMN def_sitename_chinese SITE_INFO_def_sitename_chinese String;
ALTER TABLE t10_4 
CHANGE COLUMN def_cellname_chinese SITE_INFO_def_cellname_chinese String;

drop table t10_5;
CREATE table t10_5 as
select t1.DEF_CELLNAME as CELLNAME,* from 
PM_EutranCellTdd t1 join PI_TEMP t2 on t1.DEF_CELLNAME=t2.PI_TEMP_DEF_CELLNAME join t10_4 t4 
on t1.DEF_CELLNAME=t4.SITE_INFO_DEF_CELLNAME;

----�޸�PI_TEMP��PI_TEMP_DEF_CELLNAME����---
ALTER TABLE PI_TEMP 
CHANGE COLUMN PI_TEMP_DEF_CELLNAME DEF_CELLNAME String;


drop table t10_1;
drop table t10_2;
drop table t10_3;
drop table t10_4;



