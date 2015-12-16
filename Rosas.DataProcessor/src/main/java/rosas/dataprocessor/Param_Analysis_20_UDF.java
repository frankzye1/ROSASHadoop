package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.regex.Pattern;

/**
 * Created by Zhuang on 2015/9/17.
 */
public class Param_Analysis_20_UDF extends UDF {
    public int evaluate(String PREAMBLEINITIALRTP,String op1, String v1,String Logic,String op2,String v2) {
        try {
            if(PREAMBLEINITIALRTP==null || PREAMBLEINITIALRTP.equals("")|| PREAMBLEINITIALRTP.equals("null")||PREAMBLEINITIALRTP.equals("NULL"))
            {
                return 0;
            }

            PREAMBLEINITIALRTP=Pattern.compile("[^0-9]").matcher(PREAMBLEINITIALRTP).replaceAll("");
            v1=Pattern.compile("[^0-9]").matcher(v1).replaceAll("");
            v2=Pattern.compile("[^0-9]").matcher(v2).replaceAll("");

            double a = Double.parseDouble(PREAMBLEINITIALRTP);
            double b1 = Double.parseDouble(v1);
            double b2 = Double.parseDouble(v2);
            if (Common.LogicFun(Common.compare(a,op1,b1),Logic,Common.compare(a,op2,b2)))
            {
                return 1;
            }
            else
            {
                return 0;
            }

        }
        catch (Exception e)
        {
            return  -1;
        }
    }
}