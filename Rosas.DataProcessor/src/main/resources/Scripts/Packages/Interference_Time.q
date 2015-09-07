USE ROSAS;

DROP TABLE IF_INDEX_16;
CREATE TABLE IF_INDEX_16 AS
SELECT 
DEF_VENDORNAME,DEF_CELLNAME,DEF_CELLNAME_CHINESE,TTIME,THOUR,
'1' as CNT_PERIOD,
CASE 
WHEN IF_INDEX>0 THEN 1 
ELSE 0
END AS CNT_IF 
FROM 
IF_INDEX_14
WHERE 
THOUR<>'AllDay';

INSERT INTO TABLE IF_INDEX_16
SELECT 
DEF_VENDORNAME,DEF_CELLNAME,DEF_CELLNAME_CHINESE,TTIME,'AllDay' as THOUR,
sum(CNT_PERIOD) as CNT_PERIOD,sum(CNT_IF) as CNT_IF
FROM IF_INDEX_16
WHERE THOUR<>'AllDay' 
GROUP BY 
DEF_VENDORNAME,DEF_CELLNAME,DEF_CELLNAME_CHINESE,TTIME;
