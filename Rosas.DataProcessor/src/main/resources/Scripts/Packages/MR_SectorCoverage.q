﻿add jar .\Rosas.DataProcessoror.jar;
use rosas;
--MR扇区覆盖集中度算法
CREATE TEMPORARY FUNCTION ev1 as 'rosas.dataprocess.MR_Coverage_Rate_UDAF';
insert overwrite table MR_INDEX_3  
	select DEF_MO1 as MO , day as TTIME, 
	ev1(MR_AOA_00,MR_AOA_01,MR_AOA_02,MR_AOA_03,MR_AOA_04,MR_AOA_05,MR_AOA_06,MR_AOA_07,
MR_AOA_08,MR_AOA_09,MR_AOA_10,MR_AOA_11,MR_AOA_12,MR_AOA_13,MR_AOA_14,MR_AOA_15,
MR_AOA_16,MR_AOA_17,MR_AOA_18,MR_AOA_19,MR_AOA_20,MR_AOA_21,MR_AOA_22,MR_AOA_23,
MR_AOA_24,MR_AOA_25,MR_AOA_26,MR_AOA_27,MR_AOA_28,MR_AOA_29,MR_AOA_30,MR_AOA_31,
MR_AOA_32,MR_AOA_33,MR_AOA_34,MR_AOA_35,MR_AOA_36,MR_AOA_37,MR_AOA_38,MR_AOA_39,
MR_AOA_40,MR_AOA_41,MR_AOA_42,MR_AOA_43,MR_AOA_44,MR_AOA_45,MR_AOA_46,MR_AOA_47,
MR_AOA_48,MR_AOA_49,MR_AOA_50,MR_AOA_51,MR_AOA_52,MR_AOA_53,MR_AOA_54,MR_AOA_55,
MR_AOA_56,MR_AOA_57,MR_AOA_58,MR_AOA_59,MR_AOA_60,MR_AOA_61,MR_AOA_62,MR_AOA_63,
MR_AOA_64,MR_AOA_65,MR_AOA_66,MR_AOA_67,MR_AOA_68,MR_AOA_69,MR_AOA_70,MR_AOA_71) as MR_SECTOR_BEARING
	from( select *, concat(LPAD(FILEHEADER_REPORTTIME,11,''),'"') as day from mrs_mr_aoa
) t1 group by DEF_MO1, day ; 
