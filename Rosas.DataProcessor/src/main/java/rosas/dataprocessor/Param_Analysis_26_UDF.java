package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/17.
 */
public class Param_Analysis_26_UDF extends UDF
{
    public int evaluate(String DEF_VENDORNAME, String ALPHA, String op1, String v1, String op2, String v2)
    {
        try
        {
            double a=Double.parseDouble(ALPHA.substring(ALPHA.length() - 1));
            double b1 = Double.parseDouble(v1);
            double b2 = Double.parseDouble(v2);
            if (ALPHA.contains("AL08"))
            {
                a=0.8;
            }
            if (DEF_VENDORNAME == "NOKIA")
            {
                if (Common.compare(a, op1, b1))
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
            else
            {
                if (Common.compare(a, op2, b2))
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
        }
        catch (Exception e)
        {
            return 0;
        }
    }
}