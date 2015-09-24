package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/17.
 */
public class Param_Analysis_19_UDF extends UDF {
    public int evaluate(String BANDINDICATOR,String PB, String ANTENNAPORTSCOUNT,String op1, String v1,String op2,String v2) {
        try {
            Integer Band=Integer.parseInt(BANDINDICATOR);
            double a = Double.parseDouble(PB);
            double b1 = Double.parseDouble(v1);
            double b2 = Double.parseDouble(v2);
            if (Band==38||Band==39) {
                if (Common.compare(a, op1, b1)) {
                    return 1;
                } else {
                    return 0;
                }
            }
            else if (Band==40)
            {
                if (ANTENNAPORTSCOUNT!="AN1")
                {
                    if (Common.compare(a, op1, b1)) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
                else if (ANTENNAPORTSCOUNT=="AN1")
                {
                    if (Common.compare(a, op2, b2)) {
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