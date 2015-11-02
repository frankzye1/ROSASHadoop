USE ROSAS;
add jar .\Rosas.DataProcessor.jar;
CREATE TEMPORARY FUNCTION ev1 as 'rosas.dataprocessor.Interference_Type_1_UDF';
CREATE TEMPORARY FUNCTION ev2 as 'rosas.dataprocessor.Interference_Type_2_UDF';
CREATE TEMPORARY FUNCTION ev3 as 'rosas.dataprocessor.Interference_Type_3_UDF';
CREATE TEMPORARY FUNCTION ev4 as 'rosas.dataprocessor.Interference_Type_4_UDF';
CREATE TEMPORARY FUNCTION ev5 as 'rosas.dataprocessor.Interference_Type_5_UDF';
CREATE TEMPORARY FUNCTION ev6 as 'rosas.dataprocessor.Interference_Type_6_UDF';
CREATE TEMPORARY FUNCTION ev7 as 'rosas.dataprocessor.Interference_Type_7_UDF';
CREATE TEMPORARY FUNCTION ev8 as 'rosas.dataprocessor.Compare_UDF';
CREATE TEMPORARY FUNCTION ev10 as 'rosas.dataprocessor.Interference_Type_10_UDF';
CREATE TEMPORARY FUNCTION ev11 as 'rosas.dataprocessor.Interference_Type_11_UDF';
CREATE TEMPORARY FUNCTION ev12 as 'rosas.dataprocessor.Interference_Type_12_UDF';
CREATE TEMPORARY FUNCTION ev13 as 'rosas.dataprocessor.Interference_Type_13_UDF';


drop table AVG_PM_EutranCellTdd;
CREATE TABLE AVG_PM_EutranCellTdd as
select def_cellname,
substring(FILEHEADER_BEGINTIME,0,10) as ttime,
substring(fileheader_begintime,12,2) as thour,
avg(phy_ulmeannl_prb0) as phy_ulmeannl_prb0,avg(phy_ulmeannl_prb1) as phy_ulmeannl_prb1,avg(phy_ulmeannl_prb2) as phy_ulmeannl_prb2,avg(phy_ulmeannl_prb3) as phy_ulmeannl_prb3,avg(phy_ulmeannl_prb4) as phy_ulmeannl_prb4,avg(phy_ulmeannl_prb5) as phy_ulmeannl_prb5,avg(phy_ulmeannl_prb6) as phy_ulmeannl_prb6,avg(phy_ulmeannl_prb7) as phy_ulmeannl_prb7,avg(phy_ulmeannl_prb8) as phy_ulmeannl_prb8,avg(phy_ulmeannl_prb9) as phy_ulmeannl_prb9,avg(phy_ulmeannl_prb10) as phy_ulmeannl_prb10,avg(phy_ulmeannl_prb11) as phy_ulmeannl_prb11,avg(phy_ulmeannl_prb12) as phy_ulmeannl_prb12,avg(phy_ulmeannl_prb13) as phy_ulmeannl_prb13,avg(phy_ulmeannl_prb14) as phy_ulmeannl_prb14,avg(phy_ulmeannl_prb15) as phy_ulmeannl_prb15,avg(phy_ulmeannl_prb16) as phy_ulmeannl_prb16,avg(phy_ulmeannl_prb17) as phy_ulmeannl_prb17,avg(phy_ulmeannl_prb18) as phy_ulmeannl_prb18,avg(phy_ulmeannl_prb19) as phy_ulmeannl_prb19,avg(phy_ulmeannl_prb20) as phy_ulmeannl_prb20,avg(phy_ulmeannl_prb21) as phy_ulmeannl_prb21,avg(phy_ulmeannl_prb22) as phy_ulmeannl_prb22,avg(phy_ulmeannl_prb23) as phy_ulmeannl_prb23,avg(phy_ulmeannl_prb24) as phy_ulmeannl_prb24,avg(phy_ulmeannl_prb25) as phy_ulmeannl_prb25,avg(phy_ulmeannl_prb26)as phy_ulmeannl_prb26,avg(phy_ulmeannl_prb27) as phy_ulmeannl_prb27,avg(phy_ulmeannl_prb28) as phy_ulmeannl_prb28,avg(phy_ulmeannl_prb29) as phy_ulmeannl_prb29,avg(phy_ulmeannl_prb30) as phy_ulmeannl_prb30,avg(phy_ulmeannl_prb31) as phy_ulmeannl_prb31,avg(phy_ulmeannl_prb32) as phy_ulmeannl_prb32,avg(phy_ulmeannl_prb33) as phy_ulmeannl_prb33,avg(phy_ulmeannl_prb34) as phy_ulmeannl_prb34,avg(phy_ulmeannl_prb35) as phy_ulmeannl_prb35,avg(phy_ulmeannl_prb36) as phy_ulmeannl_prb36,avg(phy_ulmeannl_prb37) as phy_ulmeannl_prb37,avg(phy_ulmeannl_prb38) as phy_ulmeannl_prb38,avg(phy_ulmeannl_prb39) as phy_ulmeannl_prb39,avg(phy_ulmeannl_prb40) as phy_ulmeannl_prb40,avg(phy_ulmeannl_prb41) as phy_ulmeannl_prb41,avg(phy_ulmeannl_prb42) as phy_ulmeannl_prb42,avg(phy_ulmeannl_prb43) as phy_ulmeannl_prb43,avg(phy_ulmeannl_prb44) as phy_ulmeannl_prb44,avg(phy_ulmeannl_prb45) as phy_ulmeannl_prb45,avg(phy_ulmeannl_prb46) as phy_ulmeannl_prb46,avg(phy_ulmeannl_prb47) as phy_ulmeannl_prb47,avg(phy_ulmeannl_prb48) as phy_ulmeannl_prb48,avg(phy_ulmeannl_prb49) as phy_ulmeannl_prb49,avg(phy_ulmeannl_prb50) as phy_ulmeannl_prb50,avg(phy_ulmeannl_prb51) as phy_ulmeannl_prb51,avg(phy_ulmeannl_prb52) as phy_ulmeannl_prb52,avg(phy_ulmeannl_prb53) as phy_ulmeannl_prb53,avg(phy_ulmeannl_prb54) as phy_ulmeannl_prb54,avg(phy_ulmeannl_prb55) as phy_ulmeannl_prb55,avg(phy_ulmeannl_prb56) as phy_ulmeannl_prb56,avg(phy_ulmeannl_prb57) as phy_ulmeannl_prb57,avg(phy_ulmeannl_prb58) as phy_ulmeannl_prb58,avg(phy_ulmeannl_prb59) as phy_ulmeannl_prb59,avg(phy_ulmeannl_prb60) as phy_ulmeannl_prb60,avg(phy_ulmeannl_prb61) as phy_ulmeannl_prb61,avg(phy_ulmeannl_prb62) as phy_ulmeannl_prb62,avg(phy_ulmeannl_prb63) as phy_ulmeannl_prb63,avg(phy_ulmeannl_prb64) as phy_ulmeannl_prb64,avg(phy_ulmeannl_prb65) as phy_ulmeannl_prb65,avg(phy_ulmeannl_prb66)as phy_ulmeannl_prb66,avg(phy_ulmeannl_prb67) as phy_ulmeannl_prb67,avg(phy_ulmeannl_prb68) as phy_ulmeannl_prb68,avg(phy_ulmeannl_prb69) as phy_ulmeannl_prb69,avg(phy_ulmeannl_prb70) as phy_ulmeannl_prb70,avg(phy_ulmeannl_prb71) as phy_ulmeannl_prb71,avg(phy_ulmeannl_prb72) as phy_ulmeannl_prb72,avg(phy_ulmeannl_prb73) as phy_ulmeannl_prb73,avg(phy_ulmeannl_prb74) as phy_ulmeannl_prb74,avg(phy_ulmeannl_prb75) as phy_ulmeannl_prb75,avg(phy_ulmeannl_prb76) as phy_ulmeannl_prb76,avg(phy_ulmeannl_prb77) as phy_ulmeannl_prb77,avg(phy_ulmeannl_prb78) as phy_ulmeannl_prb78,avg(phy_ulmeannl_prb79) as phy_ulmeannl_prb79,avg(phy_ulmeannl_prb80) as phy_ulmeannl_prb80,avg(phy_ulmeannl_prb81) as phy_ulmeannl_prb81,avg(phy_ulmeannl_prb82) as phy_ulmeannl_prb82,avg(phy_ulmeannl_prb83) as phy_ulmeannl_prb83,avg(phy_ulmeannl_prb84) as phy_ulmeannl_prb84,avg(phy_ulmeannl_prb85) as phy_ulmeannl_prb85,avg(phy_ulmeannl_prb86) as phy_ulmeannl_prb86,avg(phy_ulmeannl_prb87) as phy_ulmeannl_prb87,avg(phy_ulmeannl_prb88) as phy_ulmeannl_prb88,avg(phy_ulmeannl_prb89) as phy_ulmeannl_prb89,avg(phy_ulmeannl_prb90) as phy_ulmeannl_prb90,avg(phy_ulmeannl_prb91) as phy_ulmeannl_prb91,avg(phy_ulmeannl_prb92) as phy_ulmeannl_prb92,avg(phy_ulmeannl_prb93) as phy_ulmeannl_prb93,avg(phy_ulmeannl_prb94) as phy_ulmeannl_prb94,avg(phy_ulmeannl_prb95) as phy_ulmeannl_prb95,avg(phy_ulmeannl_prb96) as phy_ulmeannl_prb96,avg(phy_ulmeannl_prb97) as phy_ulmeannl_prb97,avg(phy_ulmeannl_prb98) as phy_ulmeannl_prb98,avg(phy_ulmeannl_prb99) as phy_ulmeannl_prb99,
avg(phy_ulmaxnl_prb0) as phy_ulmaxnl_prb0,avg(phy_ulmaxnl_prb1) as phy_ulmaxnl_prb1,avg(phy_ulmaxnl_prb2) as phy_ulmaxnl_prb2,avg(phy_ulmaxnl_prb3) as phy_ulmaxnl_prb3,avg(phy_ulmaxnl_prb4) as phy_ulmaxnl_prb4,avg(phy_ulmaxnl_prb5) as phy_ulmaxnl_prb5,avg(phy_ulmaxnl_prb6) as phy_ulmaxnl_prb6,avg(phy_ulmaxnl_prb7) as phy_ulmaxnl_prb7,avg(phy_ulmaxnl_prb8) as phy_ulmaxnl_prb8,avg(phy_ulmaxnl_prb9)as phy_ulmaxnl_prb9,avg(phy_ulmaxnl_prb10) as phy_ulmaxnl_prb10,avg(phy_ulmaxnl_prb11) as phy_ulmaxnl_prb11,avg(phy_ulmaxnl_prb12) as phy_ulmaxnl_prb12,avg(phy_ulmaxnl_prb13) as phy_ulmaxnl_prb13,avg(phy_ulmaxnl_prb14) as phy_ulmaxnl_prb14,avg(phy_ulmaxnl_prb15) as phy_ulmaxnl_prb15,avg(phy_ulmaxnl_prb16) as phy_ulmaxnl_prb16,avg(phy_ulmaxnl_prb17) as phy_ulmaxnl_prb17,avg(phy_ulmaxnl_prb18) as phy_ulmaxnl_prb18,avg(phy_ulmaxnl_prb19) as phy_ulmaxnl_prb19,avg(phy_ulmaxnl_prb20) as phy_ulmaxnl_prb20,avg(phy_ulmaxnl_prb21) as phy_ulmaxnl_prb21,avg(phy_ulmaxnl_prb22) as phy_ulmaxnl_prb22,avg(phy_ulmaxnl_prb23) as phy_ulmaxnl_prb23,avg(phy_ulmaxnl_prb24) as phy_ulmaxnl_prb24,avg(phy_ulmaxnl_prb25) as phy_ulmaxnl_prb25,avg(phy_ulmaxnl_prb26) as phy_ulmaxnl_prb26,avg(phy_ulmaxnl_prb27) as phy_ulmaxnl_prb27,avg(phy_ulmaxnl_prb28) as phy_ulmaxnl_prb28,avg(phy_ulmaxnl_prb29) as phy_ulmaxnl_prb29,avg(phy_ulmaxnl_prb30) as phy_ulmaxnl_prb30,avg(phy_ulmaxnl_prb31) as phy_ulmaxnl_prb31,avg(phy_ulmaxnl_prb32) as phy_ulmaxnl_prb32,avg(phy_ulmaxnl_prb33) as phy_ulmaxnl_prb33,avg(phy_ulmaxnl_prb34) as phy_ulmaxnl_prb34,avg(phy_ulmaxnl_prb35) as phy_ulmaxnl_prb35,avg(phy_ulmaxnl_prb36) as phy_ulmaxnl_prb36,avg(phy_ulmaxnl_prb37) as phy_ulmaxnl_prb37,avg(phy_ulmaxnl_prb38) as phy_ulmaxnl_prb38,avg(phy_ulmaxnl_prb39) as phy_ulmaxnl_prb39,avg(phy_ulmaxnl_prb40) as phy_ulmaxnl_prb40,avg(phy_ulmaxnl_prb41) as phy_ulmaxnl_prb41,avg(phy_ulmaxnl_prb42) as phy_ulmaxnl_prb42,avg(phy_ulmaxnl_prb43) as phy_ulmaxnl_prb43,avg(phy_ulmaxnl_prb44) as phy_ulmaxnl_prb44,avg(phy_ulmaxnl_prb45) as phy_ulmaxnl_prb45,avg(phy_ulmaxnl_prb46) as phy_ulmaxnl_prb46,avg(phy_ulmaxnl_prb47) as phy_ulmaxnl_prb47,avg(phy_ulmaxnl_prb48) as phy_ulmaxnl_prb48,avg(phy_ulmaxnl_prb49) as phy_ulmaxnl_prb49,avg(phy_ulmaxnl_prb50) as phy_ulmaxnl_prb50,avg(phy_ulmaxnl_prb51) as phy_ulmaxnl_prb51,avg(phy_ulmaxnl_prb52) as phy_ulmaxnl_prb52,avg(phy_ulmaxnl_prb53) as phy_ulmaxnl_prb53,avg(phy_ulmaxnl_prb54) as phy_ulmaxnl_prb54,avg(phy_ulmaxnl_prb55) as phy_ulmaxnl_prb55,avg(phy_ulmaxnl_prb56) as phy_ulmaxnl_prb56,avg(phy_ulmaxnl_prb57) as phy_ulmaxnl_prb57,avg(phy_ulmaxnl_prb58) as phy_ulmaxnl_prb58,avg(phy_ulmaxnl_prb59) as phy_ulmaxnl_prb59,avg(phy_ulmaxnl_prb60) as phy_ulmaxnl_prb60,avg(phy_ulmaxnl_prb61) as phy_ulmaxnl_prb61,avg(phy_ulmaxnl_prb62) as phy_ulmaxnl_prb62,avg(phy_ulmaxnl_prb63) as phy_ulmaxnl_prb63,avg(phy_ulmaxnl_prb64) as phy_ulmaxnl_prb64,avg(phy_ulmaxnl_prb65) as phy_ulmaxnl_prb65,avg(phy_ulmaxnl_prb66) as phy_ulmaxnl_prb66,avg(phy_ulmaxnl_prb67) as phy_ulmaxnl_prb67,avg(phy_ulmaxnl_prb68) as phy_ulmaxnl_prb68,avg(phy_ulmaxnl_prb69) as phy_ulmaxnl_prb69,avg(phy_ulmaxnl_prb70) as phy_ulmaxnl_prb70,avg(phy_ulmaxnl_prb71) as phy_ulmaxnl_prb71,avg(phy_ulmaxnl_prb72) as phy_ulmaxnl_prb72,avg(phy_ulmaxnl_prb73) as phy_ulmaxnl_prb73,avg(phy_ulmaxnl_prb74) as phy_ulmaxnl_prb74,avg(phy_ulmaxnl_prb75) as phy_ulmaxnl_prb75,avg(phy_ulmaxnl_prb76) as phy_ulmaxnl_prb76,avg(phy_ulmaxnl_prb77) as phy_ulmaxnl_prb77,avg(phy_ulmaxnl_prb78) as phy_ulmaxnl_prb78,avg(phy_ulmaxnl_prb79) as phy_ulmaxnl_prb79,avg(phy_ulmaxnl_prb80) as phy_ulmaxnl_prb80,avg(phy_ulmaxnl_prb81) as phy_ulmaxnl_prb81,avg(phy_ulmaxnl_prb82) as phy_ulmaxnl_prb82,avg(phy_ulmaxnl_prb83) as phy_ulmaxnl_prb83,avg(phy_ulmaxnl_prb84) as phy_ulmaxnl_prb84,avg(phy_ulmaxnl_prb85) as phy_ulmaxnl_prb85,avg(phy_ulmaxnl_prb86) as phy_ulmaxnl_prb86,avg(phy_ulmaxnl_prb87) as phy_ulmaxnl_prb87,avg(phy_ulmaxnl_prb88) as phy_ulmaxnl_prb88,avg(phy_ulmaxnl_prb89) as phy_ulmaxnl_prb89,avg(phy_ulmaxnl_prb90) as phy_ulmaxnl_prb90,avg(phy_ulmaxnl_prb91) as phy_ulmaxnl_prb91,avg(phy_ulmaxnl_prb92) as phy_ulmaxnl_prb92,avg(phy_ulmaxnl_prb93) as phy_ulmaxnl_prb93,avg(phy_ulmaxnl_prb94) as phy_ulmaxnl_prb94,avg(phy_ulmaxnl_prb95) as phy_ulmaxnl_prb95,avg(phy_ulmaxnl_prb96) as phy_ulmaxnl_prb96,avg(phy_ulmaxnl_prb97) as phy_ulmaxnl_prb97,avg(phy_ulmaxnl_prb98) as phy_ulmaxnl_prb98,avg(phy_ulmaxnl_prb99) as phy_ulmaxnl_prb99 
from PM_EutranCellTdd group by 
substring(FILEHEADER_BEGINTIME,0,10),
substring(fileheader_begintime,12,2),def_cellname;

insert into table AVG_PM_EutranCellTdd
select def_cellname,
substring(FILEHEADER_BEGINTIME,0,10) as ttime,
'AllDay' as thour,
avg(phy_ulmeannl_prb0) as phy_ulmeannl_prb0,avg(phy_ulmeannl_prb1) as phy_ulmeannl_prb1,avg(phy_ulmeannl_prb2) as phy_ulmeannl_prb2,avg(phy_ulmeannl_prb3) as phy_ulmeannl_prb3,avg(phy_ulmeannl_prb4) as phy_ulmeannl_prb4,avg(phy_ulmeannl_prb5) as phy_ulmeannl_prb5,avg(phy_ulmeannl_prb6) as phy_ulmeannl_prb6,avg(phy_ulmeannl_prb7) as phy_ulmeannl_prb7,avg(phy_ulmeannl_prb8) as phy_ulmeannl_prb8,avg(phy_ulmeannl_prb9) as phy_ulmeannl_prb9,avg(phy_ulmeannl_prb10) as phy_ulmeannl_prb10,avg(phy_ulmeannl_prb11) as phy_ulmeannl_prb11,avg(phy_ulmeannl_prb12) as phy_ulmeannl_prb12,avg(phy_ulmeannl_prb13) as phy_ulmeannl_prb13,avg(phy_ulmeannl_prb14) as phy_ulmeannl_prb14,avg(phy_ulmeannl_prb15) as phy_ulmeannl_prb15,avg(phy_ulmeannl_prb16) as phy_ulmeannl_prb16,avg(phy_ulmeannl_prb17) as phy_ulmeannl_prb17,avg(phy_ulmeannl_prb18) as phy_ulmeannl_prb18,avg(phy_ulmeannl_prb19) as phy_ulmeannl_prb19,avg(phy_ulmeannl_prb20) as phy_ulmeannl_prb20,avg(phy_ulmeannl_prb21) as phy_ulmeannl_prb21,avg(phy_ulmeannl_prb22) as phy_ulmeannl_prb22,avg(phy_ulmeannl_prb23) as phy_ulmeannl_prb23,avg(phy_ulmeannl_prb24) as phy_ulmeannl_prb24,avg(phy_ulmeannl_prb25) as phy_ulmeannl_prb25,avg(phy_ulmeannl_prb26)as phy_ulmeannl_prb26,avg(phy_ulmeannl_prb27) as phy_ulmeannl_prb27,avg(phy_ulmeannl_prb28) as phy_ulmeannl_prb28,avg(phy_ulmeannl_prb29) as phy_ulmeannl_prb29,avg(phy_ulmeannl_prb30) as phy_ulmeannl_prb30,avg(phy_ulmeannl_prb31) as phy_ulmeannl_prb31,avg(phy_ulmeannl_prb32) as phy_ulmeannl_prb32,avg(phy_ulmeannl_prb33) as phy_ulmeannl_prb33,avg(phy_ulmeannl_prb34) as phy_ulmeannl_prb34,avg(phy_ulmeannl_prb35) as phy_ulmeannl_prb35,avg(phy_ulmeannl_prb36) as phy_ulmeannl_prb36,avg(phy_ulmeannl_prb37) as phy_ulmeannl_prb37,avg(phy_ulmeannl_prb38) as phy_ulmeannl_prb38,avg(phy_ulmeannl_prb39) as phy_ulmeannl_prb39,avg(phy_ulmeannl_prb40) as phy_ulmeannl_prb40,avg(phy_ulmeannl_prb41) as phy_ulmeannl_prb41,avg(phy_ulmeannl_prb42) as phy_ulmeannl_prb42,avg(phy_ulmeannl_prb43) as phy_ulmeannl_prb43,avg(phy_ulmeannl_prb44) as phy_ulmeannl_prb44,avg(phy_ulmeannl_prb45) as phy_ulmeannl_prb45,avg(phy_ulmeannl_prb46) as phy_ulmeannl_prb46,avg(phy_ulmeannl_prb47) as phy_ulmeannl_prb47,avg(phy_ulmeannl_prb48) as phy_ulmeannl_prb48,avg(phy_ulmeannl_prb49) as phy_ulmeannl_prb49,avg(phy_ulmeannl_prb50) as phy_ulmeannl_prb50,avg(phy_ulmeannl_prb51) as phy_ulmeannl_prb51,avg(phy_ulmeannl_prb52) as phy_ulmeannl_prb52,avg(phy_ulmeannl_prb53) as phy_ulmeannl_prb53,avg(phy_ulmeannl_prb54) as phy_ulmeannl_prb54,avg(phy_ulmeannl_prb55) as phy_ulmeannl_prb55,avg(phy_ulmeannl_prb56) as phy_ulmeannl_prb56,avg(phy_ulmeannl_prb57) as phy_ulmeannl_prb57,avg(phy_ulmeannl_prb58) as phy_ulmeannl_prb58,avg(phy_ulmeannl_prb59) as phy_ulmeannl_prb59,avg(phy_ulmeannl_prb60) as phy_ulmeannl_prb60,avg(phy_ulmeannl_prb61) as phy_ulmeannl_prb61,avg(phy_ulmeannl_prb62) as phy_ulmeannl_prb62,avg(phy_ulmeannl_prb63) as phy_ulmeannl_prb63,avg(phy_ulmeannl_prb64) as phy_ulmeannl_prb64,avg(phy_ulmeannl_prb65) as phy_ulmeannl_prb65,avg(phy_ulmeannl_prb66)as phy_ulmeannl_prb66,avg(phy_ulmeannl_prb67) as phy_ulmeannl_prb67,avg(phy_ulmeannl_prb68) as phy_ulmeannl_prb68,avg(phy_ulmeannl_prb69) as phy_ulmeannl_prb69,avg(phy_ulmeannl_prb70) as phy_ulmeannl_prb70,avg(phy_ulmeannl_prb71) as phy_ulmeannl_prb71,avg(phy_ulmeannl_prb72) as phy_ulmeannl_prb72,avg(phy_ulmeannl_prb73) as phy_ulmeannl_prb73,avg(phy_ulmeannl_prb74) as phy_ulmeannl_prb74,avg(phy_ulmeannl_prb75) as phy_ulmeannl_prb75,avg(phy_ulmeannl_prb76) as phy_ulmeannl_prb76,avg(phy_ulmeannl_prb77) as phy_ulmeannl_prb77,avg(phy_ulmeannl_prb78) as phy_ulmeannl_prb78,avg(phy_ulmeannl_prb79) as phy_ulmeannl_prb79,avg(phy_ulmeannl_prb80) as phy_ulmeannl_prb80,avg(phy_ulmeannl_prb81) as phy_ulmeannl_prb81,avg(phy_ulmeannl_prb82) as phy_ulmeannl_prb82,avg(phy_ulmeannl_prb83) as phy_ulmeannl_prb83,avg(phy_ulmeannl_prb84) as phy_ulmeannl_prb84,avg(phy_ulmeannl_prb85) as phy_ulmeannl_prb85,avg(phy_ulmeannl_prb86) as phy_ulmeannl_prb86,avg(phy_ulmeannl_prb87) as phy_ulmeannl_prb87,avg(phy_ulmeannl_prb88) as phy_ulmeannl_prb88,avg(phy_ulmeannl_prb89) as phy_ulmeannl_prb89,avg(phy_ulmeannl_prb90) as phy_ulmeannl_prb90,avg(phy_ulmeannl_prb91) as phy_ulmeannl_prb91,avg(phy_ulmeannl_prb92) as phy_ulmeannl_prb92,avg(phy_ulmeannl_prb93) as phy_ulmeannl_prb93,avg(phy_ulmeannl_prb94) as phy_ulmeannl_prb94,avg(phy_ulmeannl_prb95) as phy_ulmeannl_prb95,avg(phy_ulmeannl_prb96) as phy_ulmeannl_prb96,avg(phy_ulmeannl_prb97) as phy_ulmeannl_prb97,avg(phy_ulmeannl_prb98) as phy_ulmeannl_prb98,avg(phy_ulmeannl_prb99) as phy_ulmeannl_prb99,
avg(phy_ulmaxnl_prb0) as phy_ulmaxnl_prb0,avg(phy_ulmaxnl_prb1) as phy_ulmaxnl_prb1,avg(phy_ulmaxnl_prb2) as phy_ulmaxnl_prb2,avg(phy_ulmaxnl_prb3) as phy_ulmaxnl_prb3,avg(phy_ulmaxnl_prb4) as phy_ulmaxnl_prb4,avg(phy_ulmaxnl_prb5) as phy_ulmaxnl_prb5,avg(phy_ulmaxnl_prb6) as phy_ulmaxnl_prb6,avg(phy_ulmaxnl_prb7) as phy_ulmaxnl_prb7,avg(phy_ulmaxnl_prb8) as phy_ulmaxnl_prb8,avg(phy_ulmaxnl_prb9)as phy_ulmaxnl_prb9,avg(phy_ulmaxnl_prb10) as phy_ulmaxnl_prb10,avg(phy_ulmaxnl_prb11) as phy_ulmaxnl_prb11,avg(phy_ulmaxnl_prb12) as phy_ulmaxnl_prb12,avg(phy_ulmaxnl_prb13) as phy_ulmaxnl_prb13,avg(phy_ulmaxnl_prb14) as phy_ulmaxnl_prb14,avg(phy_ulmaxnl_prb15) as phy_ulmaxnl_prb15,avg(phy_ulmaxnl_prb16) as phy_ulmaxnl_prb16,avg(phy_ulmaxnl_prb17) as phy_ulmaxnl_prb17,avg(phy_ulmaxnl_prb18) as phy_ulmaxnl_prb18,avg(phy_ulmaxnl_prb19) as phy_ulmaxnl_prb19,avg(phy_ulmaxnl_prb20) as phy_ulmaxnl_prb20,avg(phy_ulmaxnl_prb21) as phy_ulmaxnl_prb21,avg(phy_ulmaxnl_prb22) as phy_ulmaxnl_prb22,avg(phy_ulmaxnl_prb23) as phy_ulmaxnl_prb23,avg(phy_ulmaxnl_prb24) as phy_ulmaxnl_prb24,avg(phy_ulmaxnl_prb25) as phy_ulmaxnl_prb25,avg(phy_ulmaxnl_prb26) as phy_ulmaxnl_prb26,avg(phy_ulmaxnl_prb27) as phy_ulmaxnl_prb27,avg(phy_ulmaxnl_prb28) as phy_ulmaxnl_prb28,avg(phy_ulmaxnl_prb29) as phy_ulmaxnl_prb29,avg(phy_ulmaxnl_prb30) as phy_ulmaxnl_prb30,avg(phy_ulmaxnl_prb31) as phy_ulmaxnl_prb31,avg(phy_ulmaxnl_prb32) as phy_ulmaxnl_prb32,avg(phy_ulmaxnl_prb33) as phy_ulmaxnl_prb33,avg(phy_ulmaxnl_prb34) as phy_ulmaxnl_prb34,avg(phy_ulmaxnl_prb35) as phy_ulmaxnl_prb35,avg(phy_ulmaxnl_prb36) as phy_ulmaxnl_prb36,avg(phy_ulmaxnl_prb37) as phy_ulmaxnl_prb37,avg(phy_ulmaxnl_prb38) as phy_ulmaxnl_prb38,avg(phy_ulmaxnl_prb39) as phy_ulmaxnl_prb39,avg(phy_ulmaxnl_prb40) as phy_ulmaxnl_prb40,avg(phy_ulmaxnl_prb41) as phy_ulmaxnl_prb41,avg(phy_ulmaxnl_prb42) as phy_ulmaxnl_prb42,avg(phy_ulmaxnl_prb43) as phy_ulmaxnl_prb43,avg(phy_ulmaxnl_prb44) as phy_ulmaxnl_prb44,avg(phy_ulmaxnl_prb45) as phy_ulmaxnl_prb45,avg(phy_ulmaxnl_prb46) as phy_ulmaxnl_prb46,avg(phy_ulmaxnl_prb47) as phy_ulmaxnl_prb47,avg(phy_ulmaxnl_prb48) as phy_ulmaxnl_prb48,avg(phy_ulmaxnl_prb49) as phy_ulmaxnl_prb49,avg(phy_ulmaxnl_prb50) as phy_ulmaxnl_prb50,avg(phy_ulmaxnl_prb51) as phy_ulmaxnl_prb51,avg(phy_ulmaxnl_prb52) as phy_ulmaxnl_prb52,avg(phy_ulmaxnl_prb53) as phy_ulmaxnl_prb53,avg(phy_ulmaxnl_prb54) as phy_ulmaxnl_prb54,avg(phy_ulmaxnl_prb55) as phy_ulmaxnl_prb55,avg(phy_ulmaxnl_prb56) as phy_ulmaxnl_prb56,avg(phy_ulmaxnl_prb57) as phy_ulmaxnl_prb57,avg(phy_ulmaxnl_prb58) as phy_ulmaxnl_prb58,avg(phy_ulmaxnl_prb59) as phy_ulmaxnl_prb59,avg(phy_ulmaxnl_prb60) as phy_ulmaxnl_prb60,avg(phy_ulmaxnl_prb61) as phy_ulmaxnl_prb61,avg(phy_ulmaxnl_prb62) as phy_ulmaxnl_prb62,avg(phy_ulmaxnl_prb63) as phy_ulmaxnl_prb63,avg(phy_ulmaxnl_prb64) as phy_ulmaxnl_prb64,avg(phy_ulmaxnl_prb65) as phy_ulmaxnl_prb65,avg(phy_ulmaxnl_prb66) as phy_ulmaxnl_prb66,avg(phy_ulmaxnl_prb67) as phy_ulmaxnl_prb67,avg(phy_ulmaxnl_prb68) as phy_ulmaxnl_prb68,avg(phy_ulmaxnl_prb69) as phy_ulmaxnl_prb69,avg(phy_ulmaxnl_prb70) as phy_ulmaxnl_prb70,avg(phy_ulmaxnl_prb71) as phy_ulmaxnl_prb71,avg(phy_ulmaxnl_prb72) as phy_ulmaxnl_prb72,avg(phy_ulmaxnl_prb73) as phy_ulmaxnl_prb73,avg(phy_ulmaxnl_prb74) as phy_ulmaxnl_prb74,avg(phy_ulmaxnl_prb75) as phy_ulmaxnl_prb75,avg(phy_ulmaxnl_prb76) as phy_ulmaxnl_prb76,avg(phy_ulmaxnl_prb77) as phy_ulmaxnl_prb77,avg(phy_ulmaxnl_prb78) as phy_ulmaxnl_prb78,avg(phy_ulmaxnl_prb79) as phy_ulmaxnl_prb79,avg(phy_ulmaxnl_prb80) as phy_ulmaxnl_prb80,avg(phy_ulmaxnl_prb81) as phy_ulmaxnl_prb81,avg(phy_ulmaxnl_prb82) as phy_ulmaxnl_prb82,avg(phy_ulmaxnl_prb83) as phy_ulmaxnl_prb83,avg(phy_ulmaxnl_prb84) as phy_ulmaxnl_prb84,avg(phy_ulmaxnl_prb85) as phy_ulmaxnl_prb85,avg(phy_ulmaxnl_prb86) as phy_ulmaxnl_prb86,avg(phy_ulmaxnl_prb87) as phy_ulmaxnl_prb87,avg(phy_ulmaxnl_prb88) as phy_ulmaxnl_prb88,avg(phy_ulmaxnl_prb89) as phy_ulmaxnl_prb89,avg(phy_ulmaxnl_prb90) as phy_ulmaxnl_prb90,avg(phy_ulmaxnl_prb91) as phy_ulmaxnl_prb91,avg(phy_ulmaxnl_prb92) as phy_ulmaxnl_prb92,avg(phy_ulmaxnl_prb93) as phy_ulmaxnl_prb93,avg(phy_ulmaxnl_prb94) as phy_ulmaxnl_prb94,avg(phy_ulmaxnl_prb95) as phy_ulmaxnl_prb95,avg(phy_ulmaxnl_prb96) as phy_ulmaxnl_prb96,avg(phy_ulmaxnl_prb97) as phy_ulmaxnl_prb97,avg(phy_ulmaxnl_prb98) as phy_ulmaxnl_prb98,avg(phy_ulmaxnl_prb99) as phy_ulmaxnl_prb99 
from PM_EutranCellTdd group by 
substring(FILEHEADER_BEGINTIME,0,10),def_cellname;

drop table AVG_PM_EutranCellTdd_0;
Create table AVG_PM_EutranCellTdd_0 as
select t1.* from AVG_PM_EutranCellTdd t1 join 
(select * from IF_INDEX_14 where if_index<>0) t2 
on t1.def_cellname=t2.def_cellname and t2.ttime=t1.ttime and t1.thour=t2.thour;




DROP TABLE InterferenceType_1;
CREATE TABLE InterferenceType_1 AS
SELECT * FROM 
(SELECT 
DEF_CELLNAME as CELLNAME,
TTIME,
THOUR,
ev1(PHY_ULMEANNL_PRB10,PHY_ULMEANNL_PRB11,PHY_ULMEANNL_PRB12,PHY_ULMEANNL_PRB13,PHY_ULMEANNL_PRB14,PHY_ULMEANNL_PRB15,PHY_ULMEANNL_PRB16,PHY_ULMEANNL_PRB17,PHY_ULMEANNL_PRB18,PHY_ULMEANNL_PRB19,PHY_ULMEANNL_PRB20,PHY_ULMEANNL_PRB21,PHY_ULMEANNL_PRB22,PHY_ULMEANNL_PRB23,PHY_ULMEANNL_PRB24,PHY_ULMEANNL_PRB25,PHY_ULMEANNL_PRB26,PHY_ULMEANNL_PRB27,PHY_ULMEANNL_PRB28,PHY_ULMEANNL_PRB29,PHY_ULMEANNL_PRB30,PHY_ULMEANNL_PRB31,PHY_ULMEANNL_PRB32,PHY_ULMEANNL_PRB33,PHY_ULMEANNL_PRB34,PHY_ULMEANNL_PRB35,PHY_ULMEANNL_PRB36,PHY_ULMEANNL_PRB37,PHY_ULMEANNL_PRB38,PHY_ULMEANNL_PRB39,PHY_ULMEANNL_PRB40,PHY_ULMEANNL_PRB41,PHY_ULMEANNL_PRB42,PHY_ULMEANNL_PRB43,PHY_ULMEANNL_PRB44,PHY_ULMEANNL_PRB45,PHY_ULMEANNL_PRB46,PHY_ULMEANNL_PRB47,PHY_ULMEANNL_PRB48,PHY_ULMEANNL_PRB49,PHY_ULMEANNL_PRB50,PHY_ULMEANNL_PRB51,PHY_ULMEANNL_PRB52,PHY_ULMEANNL_PRB53,PHY_ULMEANNL_PRB54,PHY_ULMEANNL_PRB55,PHY_ULMEANNL_PRB56,PHY_ULMEANNL_PRB57,PHY_ULMEANNL_PRB58,PHY_ULMEANNL_PRB59,PHY_ULMEANNL_PRB60,PHY_ULMEANNL_PRB61,PHY_ULMEANNL_PRB62,PHY_ULMEANNL_PRB63,PHY_ULMEANNL_PRB64,PHY_ULMEANNL_PRB65,PHY_ULMEANNL_PRB66,PHY_ULMEANNL_PRB67,PHY_ULMEANNL_PRB68,PHY_ULMEANNL_PRB69,PHY_ULMEANNL_PRB70,PHY_ULMEANNL_PRB71,PHY_ULMEANNL_PRB72,PHY_ULMEANNL_PRB73,PHY_ULMEANNL_PRB74,PHY_ULMEANNL_PRB75,PHY_ULMEANNL_PRB76,PHY_ULMEANNL_PRB77,PHY_ULMEANNL_PRB78,PHY_ULMEANNL_PRB79,PHY_ULMEANNL_PRB80,PHY_ULMEANNL_PRB81,PHY_ULMEANNL_PRB82,PHY_ULMEANNL_PRB83,PHY_ULMEANNL_PRB84,PHY_ULMEANNL_PRB85,PHY_ULMEANNL_PRB86,PHY_ULMEANNL_PRB87,PHY_ULMEANNL_PRB88,PHY_ULMEANNL_PRB89)
as avg_if,
ev2(PHY_ULMEANNL_PRB10,PHY_ULMEANNL_PRB11,PHY_ULMEANNL_PRB12,PHY_ULMEANNL_PRB13,PHY_ULMEANNL_PRB14,PHY_ULMEANNL_PRB15,PHY_ULMEANNL_PRB16,PHY_ULMEANNL_PRB17,PHY_ULMEANNL_PRB18,PHY_ULMEANNL_PRB19,PHY_ULMEANNL_PRB20,PHY_ULMEANNL_PRB21,PHY_ULMEANNL_PRB22,PHY_ULMEANNL_PRB23,PHY_ULMEANNL_PRB24,PHY_ULMEANNL_PRB25,PHY_ULMEANNL_PRB26,PHY_ULMEANNL_PRB27,PHY_ULMEANNL_PRB28,PHY_ULMEANNL_PRB29,PHY_ULMEANNL_PRB30,PHY_ULMEANNL_PRB31,PHY_ULMEANNL_PRB32,PHY_ULMEANNL_PRB33,PHY_ULMEANNL_PRB34,PHY_ULMEANNL_PRB35,PHY_ULMEANNL_PRB36,PHY_ULMEANNL_PRB37,PHY_ULMEANNL_PRB38,PHY_ULMEANNL_PRB39,PHY_ULMEANNL_PRB40,PHY_ULMEANNL_PRB41,PHY_ULMEANNL_PRB42,PHY_ULMEANNL_PRB43,PHY_ULMEANNL_PRB44,PHY_ULMEANNL_PRB45,PHY_ULMEANNL_PRB46,PHY_ULMEANNL_PRB47,PHY_ULMEANNL_PRB48,PHY_ULMEANNL_PRB49,PHY_ULMEANNL_PRB50,PHY_ULMEANNL_PRB51,PHY_ULMEANNL_PRB52,PHY_ULMEANNL_PRB53,PHY_ULMEANNL_PRB54,PHY_ULMEANNL_PRB55,PHY_ULMEANNL_PRB56,PHY_ULMEANNL_PRB57,PHY_ULMEANNL_PRB58,PHY_ULMEANNL_PRB59,PHY_ULMEANNL_PRB60,PHY_ULMEANNL_PRB61,PHY_ULMEANNL_PRB62,PHY_ULMEANNL_PRB63,PHY_ULMEANNL_PRB64,PHY_ULMEANNL_PRB65,PHY_ULMEANNL_PRB66,PHY_ULMEANNL_PRB67,PHY_ULMEANNL_PRB68,PHY_ULMEANNL_PRB69,PHY_ULMEANNL_PRB70,PHY_ULMEANNL_PRB71,PHY_ULMEANNL_PRB72,PHY_ULMEANNL_PRB73,PHY_ULMEANNL_PRB74,PHY_ULMEANNL_PRB75,PHY_ULMEANNL_PRB76,PHY_ULMEANNL_PRB77,PHY_ULMEANNL_PRB78,PHY_ULMEANNL_PRB79,PHY_ULMEANNL_PRB80,PHY_ULMEANNL_PRB81,PHY_ULMEANNL_PRB82,PHY_ULMEANNL_PRB83,PHY_ULMEANNL_PRB84,PHY_ULMEANNL_PRB85,PHY_ULMEANNL_PRB86,PHY_ULMEANNL_PRB87,PHY_ULMEANNL_PRB88,PHY_ULMEANNL_PRB89)
as variance,
ev3(PHY_ULMEANNL_PRB0,PHY_ULMEANNL_PRB1,PHY_ULMEANNL_PRB2,PHY_ULMEANNL_PRB3,PHY_ULMEANNL_PRB4,PHY_ULMEANNL_PRB5,PHY_ULMEANNL_PRB6,PHY_ULMEANNL_PRB7,PHY_ULMEANNL_PRB8,PHY_ULMEANNL_PRB9,PHY_ULMEANNL_PRB10,PHY_ULMEANNL_PRB11,PHY_ULMEANNL_PRB12,PHY_ULMEANNL_PRB13,PHY_ULMEANNL_PRB14,PHY_ULMEANNL_PRB15,PHY_ULMEANNL_PRB16,PHY_ULMEANNL_PRB17,PHY_ULMEANNL_PRB18,PHY_ULMEANNL_PRB19,PHY_ULMEANNL_PRB20,PHY_ULMEANNL_PRB21,PHY_ULMEANNL_PRB22,PHY_ULMEANNL_PRB23,PHY_ULMEANNL_PRB24,PHY_ULMEANNL_PRB25,PHY_ULMEANNL_PRB26,PHY_ULMEANNL_PRB27,PHY_ULMEANNL_PRB28,PHY_ULMEANNL_PRB29,PHY_ULMEANNL_PRB30,PHY_ULMEANNL_PRB31,PHY_ULMEANNL_PRB32,PHY_ULMEANNL_PRB33,PHY_ULMEANNL_PRB34,PHY_ULMEANNL_PRB35,PHY_ULMEANNL_PRB36,PHY_ULMEANNL_PRB37,PHY_ULMEANNL_PRB38,PHY_ULMEANNL_PRB39,PHY_ULMEANNL_PRB40,PHY_ULMEANNL_PRB41,PHY_ULMEANNL_PRB42,PHY_ULMEANNL_PRB43,PHY_ULMEANNL_PRB44,PHY_ULMEANNL_PRB45,PHY_ULMEANNL_PRB46,PHY_ULMEANNL_PRB47,PHY_ULMEANNL_PRB48,PHY_ULMEANNL_PRB49,PHY_ULMEANNL_PRB50,PHY_ULMEANNL_PRB51,PHY_ULMEANNL_PRB52,PHY_ULMEANNL_PRB53,PHY_ULMEANNL_PRB54,PHY_ULMEANNL_PRB55,PHY_ULMEANNL_PRB56,PHY_ULMEANNL_PRB57,PHY_ULMEANNL_PRB58,PHY_ULMEANNL_PRB59,PHY_ULMEANNL_PRB60,PHY_ULMEANNL_PRB61,PHY_ULMEANNL_PRB62,PHY_ULMEANNL_PRB63,PHY_ULMEANNL_PRB64,PHY_ULMEANNL_PRB65,PHY_ULMEANNL_PRB66,PHY_ULMEANNL_PRB67,PHY_ULMEANNL_PRB68,PHY_ULMEANNL_PRB69,PHY_ULMEANNL_PRB70,PHY_ULMEANNL_PRB71,PHY_ULMEANNL_PRB72,PHY_ULMEANNL_PRB73,PHY_ULMEANNL_PRB74,PHY_ULMEANNL_PRB75,PHY_ULMEANNL_PRB76,PHY_ULMEANNL_PRB77,PHY_ULMEANNL_PRB78,PHY_ULMEANNL_PRB79,PHY_ULMEANNL_PRB80,PHY_ULMEANNL_PRB81,PHY_ULMEANNL_PRB82,PHY_ULMEANNL_PRB83,PHY_ULMEANNL_PRB84,PHY_ULMEANNL_PRB85,PHY_ULMEANNL_PRB86,PHY_ULMEANNL_PRB87,PHY_ULMEANNL_PRB88,PHY_ULMEANNL_PRB89,PHY_ULMEANNL_PRB90,PHY_ULMEANNL_PRB91,PHY_ULMEANNL_PRB92,PHY_ULMEANNL_PRB93,PHY_ULMEANNL_PRB94,PHY_ULMEANNL_PRB95,PHY_ULMEANNL_PRB96,PHY_ULMEANNL_PRB97,PHY_ULMEANNL_PRB98,PHY_ULMEANNL_PRB99)
as slope_k,
ev4(PHY_ULMEANNL_PRB0,PHY_ULMEANNL_PRB1,PHY_ULMEANNL_PRB2,PHY_ULMEANNL_PRB3,PHY_ULMEANNL_PRB4,PHY_ULMEANNL_PRB5,PHY_ULMEANNL_PRB6,PHY_ULMEANNL_PRB7,PHY_ULMEANNL_PRB8,PHY_ULMEANNL_PRB9,PHY_ULMEANNL_PRB10,PHY_ULMEANNL_PRB11,PHY_ULMEANNL_PRB12,PHY_ULMEANNL_PRB13,PHY_ULMEANNL_PRB14,PHY_ULMEANNL_PRB15,PHY_ULMEANNL_PRB16,PHY_ULMEANNL_PRB17,PHY_ULMEANNL_PRB18,PHY_ULMEANNL_PRB19,PHY_ULMEANNL_PRB20,PHY_ULMEANNL_PRB21,PHY_ULMEANNL_PRB22,PHY_ULMEANNL_PRB23,PHY_ULMEANNL_PRB24,PHY_ULMEANNL_PRB25,PHY_ULMEANNL_PRB26,PHY_ULMEANNL_PRB27,PHY_ULMEANNL_PRB28,PHY_ULMEANNL_PRB29,PHY_ULMEANNL_PRB30,PHY_ULMEANNL_PRB31,PHY_ULMEANNL_PRB32,PHY_ULMEANNL_PRB33,PHY_ULMEANNL_PRB34,PHY_ULMEANNL_PRB35,PHY_ULMEANNL_PRB36,PHY_ULMEANNL_PRB37,PHY_ULMEANNL_PRB38,PHY_ULMEANNL_PRB39,PHY_ULMEANNL_PRB40,PHY_ULMEANNL_PRB41,PHY_ULMEANNL_PRB42,PHY_ULMEANNL_PRB43,PHY_ULMEANNL_PRB44,PHY_ULMEANNL_PRB45,PHY_ULMEANNL_PRB46,PHY_ULMEANNL_PRB47,PHY_ULMEANNL_PRB48,PHY_ULMEANNL_PRB49,PHY_ULMEANNL_PRB50,PHY_ULMEANNL_PRB51,PHY_ULMEANNL_PRB52,PHY_ULMEANNL_PRB53,PHY_ULMEANNL_PRB54,PHY_ULMEANNL_PRB55,PHY_ULMEANNL_PRB56,PHY_ULMEANNL_PRB57,PHY_ULMEANNL_PRB58,PHY_ULMEANNL_PRB59,PHY_ULMEANNL_PRB60,PHY_ULMEANNL_PRB61,PHY_ULMEANNL_PRB62,PHY_ULMEANNL_PRB63,PHY_ULMEANNL_PRB64,PHY_ULMEANNL_PRB65,PHY_ULMEANNL_PRB66,PHY_ULMEANNL_PRB67,PHY_ULMEANNL_PRB68,PHY_ULMEANNL_PRB69,PHY_ULMEANNL_PRB70,PHY_ULMEANNL_PRB71,PHY_ULMEANNL_PRB72,PHY_ULMEANNL_PRB73,PHY_ULMEANNL_PRB74,PHY_ULMEANNL_PRB75,PHY_ULMEANNL_PRB76,PHY_ULMEANNL_PRB77,PHY_ULMEANNL_PRB78,PHY_ULMEANNL_PRB79,PHY_ULMEANNL_PRB80,PHY_ULMEANNL_PRB81,PHY_ULMEANNL_PRB82,PHY_ULMEANNL_PRB83,PHY_ULMEANNL_PRB84,PHY_ULMEANNL_PRB85,PHY_ULMEANNL_PRB86,PHY_ULMEANNL_PRB87,PHY_ULMEANNL_PRB88,PHY_ULMEANNL_PRB89,PHY_ULMEANNL_PRB90,PHY_ULMEANNL_PRB91,PHY_ULMEANNL_PRB92,PHY_ULMEANNL_PRB93,PHY_ULMEANNL_PRB94,PHY_ULMEANNL_PRB95,PHY_ULMEANNL_PRB96,PHY_ULMEANNL_PRB97,PHY_ULMEANNL_PRB98,PHY_ULMEANNL_PRB99)
as position,
ev5(PHY_ULMEANNL_PRB5,PHY_ULMEANNL_PRB6,PHY_ULMEANNL_PRB7,PHY_ULMEANNL_PRB8,PHY_ULMEANNL_PRB9,PHY_ULMEANNL_PRB10,PHY_ULMEANNL_PRB11,PHY_ULMEANNL_PRB12,PHY_ULMEANNL_PRB13,PHY_ULMEANNL_PRB14,PHY_ULMEANNL_PRB15,PHY_ULMEANNL_PRB16,PHY_ULMEANNL_PRB17,PHY_ULMEANNL_PRB18,PHY_ULMEANNL_PRB19,PHY_ULMEANNL_PRB20,PHY_ULMEANNL_PRB21,PHY_ULMEANNL_PRB22,PHY_ULMEANNL_PRB23,PHY_ULMEANNL_PRB24,PHY_ULMEANNL_PRB25,PHY_ULMEANNL_PRB26,PHY_ULMEANNL_PRB27,PHY_ULMEANNL_PRB28,PHY_ULMEANNL_PRB29,PHY_ULMEANNL_PRB30,PHY_ULMEANNL_PRB31,PHY_ULMEANNL_PRB32,PHY_ULMEANNL_PRB33,PHY_ULMEANNL_PRB34,PHY_ULMEANNL_PRB35,PHY_ULMEANNL_PRB36,PHY_ULMEANNL_PRB37,PHY_ULMEANNL_PRB38,PHY_ULMEANNL_PRB39,PHY_ULMEANNL_PRB40,PHY_ULMEANNL_PRB41,PHY_ULMEANNL_PRB42,PHY_ULMEANNL_PRB43,PHY_ULMEANNL_PRB44,PHY_ULMEANNL_PRB45,PHY_ULMEANNL_PRB46,PHY_ULMEANNL_PRB47,PHY_ULMEANNL_PRB48,PHY_ULMEANNL_PRB49,PHY_ULMEANNL_PRB50,PHY_ULMEANNL_PRB51,PHY_ULMEANNL_PRB52,PHY_ULMEANNL_PRB53,PHY_ULMEANNL_PRB54,PHY_ULMEANNL_PRB55,PHY_ULMEANNL_PRB56,PHY_ULMEANNL_PRB57,PHY_ULMEANNL_PRB58,PHY_ULMEANNL_PRB59,PHY_ULMEANNL_PRB60,PHY_ULMEANNL_PRB61,PHY_ULMEANNL_PRB62,PHY_ULMEANNL_PRB63,PHY_ULMEANNL_PRB64,PHY_ULMEANNL_PRB65,PHY_ULMEANNL_PRB66,PHY_ULMEANNL_PRB67,PHY_ULMEANNL_PRB68,PHY_ULMEANNL_PRB69,PHY_ULMEANNL_PRB70,PHY_ULMEANNL_PRB71,PHY_ULMEANNL_PRB72,PHY_ULMEANNL_PRB73,PHY_ULMEANNL_PRB74,PHY_ULMEANNL_PRB75,PHY_ULMEANNL_PRB76,PHY_ULMEANNL_PRB77,PHY_ULMEANNL_PRB78,PHY_ULMEANNL_PRB79,PHY_ULMEANNL_PRB80,PHY_ULMEANNL_PRB81,PHY_ULMEANNL_PRB82,PHY_ULMEANNL_PRB83,PHY_ULMEANNL_PRB84,PHY_ULMEANNL_PRB85,PHY_ULMEANNL_PRB86,PHY_ULMEANNL_PRB87,PHY_ULMEANNL_PRB88,PHY_ULMEANNL_PRB89,PHY_ULMEANNL_PRB90,PHY_ULMEANNL_PRB91,PHY_ULMEANNL_PRB92,PHY_ULMEANNL_PRB93,PHY_ULMEANNL_PRB94,PHY_ULMEANNL_PRB95)
as peak_position,
ev6(PHY_ULMEANNL_PRB0,PHY_ULMEANNL_PRB1,PHY_ULMEANNL_PRB2,PHY_ULMEANNL_PRB3,PHY_ULMEANNL_PRB4,PHY_ULMEANNL_PRB5,PHY_ULMEANNL_PRB6,PHY_ULMEANNL_PRB7,PHY_ULMEANNL_PRB8,PHY_ULMEANNL_PRB9,PHY_ULMEANNL_PRB10,PHY_ULMEANNL_PRB11,PHY_ULMEANNL_PRB12,PHY_ULMEANNL_PRB13,PHY_ULMEANNL_PRB14,PHY_ULMEANNL_PRB15,PHY_ULMEANNL_PRB16,PHY_ULMEANNL_PRB17,PHY_ULMEANNL_PRB18,PHY_ULMEANNL_PRB19,PHY_ULMEANNL_PRB20,PHY_ULMEANNL_PRB21,PHY_ULMEANNL_PRB22,PHY_ULMEANNL_PRB23,PHY_ULMEANNL_PRB24,PHY_ULMEANNL_PRB25,PHY_ULMEANNL_PRB26,PHY_ULMEANNL_PRB27,PHY_ULMEANNL_PRB28,PHY_ULMEANNL_PRB29,PHY_ULMEANNL_PRB30,PHY_ULMEANNL_PRB31,PHY_ULMEANNL_PRB32,PHY_ULMEANNL_PRB33,PHY_ULMEANNL_PRB34,PHY_ULMEANNL_PRB35,PHY_ULMEANNL_PRB36,PHY_ULMEANNL_PRB37,PHY_ULMEANNL_PRB38,PHY_ULMEANNL_PRB39,PHY_ULMEANNL_PRB40,PHY_ULMEANNL_PRB41,PHY_ULMEANNL_PRB42,PHY_ULMEANNL_PRB43,PHY_ULMEANNL_PRB44,PHY_ULMEANNL_PRB45,PHY_ULMEANNL_PRB46,PHY_ULMEANNL_PRB47,PHY_ULMEANNL_PRB48,PHY_ULMEANNL_PRB49,PHY_ULMEANNL_PRB50,PHY_ULMEANNL_PRB51,PHY_ULMEANNL_PRB52,PHY_ULMEANNL_PRB53,PHY_ULMEANNL_PRB54,PHY_ULMEANNL_PRB55,PHY_ULMEANNL_PRB56,PHY_ULMEANNL_PRB57,PHY_ULMEANNL_PRB58,PHY_ULMEANNL_PRB59,PHY_ULMEANNL_PRB60,PHY_ULMEANNL_PRB61,PHY_ULMEANNL_PRB62,PHY_ULMEANNL_PRB63,PHY_ULMEANNL_PRB64,PHY_ULMEANNL_PRB65,PHY_ULMEANNL_PRB66,PHY_ULMEANNL_PRB67,PHY_ULMEANNL_PRB68,PHY_ULMEANNL_PRB69,PHY_ULMEANNL_PRB70,PHY_ULMEANNL_PRB71,PHY_ULMEANNL_PRB72,PHY_ULMEANNL_PRB73,PHY_ULMEANNL_PRB74,PHY_ULMEANNL_PRB75,PHY_ULMEANNL_PRB76,PHY_ULMEANNL_PRB77,PHY_ULMEANNL_PRB78,PHY_ULMEANNL_PRB79,PHY_ULMEANNL_PRB80,PHY_ULMEANNL_PRB81,PHY_ULMEANNL_PRB82,PHY_ULMEANNL_PRB83,PHY_ULMEANNL_PRB84,PHY_ULMEANNL_PRB85,PHY_ULMEANNL_PRB86,PHY_ULMEANNL_PRB87,PHY_ULMEANNL_PRB88,PHY_ULMEANNL_PRB89,PHY_ULMEANNL_PRB90,PHY_ULMEANNL_PRB91,PHY_ULMEANNL_PRB92,PHY_ULMEANNL_PRB93,PHY_ULMEANNL_PRB94,PHY_ULMEANNL_PRB95,PHY_ULMEANNL_PRB96,PHY_ULMEANNL_PRB97,PHY_ULMEANNL_PRB98,PHY_ULMEANNL_PRB99)
as left_max_right,
ev13(PHY_ULMEANNL_PRB0,PHY_ULMEANNL_PRB1,PHY_ULMEANNL_PRB2,PHY_ULMEANNL_PRB3,PHY_ULMEANNL_PRB4,PHY_ULMEANNL_PRB5,PHY_ULMEANNL_PRB6,PHY_ULMEANNL_PRB7,PHY_ULMEANNL_PRB8,PHY_ULMEANNL_PRB9,PHY_ULMEANNL_PRB10,PHY_ULMEANNL_PRB11,PHY_ULMEANNL_PRB12,PHY_ULMEANNL_PRB13,PHY_ULMEANNL_PRB14,PHY_ULMEANNL_PRB15,PHY_ULMEANNL_PRB16,PHY_ULMEANNL_PRB17,PHY_ULMEANNL_PRB18,PHY_ULMEANNL_PRB19,PHY_ULMEANNL_PRB20,PHY_ULMEANNL_PRB21,PHY_ULMEANNL_PRB22,PHY_ULMEANNL_PRB23,PHY_ULMEANNL_PRB24,PHY_ULMEANNL_PRB25,PHY_ULMEANNL_PRB26,PHY_ULMEANNL_PRB27,PHY_ULMEANNL_PRB28,PHY_ULMEANNL_PRB29,PHY_ULMEANNL_PRB30,PHY_ULMEANNL_PRB31,PHY_ULMEANNL_PRB32,PHY_ULMEANNL_PRB33,PHY_ULMEANNL_PRB34,PHY_ULMEANNL_PRB35,PHY_ULMEANNL_PRB36,PHY_ULMEANNL_PRB37,PHY_ULMEANNL_PRB38,PHY_ULMEANNL_PRB39,PHY_ULMEANNL_PRB40,PHY_ULMEANNL_PRB41,PHY_ULMEANNL_PRB42,PHY_ULMEANNL_PRB43,PHY_ULMEANNL_PRB44,PHY_ULMEANNL_PRB45,PHY_ULMEANNL_PRB46,PHY_ULMEANNL_PRB47,PHY_ULMEANNL_PRB48,PHY_ULMEANNL_PRB49,PHY_ULMEANNL_PRB50,PHY_ULMEANNL_PRB51,PHY_ULMEANNL_PRB52,PHY_ULMEANNL_PRB53,PHY_ULMEANNL_PRB54,PHY_ULMEANNL_PRB55,PHY_ULMEANNL_PRB56,PHY_ULMEANNL_PRB57,PHY_ULMEANNL_PRB58,PHY_ULMEANNL_PRB59,PHY_ULMEANNL_PRB60,PHY_ULMEANNL_PRB61,PHY_ULMEANNL_PRB62,PHY_ULMEANNL_PRB63,PHY_ULMEANNL_PRB64,PHY_ULMEANNL_PRB65,PHY_ULMEANNL_PRB66,PHY_ULMEANNL_PRB67,PHY_ULMEANNL_PRB68,PHY_ULMEANNL_PRB69,PHY_ULMEANNL_PRB70,PHY_ULMEANNL_PRB71,PHY_ULMEANNL_PRB72,PHY_ULMEANNL_PRB73,PHY_ULMEANNL_PRB74,PHY_ULMEANNL_PRB75,PHY_ULMEANNL_PRB76,PHY_ULMEANNL_PRB77,PHY_ULMEANNL_PRB78,PHY_ULMEANNL_PRB79,PHY_ULMEANNL_PRB80,PHY_ULMEANNL_PRB81,PHY_ULMEANNL_PRB82,PHY_ULMEANNL_PRB83,PHY_ULMEANNL_PRB84,PHY_ULMEANNL_PRB85,PHY_ULMEANNL_PRB86,PHY_ULMEANNL_PRB87,PHY_ULMEANNL_PRB88,PHY_ULMEANNL_PRB89,PHY_ULMEANNL_PRB90,PHY_ULMEANNL_PRB91,PHY_ULMEANNL_PRB92,PHY_ULMEANNL_PRB93,PHY_ULMEANNL_PRB94,PHY_ULMEANNL_PRB95,PHY_ULMEANNL_PRB96,PHY_ULMEANNL_PRB97,PHY_ULMEANNL_PRB98,PHY_ULMEANNL_PRB99)
as max_if_val
FROM 
AVG_PM_EutranCellTdd_0 where 
ttime='{select_date}') t1 join SITE_INFO t2 on t1.CELLNAME=t2.DEF_CELLNAME;


--创建参数临时表
DROP TABLE IF_PARAM_TABLE_1;
CREATE TABLE IF_PARAM_TABLE_1 AS
SELECT VALUE1 AS P1_V1,OPERATOR1 AS P1_OP1 FROM 
PARAM_CONFIG WHERE PARAM='VAR_IF_THRESHOLD';

DROP TABLE IF_PARAM_TABLE_2;
CREATE TABLE IF_PARAM_TABLE_2 AS
SELECT VALUE1 AS P2_V1,OPERATOR1 AS P2_OP1 FROM 
PARAM_CONFIG WHERE PARAM='VAE_IF_THRESHOLD';

DROP TABLE IF_PARAM_TABLE_3;
CREATE TABLE IF_PARAM_TABLE_3 AS
SELECT VALUE1 AS P3_V1,OPERATOR1 AS P3_OP1 FROM 
PARAM_CONFIG WHERE PARAM='STRAYK_IF_THRESHOLD';

DROP TABLE IF_PARAM_TABLE_4;
CREATE TABLE IF_PARAM_TABLE_4 AS
SELECT VALUE1 AS P4_V1,OPERATOR1 AS P4_OP1 FROM 
PARAM_CONFIG WHERE PARAM='OTHK_IF_THRESHOLD';

DROP TABLE IF_PARAM_TABLE_5;
CREATE TABLE IF_PARAM_TABLE_5 AS
SELECT VALUE1 AS P5_V1,OPERATOR1 AS P5_OP1,VALUE2 AS P5_V2,OPERATOR2 AS P5_OP2,LOGIC AS P5_LOGIC FROM 
PARAM_CONFIG WHERE PARAM='MLOC_IF_BLO';

DROP TABLE IF_PARAM_TABLE_6_0;
CREATE TABLE IF_PARAM_TABLE_6_0 AS
SELECT VALUE1 AS P60_V1,OPERATOR1 AS P60_OP1 FROM 
PARAM_CONFIG WHERE PARAM='peak1to2';


DROP TABLE IF_PARAM_TABLE_6;
CREATE TABLE IF_PARAM_TABLE_6 AS
SELECT VALUE1 AS P6_V1,OPERATOR1 AS P6_OP1,VALUE2 AS P6_V2,OPERATOR2 AS P6_OP2,LOGIC AS P6_LOGIC FROM 
PARAM_CONFIG WHERE PARAM='MLOC_IF_TSF';

DROP TABLE IF_PARAM_TABLE_7;
CREATE TABLE IF_PARAM_TABLE_7 AS
SELECT VALUE1 AS P7_V1,OPERATOR1 AS P7_OP1 FROM 
PARAM_CONFIG WHERE PARAM='IMA_IF_PEAKNM';

DROP TABLE IF_PARAM_TABLE_8;
CREATE TABLE IF_PARAM_TABLE_8 AS
SELECT VALUE1 AS P8_V1,OPERATOR1 AS P8_OP1 FROM 
PARAM_CONFIG WHERE PARAM='GPS_IF_PEAKLOCO';

DROP TABLE IF_PARAM_TABLE_9;
CREATE TABLE IF_PARAM_TABLE_9 AS
SELECT VALUE1 AS P9_V1,OPERATOR1 AS P9_OP1 FROM 
PARAM_CONFIG WHERE PARAM='GPS_IF_PEAKLOCTW';

DROP TABLE IF_PARAM_TABLE_10;
CREATE TABLE IF_PARAM_TABLE_10 AS
SELECT VALUE1 AS P10_V1,OPERATOR1 AS P10_OP1,VALUE2 AS P10_V2,OPERATOR2 AS P10_OP2,LOGIC AS P10_LOGIC FROM 
PARAM_CONFIG WHERE PARAM='GPS_IF_PEAKLOCTH';

DROP TABLE IF_PARAM_TABLE_11;
CREATE TABLE IF_PARAM_TABLE_11 AS
SELECT VALUE1 AS P11_V1,OPERATOR1 AS P11_OP1,VALUE2 AS P11_V2,OPERATOR2 AS P11_OP2,LOGIC AS P11_LOGIC FROM 
PARAM_CONFIG WHERE PARAM='VAR_IF_THRESHOLD2';

DROP TABLE IF_PARAM_TABLE_12;
CREATE TABLE IF_PARAM_TABLE_12 AS
SELECT VALUE1 AS P12_V1,OPERATOR1 AS P12_OP1,VALUE2 AS P12_V2,OPERATOR2 AS P12_OP2,LOGIC AS P12_LOGIC FROM 
PARAM_CONFIG WHERE PARAM='IMA_IF_PEAKNM2';


DROP TABLE IF_PARAM_TABLE_13;
CREATE TABLE IF_PARAM_TABLE_13 AS
SELECT VALUE1 AS P13_V1,OPERATOR1 AS P13_OP1 FROM 
PARAM_CONFIG WHERE PARAM='max_avg1';

DROP TABLE IF_PARAM_TABLE_14;
CREATE TABLE IF_PARAM_TABLE_14 AS
SELECT VALUE1 AS P14_V1,OPERATOR1 AS P14_OP1 FROM 
PARAM_CONFIG WHERE PARAM='max_avg2';

DROP TABLE IF_PARAM_TABLE_15;
CREATE TABLE IF_PARAM_TABLE_15 AS
SELECT VALUE1 AS P15_V1,OPERATOR1 AS P15_OP1 FROM 
PARAM_CONFIG WHERE PARAM='max_avg3';

----宽频干扰----
DROP TABLE IF_Type_Table_1;
CREATE TABLE IF_Type_Table_1 AS
SELECT 
cellname,TTIME,THOUR,CITY,region,town,grid,def_cellname_chinese,
ev7(variance,avg_if,P1_V1,P1_OP1,P2_V1,P2_OP1) as flag,
concat('方差',variance,'<',P1_V1,'且平均干扰值',avg_if,'>',P2_V1) as p_describe 
FROM 
IF_PARAM_TABLE_1,IF_PARAM_TABLE_2,InterferenceType_1;

---杂散干扰
DROP TABLE IF_Type_Table_2;
CREATE TABLE IF_Type_Table_2 AS
SELECT
cellname,TTIME,THOUR,CITY,region,town,grid,def_cellname_chinese,
ev8(slope_k,P3_OP1,P3_V1) as flag,
concat('斜率',slope_k,'<',P3_V1) as p_describe
FROM
IF_PARAM_TABLE_3,InterferenceType_1;

---其他干扰
DROP TABLE IF_Type_Table_3;
CREATE TABLE IF_Type_Table_3 AS
SELECT
cellname,TTIME,THOUR,CITY,region,town,grid,def_cellname_chinese,
ev8(slope_k,P4_OP1,P4_V1) as flag,
concat('斜率',slope_k,'>',P4_V1) as p_describe
FROM
IF_PARAM_TABLE_4,InterferenceType_1;

------阻塞干扰---
DROP TABLE IF_Type_Table_4;
CREATE TABLE IF_Type_Table_4 AS 
SELECT 
cellname,TTIME,THOUR,CITY,region,town,grid,def_cellname_chinese,
ev10(max_if_val,avg_if,P13_OP1,P13_V1,slope_k,position,P5_V1,P5_OP1,P5_V2,P5_OP2,P5_LOGIC) as flag,
concat("PRB",position,'>=',P5_V1,'与',position,'<=',P5_V2,"并且斜率",slope_k,"大于-0.05") as p_describe 
FROM 
IF_PARAM_TABLE_13,IF_PARAM_TABLE_5,InterferenceType_1;

---同频干扰
DROP TABLE IF_Type_Table_5;
CREATE TABLE IF_Type_Table_5 AS
SELECT
cellname,TTIME,THOUR,CITY,region,town,grid,def_cellname_chinese,
ev11(max_if_val,avg_if,P15_OP1,P15_V1,peak_position,P60_V1,P60_OP1,position,left_max_right,P6_V1,P6_OP1,P6_V2,P6_OP2,P6_LOGIC) as flag,
concat('PRB',position,'>=',P6_V1,'与','PRB',position,'<=',P6_V2,'且PRB',position+1,'或者PRB',position-1,'对应的干扰电平值和PRB',position,'对应的干扰电平值方差小于0.001') as p_describe
FROM
IF_PARAM_TABLE_15,IF_PARAM_TABLE_6,IF_PARAM_TABLE_6_0,InterferenceType_1;

---GPS干扰  /  互调干扰
DROP TABLE IF_Type_Table_6;
CREATE TABLE IF_Type_Table_6 AS
SELECT
cellname,TTIME,THOUR,CITY,region,town,grid,def_cellname_chinese,
ev12(max_if_val,avg_if,P14_OP1,P14_V1,variance,P11_OP1,P11_V1,P12_OP1,P12_V1,peak_position,P7_V1,P7_OP1,P8_V1,P8_OP1,P9_V1,P9_OP1,P10_V1,P10_OP1,P10_V2,P10_OP2,P10_LOGIC) as flag,
concat('波峰',peak_position,' 波峰个数>=',P7_V1,"并且有3个波峰位置在7,92,[50~52]为GPS干扰，否则，干扰为互调干扰。") as p_describe
FROM
IF_PARAM_TABLE_14,IF_PARAM_TABLE_7,IF_PARAM_TABLE_8,IF_PARAM_TABLE_9,IF_PARAM_TABLE_10,IF_PARAM_TABLE_11,IF_PARAM_TABLE_12,InterferenceType_1;


DROP TABLE PROPERTIES_DB_3;

CREATE TABLE PROPERTIES_DB_3 AS
SELECT cellname AS DEF_CELLNAME,'干扰' AS TYPE1,'上行干扰' AS TYPE2,'宽频干扰' AS TYPE3,
cellname AS FAULT_OBJECT,TTIME,CITY,region,town,grid,p_describe AS FAULT_DESCRIPTION,
'原因' AS LABEL,THOUR,def_cellname_chinese
FROM 
IF_Type_Table_1 where flag=1;

INSERT INTO TABLE PROPERTIES_DB_3
SELECT cellname AS DEF_CELLNAME,'干扰' AS TYPE1,'上行干扰' AS TYPE2,'杂散干扰' AS TYPE3,
cellname AS FAULT_OBJECT,TTIME,CITY,region,town,grid,p_describe AS FAULT_DESCRIPTION,
'原因' AS LABEL,THOUR,def_cellname_chinese
FROM 
IF_Type_Table_2 where flag=1;

INSERT INTO TABLE PROPERTIES_DB_3
SELECT cellname AS DEF_CELLNAME,'干扰' AS TYPE1,'上行干扰' AS TYPE2,'其他干扰' AS TYPE3,
cellname AS FAULT_OBJECT,TTIME,CITY,region,town,grid,p_describe AS FAULT_DESCRIPTION,
'原因' AS LABEL,THOUR,def_cellname_chinese
FROM 
IF_Type_Table_3 where flag=1;

INSERT INTO TABLE PROPERTIES_DB_3
SELECT cellname AS DEF_CELLNAME,'干扰' AS TYPE1,'上行干扰' AS TYPE2,'阻塞干扰' AS TYPE3,
cellname AS FAULT_OBJECT,TTIME,CITY,region,town,grid,p_describe AS FAULT_DESCRIPTION,
'原因' AS LABEL,THOUR,def_cellname_chinese
FROM 
IF_Type_Table_4 where flag=1;

INSERT INTO TABLE PROPERTIES_DB_3
SELECT cellname AS DEF_CELLNAME,'干扰' AS TYPE1,'上行干扰' AS TYPE2,'同频干扰' AS TYPE3,
cellname AS FAULT_OBJECT,TTIME,CITY,region,town,grid,p_describe AS FAULT_DESCRIPTION,
'原因' AS LABEL,THOUR,def_cellname_chinese
FROM 
IF_Type_Table_5 where flag=1;

INSERT INTO TABLE PROPERTIES_DB_3
SELECT cellname AS DEF_CELLNAME,'干扰' AS TYPE1,'上行干扰' AS TYPE2,'GPS干扰' AS TYPE3,
cellname AS FAULT_OBJECT,TTIME,CITY,region,town,grid,p_describe AS FAULT_DESCRIPTION,
'原因' AS LABEL,THOUR,def_cellname_chinese
FROM 
IF_Type_Table_6 where flag=1;

INSERT INTO TABLE PROPERTIES_DB_3
SELECT cellname AS DEF_CELLNAME,'干扰' AS TYPE1,'上行干扰' AS TYPE2,'互调干扰' AS TYPE3,
cellname AS FAULT_OBJECT,TTIME,CITY,region,town,grid,p_describe AS FAULT_DESCRIPTION,
'原因' AS LABEL,THOUR,def_cellname_chinese
FROM 
IF_Type_Table_6 where flag=2;



DROP TABLE InterferenceType_1;
DROP TABLE IF_PARAM_TABLE_1;
DROP TABLE IF_PARAM_TABLE_2;
DROP TABLE IF_PARAM_TABLE_3;
DROP TABLE IF_PARAM_TABLE_4;
DROP TABLE IF_PARAM_TABLE_5;
DROP TABLE IF_PARAM_TABLE_6;
DROP TABLE IF_PARAM_TABLE_7;
DROP TABLE IF_PARAM_TABLE_8;
DROP TABLE IF_PARAM_TABLE_9;
DROP TABLE IF_PARAM_TABLE_10;
DROP TABLE IF_PARAM_TABLE_11;
DROP TABLE IF_PARAM_TABLE_12;
DROP TABLE IF_PARAM_TABLE_13;
DROP TABLE IF_PARAM_TABLE_14;
DROP TABLE IF_PARAM_TABLE_15;
DROP TABLE IF_Type_Table_1;
DROP TABLE IF_Type_Table_2;
DROP TABLE IF_Type_Table_3;
DROP TABLE IF_Type_Table_4;
DROP TABLE IF_Type_Table_5;
DROP TABLE IF_Type_Table_6;
drop table AVG_PM_EutranCellTdd_0;
DROP TABLE IF_PARAM_TABLE_6_0;


