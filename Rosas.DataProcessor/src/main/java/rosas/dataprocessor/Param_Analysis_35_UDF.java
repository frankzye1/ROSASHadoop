package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_35_UDF extends UDF
{
    public int evaluate(String THRESHXHIGH,String QRXLEVMINRESELECTION,String QRXLEVMINOFFSET,
                        String op1,String v1,String LOGIC1,String op2,String v2)
    {
        try
        {
            double a=Double.parseDouble(THRESHXHIGH)+
                    (Double.parseDouble(QRXLEVMINRESELECTION)*2)+
                    (Double.parseDouble(QRXLEVMINOFFSET)*2);
            double V1=Double.parseDouble(v1);
            double V2=Double.parseDouble(v2);

            if (Common.LogicFun(Common.compare(a,op1,V1),LOGIC1,Common.compare(a,op2,V2)))
            {
                return (int)a;
            }
            else
            {
                return 0;
            }

        }
        catch (Exception e)
        {
            return -1;
        }
    }
}