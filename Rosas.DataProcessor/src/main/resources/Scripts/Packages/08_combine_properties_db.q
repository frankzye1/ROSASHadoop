use rosas;

----合并properties_db的数据
INSERT OVERWRITE TABLE properties_db_mid
SELECT 
def_cellname,type1,type2,type3,fault_object,ttime,city,region,town,grid,fault_description,label,thour,def_cellname_chinese,'','','','','','','',''
FROM
properties_db_3;

INSERT INTO TABLE properties_db_mid
SELECT 
def_cellname,type1,type2,type3,fault_object,ttime,city,region,town,grid,fault_description,label,thour,def_cellname_chinese,'','','','','','','',''
FROM
properties_db_2;

INSERT INTO TABLE properties_db_mid
SELECT 
def_cellname,type1,type2,type3,fault_object,ttime,city,region,town,grid,fault_description,label,thour,def_cellname_chinese,'','','','','','','',''
FROM
properties_db_1;

INSERT INTO TABLE properties_db_mid
SELECT 
def_cellname,type1,type2,type3,fault_object,ttime,city,region,town,grid,fault_description,label,thour,def_cellname_chinese,'','','','','','','',''
FROM
Alarm_Analysis_3;
