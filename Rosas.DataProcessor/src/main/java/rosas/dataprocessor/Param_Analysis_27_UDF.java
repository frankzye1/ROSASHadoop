package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_27_UDF extends UDF
{
    public int evaluate(String BANDINDICATOR,String QRXLEVMIN,String op1,String v1,String LOGIC1,
                        String op2,String v2,String op4,String v4,String LOGIC2,String op5,String v5)
    {
        try
        {

            double a=Double.parseDouble(QRXLEVMIN)*2;
            double V1=Double.parseDouble(v1);
            double V2=Double.parseDouble(v2);
            double V4=Double.parseDouble(v4);
            double V5=Double.parseDouble(v5);


            if (BANDINDICATOR=="38"||BANDINDICATOR=="39")
            {
                if (Common.LogicFun(Common.compare(a,op1,V1),LOGIC1,Common.compare(a,op2,V2)))
                {
                    return 1;
                }
                else
                {
                    return 0;
                }

            }
            else if (BANDINDICATOR=="40")
            {
                if (Common.LogicFun(Common.compare(a,op4,V4),LOGIC2,Common.compare(a,op5,V5)))
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
                return 0;
            }
        }
        catch (Exception e)
        {
            return 0;
        }
    }
}