package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_30_UDF extends UDF
{
    public int evaluate(String SINTRASEARCH,String QRXLEVMIN,String QRXLEVMINOFFSET,
                        String op1,String v1)
    {
        try
        {
            if(SINTRASEARCH==null || SINTRASEARCH.equals("")|| SINTRASEARCH.equals("null")||SINTRASEARCH.equals("NULL"))
            {
                return 0;
            }
            if(QRXLEVMIN==null || QRXLEVMIN.equals("")|| QRXLEVMIN.equals("null")||QRXLEVMIN.equals("NULL"))
            {
                return 0;
            }
            if(QRXLEVMINOFFSET==null || QRXLEVMINOFFSET.equals("")|| QRXLEVMINOFFSET.equals("null")||QRXLEVMINOFFSET.equals("NULL"))
            {
                return 0;
            }
            double a=(Double.parseDouble(SINTRASEARCH)*2)+
                    (Double.parseDouble(QRXLEVMIN)*2)+
                    (Double.parseDouble(QRXLEVMINOFFSET)*2);
            double V1=Double.parseDouble(v1);

            if (Common.compare(a,op1,V1))
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