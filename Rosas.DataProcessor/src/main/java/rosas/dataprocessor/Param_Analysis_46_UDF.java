package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2015/11/10.
 */
public class Param_Analysis_46_UDF extends UDF
{
    public int evaluate(String str,String op1,String v1)
    {
        try
        {
            if(str==null || str.equals("")|| str.equals("null")||str.equals("NULL"))
            {
                return 0;
            }
            double V1=Double.parseDouble(v1.toUpperCase().replace("RF", ""));
            double a=0;
            String[] Strlist=Common.StrToList(str);
            for (int i=0;i<Strlist.length;i++)
            {
                String[] tempStr =Strlist[i].replace(")","").split(",");
                a=Double.parseDouble(tempStr[1].toUpperCase().replace("RF",""));
                if (Common.compare(a,op1,V1)) {
                    return 1;
                }
            }
            return 0;

        }
        catch (Exception e)
        {
            return -1;
        }
    }
}