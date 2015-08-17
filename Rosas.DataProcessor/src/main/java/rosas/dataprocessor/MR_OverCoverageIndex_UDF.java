package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/6.
 */
public class MR_OverCoverageIndex_UDF extends UDF {
    public String evaluate(String LteScRSRP, String LteNcRSRP, Long total,
                           String value1, String operator1,
                           String value2, String operator2,
                           String value3, String operator3) {
        double a = Double.parseDouble(LteScRSRP);
        double b = Double.parseDouble(LteNcRSRP);
        double v1 = Double.parseDouble(value1);
        double v2 = Double.parseDouble(value2);
        String op1 = operator1;
        String op2 = operator2;

        String Str = "";

        boolean result1 = CommonFunction.compare(a, op1, v1);
        boolean result2 = CommonFunction.compare(b - a, op2, v2);
        Str += "R1:" + result1 + "R2:" + result2;

        if (result1 && result2) {
            Str += "R:1";
        } else {
            Str += "R:0" + "´óÓÚ" + op1 + op2;
        }

        return Str;


    }
}