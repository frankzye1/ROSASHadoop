package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_29_UDF extends UDF
{
    public int evaluate(String QRXLEVMINOFFSET,
                        String op1,String v1)
    {
        try
        {
            if(QRXLEVMINOFFSET==null || QRXLEVMINOFFSET.equals("")|| QRXLEVMINOFFSET.equals("null")||QRXLEVMINOFFSET.equals("NULL"))
            {
                return 0;
            }
            double a=Double.parseDouble(QRXLEVMINOFFSET)*2;
            double V1=Double.parseDouble(v1);

            if (Common.compare(a,op1,V1))
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
            return 0;
        }
    }
}