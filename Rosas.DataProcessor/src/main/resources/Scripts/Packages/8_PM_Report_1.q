use rosas;
drop table temp_pm_1;
drop table temp_pm_2;
drop table temp_pm_3;
drop table temp_pm_4;

CREATE TABLE temp_pm_1 AS
select *,regexp_replace(substring(fileheader_datetime,0,10),'-','') as day from NRM_EutranCellTdd;

CREATE TABLE temp_pm_2 AS
select max(day) as maxday from temp_pm_1;

---------选出NRM_EutranCellTdd表中最新日期的数据----------
CREATE TABLE temp_pm_3 AS
select * from temp_pm_2 t2,temp_pm_1 t1 WHERE t1.day=t2.maxday;

-----更新PI_TEMP表的数据------
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
FROM temp_pm_3;

----修改PI_TEMP表DEF_CELLNAME列名---
ALTER TABLE PI_TEMP 
CHANGE COLUMN DEF_CELLNAME PI_TEMP_DEF_CELLNAME String; 

----创建SITE_INFO的临时表----
CREATE TABLE temp_pm_4 AS 
SELECT * FROM SITE_INFO;

----修改temp_pm_4表的DEF_CELLNAME,guid列名------
ALTER TABLE temp_pm_4 
CHANGE COLUMN DEF_CELLNAME SITE_INFO_DEF_CELLNAME String;
ALTER TABLE temp_pm_4 
CHANGE COLUMN GUID SITE_INFO_GUID String; 
ALTER TABLE temp_pm_4 
CHANGE COLUMN DEF_CELLID SITE_INFO_DEF_CELLID String;
ALTER TABLE temp_pm_4 
CHANGE COLUMN def_enbid SITE_INFO_def_enbid String;
ALTER TABLE temp_pm_4 
CHANGE COLUMN def_eci SITE_INFO_def_eci String;
ALTER TABLE temp_pm_4 
CHANGE COLUMN def_sitename SITE_INFO_def_sitename String;
ALTER TABLE temp_pm_4 
CHANGE COLUMN def_sitename_chinese SITE_INFO_def_sitename_chinese String;
ALTER TABLE temp_pm_4 
CHANGE COLUMN def_cellname_chinese SITE_INFO_def_cellname_chinese String;
DROP TABLE TEMP_PM_EutranCellTdd;
CREATE TABLE TEMP_PM_EutranCellTdd AS
SELECT * FROM PM_EutranCellTdd WHERE substring(FILEHEADER_BEGINTIME,0,10)='{select_date}';


drop table temp_pm_5;
CREATE table temp_pm_5 as
select t1.DEF_CELLNAME as CELLNAME,* from 
TEMP_PM_EutranCellTdd t1 join PI_TEMP t2 on t1.DEF_CELLNAME=t2.PI_TEMP_DEF_CELLNAME join temp_pm_4 t4 
on t1.DEF_CELLNAME=t4.SITE_INFO_DEF_CELLNAME;

----修改PI_TEMP表PI_TEMP_DEF_CELLNAME列名---
ALTER TABLE PI_TEMP 
CHANGE COLUMN PI_TEMP_DEF_CELLNAME DEF_CELLNAME String;


drop table temp_pm_1;
drop table temp_pm_2;
drop table temp_pm_3;
drop table temp_pm_4;
DROP TABLE TEMP_PM_EutranCellTdd;



