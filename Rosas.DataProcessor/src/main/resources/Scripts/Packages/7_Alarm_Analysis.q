use rosas;

DROP TABLE Alarm_Analysis_1;
CREATE TABLE Alarm_Analysis_1 AS
SELECT *,split(OCCUR_TIME," ")[0] as ttime FROM alarm_nd where split(OCCUR_TIME," ")[0]=regexp_replace('{select_date}',"-","/"); 

DROP TABLE Alarm_Analysis_2;
CREATE TABLE Alarm_Analysis_2 AS
SELECT TITLE,ALARM_NODE,MAX(DN) as DN,MAX(ttime) as ttime,MAX(STD_TITLE) as STD_TITLE
FROM Alarm_Analysis_1
GROUP BY 
ALARM_NODE,TITLE;

DROP TABLE Alarm_Analysis_3;
CREATE TABLE Alarm_Analysis_3 AS
SELECT DEF_CELLNAME,'œ‘–‘π ’œ' as TYPE1,'' as TYPE2,TITLE as TYPE3,
DN as FAULT_OBJECT,
CITY,REGION,TOWN,GRID,
regexp_replace(ttime,"/","-"),
STD_TITLE as FAULT_DESCRIPTION,
'‘≠“Ú' as LABEL,'AllDay' as THOUR,DEF_CELLNAME_CHINESE
FROM Alarm_Analysis_2 t1 join site_info t2 on t1.ALARM_NODE=t2.def_sitename_chinese;