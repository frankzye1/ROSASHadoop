add jar .\Rosas.DataProcessor.jar;
use rosas;

CREATE TEMPORARY FUNCTION ev1 as 'rosas.dataprocessor.MR_OverCoverageIndex_UDAF';
insert overwrite table MR_INDEX_5
select mo, ttime, sum(Flag) as MR_OVERCOV_INDEX from (
		from (select mo, date, count(1) as total from mro group by mo, date) t1
		join mro t2 on t1.mo = t2.mo and t1.date = t2.date
		select t2.mo, t2.date as TTIME, t2.MR_LteNcEarfcn, t2.MR_LteNcPci, ev1(t2.MR_LteScRSRP, t2.MR_LteNcRSRP, t1.total) as Flag
		group by t2.mo, t2.date, t2.MR_LteNcEarfcn, t2.MR_LteNcPci
) as t3 group by mo, ttime 

