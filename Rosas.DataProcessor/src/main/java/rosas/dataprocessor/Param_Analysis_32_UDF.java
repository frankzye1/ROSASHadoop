package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_32_UDF extends UDF
{
    public int evaluate(String INOUTDOOR,String SNONINTRASEARCH,String QRXLEVMIN,String QRXLEVMINOFFSET,
                        String op1,String v1,String LOGIC1,String op2,String v2,
                        String op4,String v4,String LOGIC2,String op5,String v5)
    {
        try
        {
            if(INOUTDOOR==null || INOUTDOOR.equals("")|| INOUTDOOR.equals("null")||INOUTDOOR.equals("NULL"))
            {
                return 0;
            }
            if(SNONINTRASEARCH==null || SNONINTRASEARCH.equals("")|| SNONINTRASEARCH.equals("null")||SNONINTRASEARCH.equals("NULL"))
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
            if (SNONINTRASEARCH.length()<1)
            {
                SNONINTRASEARCH="0";
            }
            if (QRXLEVMIN.length()<1)
            {
                QRXLEVMIN="0";
            }
            if (QRXLEVMINOFFSET.length()<1)
            {
                QRXLEVMINOFFSET="0";
            }



            double a=(Double.parseDouble(SNONINTRASEARCH)*2)+
                    (Double.parseDouble(QRXLEVMIN)*2)+
                    (Double.parseDouble(QRXLEVMINOFFSET)*2);
            double V1=Double.parseDouble(v1);
            double V2=Double.parseDouble(v2);
            double V4=Double.parseDouble(v4);
            double V5=Double.parseDouble(v5);

            if (INOUTDOOR=="OUTDOOR")
            {
                if (Common.LogicFun(Common.compare(a, op1, V1), LOGIC1, Common.compare(a,op2,V2)))
                {
                    return (int)a;
                }
                else
                {
                    return 0;
                }
            }
            else if (INOUTDOOR=="INDOOR")
            {
                if (Common.LogicFun(Common.compare(a, op4, V4), LOGIC2, Common.compare(a,op5,V5)))
                {
                    return (int)a;
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