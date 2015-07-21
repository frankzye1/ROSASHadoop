add jar .\Rosas.DataProcessor.jar;
use rosas;

-----------------MR¸²¸ÇÂÊ---------------------
CREATE TEMPORARY FUNCTION ev1 as 'rosas.dataprocessor.MR_Coverage_Rate_UDAF';
insert overwrite table MR_INDEX_1
	select DEF_MO1 as MO , day as TTIME,
	ev1(MR_RSRQ_00,MR_RSRQ_01,MR_RSRQ_02,MR_RSRQ_03,MR_RSRQ_04,MR_RSRQ_05,MR_RSRQ_06,MR_RSRQ_07,MR_RSRQ_08,MR_RSRQ_09,MR_RSRQ_10,MR_RSRQ_11,MR_RSRQ_12,MR_RSRQ_13,MR_RSRQ_14,MR_RSRQ_15,MR_RSRQ_16,MR_RSRQ_17) as MR_COV_RATE
	from( select *, LPad(FILEHEADER_REPORTTIME,10,'') as day from MRS_MR_RSRQ
) t1 group by DEF_MO1, day ;
