package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_28_UDF extends UDF
{
    public int evaluate(String QOFFSETCELL,String QHYST,
                        String op1,String v1,String LOGIC1,String op2,String v2)
    {
        try
        {
            if(QOFFSETCELL==null || QOFFSETCELL.equals("")|| QOFFSETCELL.equals("null")||QOFFSETCELL.equals("NULL"))
            {
                return 0;
            }
            if(QHYST==null || QHYST.equals("")|| QHYST.equals("null")||QHYST.equals("NULL"))
            {
                return 0;
            }
            double a=Double.parseDouble(QOFFSETCELL.replace("DB",""))+Double.parseDouble(QHYST.replace("DB",""));
            double V1=Double.parseDouble(v1);
            double V2=Double.parseDouble(v2);

            if (Common.LogicFun(Common.compare(a,op1,V1),LOGIC1,Common.compare(a,op2,V2)))
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