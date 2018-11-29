package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

public class NRM_A2HysteresisInterFCov_UDF extends UDF {


    public String evaluate(String a, String b) {
        try {
            String s = Common.commonCode(a, b);
            if(s==null || s.equals("")){
                return null;
            }
            else{
                return s;
            }
        }
        catch (Exception e)
        {
            return  "NULL";
        }
    }



}
