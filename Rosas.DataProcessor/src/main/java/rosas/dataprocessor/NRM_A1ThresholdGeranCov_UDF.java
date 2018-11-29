package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

public class NRM_A1ThresholdGeranCov_UDF extends UDF {


    public String evaluate(String a, String b) {
        try {
            return Common.commonCode(a,b);
        }
        catch (Exception e)
        {
            return  "NULL";
        }
    }



}
