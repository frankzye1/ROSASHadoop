package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/17.
 */
public class Param_Analysis_17_UDF extends UDF {
    public int evaluate(String BANDINDICATOR,String v_a, String op1, String v1,String logic,String op2,String v2,String op4,String v4) {
        try {
            Integer Band=Integer.parseInt(BANDINDICATOR);
            double a = Double.parseDouble(v_a);

            if (Band==39) {


                double b1 = Double.parseDouble(v1);
                double b2 = Double.parseDouble(v2);
                if (Common.LogicFun(Common.compare(a, op1, b1), logic, Common.compare(a, op2, b2))) {
                    return 1;
                } else {
                    return 0;
                }
            }
            else if (Band==38||Band==40)
            {
                double b4 = Double.parseDouble(v4);
                if (Common.compare(a, op4, b4)) {
                    return 1;
                } else {
                    return 0;
                }
            }
            else
            {
                return 0;
            }
        }
        catch (Exception e)
        {
            return  0;
        }
    }
}