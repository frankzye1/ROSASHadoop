use rosas;

DROP TABLE MR_INDEX_TEMP;
CREATE TABLE MR_INDEX_TEMP AS
select u1.*,MR_COV_RATE,MR_BADQUAL_RATE,MR_SECTOR_BEARING,MR_USER_DIS,MR_OVERCOV_INDEX,MR_OVERLAP_INDEX from 
(SELECT mo,ttime,thour FROM MR_INDEX_1
union all
SELECT mo,ttime,thour FROM MR_INDEX_2
union all
SELECT mo,ttime,thour FROM MR_INDEX_3
union all
SELECT mo,ttime,thour FROM MR_INDEX_4
union all
SELECT mo,ttime,thour FROM MR_INDEX_5
union all
SELECT mo,ttime,thour FROM MR_INDEX_6) u1
left outer join
MR_INDEX_1 t1 
on
u1.mo=t1.mo and u1.ttime=t1.ttime and u1.thour=t1.thour
left outer join
MR_INDEX_2 t2 
on
u1.mo=t2.mo and u1.ttime=t2.ttime and u1.thour=t2.thour
left outer join
MR_INDEX_3 t3
on
u1.mo=t3.mo and u1.ttime=t3.ttime and u1.thour=t3.thour
left outer join
MR_INDEX_4 t4
on
u1.mo=t4.mo and u1.ttime=t4.ttime and u1.thour=t4.thour
left outer join
MR_INDEX_5 t5
on
u1.mo=t5.mo and u1.ttime=t5.ttime and u1.thour=t5.thour
left outer join
MR_INDEX_6 t6
on
u1.mo=t6.mo and u1.ttime=t6.ttime and u1.thour=t6.thour;

----Á¬½Ósite_info
INSERT OVERWRITE TABLE MR_INDEX
SELECT 
CITY,REGION,TOWN,GRID,DEF_CELLNAME,TTIME,THOUR,MR_COV_RATE,MR_BADQUAL_RATE,MR_SECTOR_BEARING,MR_USER_DIS,MR_OVERCOV_INDEX,MR_OVERLAP_INDEX
FROM
MR_INDEX_TEMP t1 left outer join site_info t2 on
t1.mo=t2.def_eci;

DROP TABLE MR_INDEX_TEMP;