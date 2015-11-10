package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zhuang on 2015/9/21.
 */
public class Param_Analysis_40_UDF extends UDF
{
    public int evaluate(String reg,String str,String op1,String v1)
    {
        try
        {

            double V1=Double.parseDouble(v1.toUpperCase().replace(reg.toUpperCase(), ""));
            double a=0;
            String[] Strlist=Common.StrToList(str);
            for (int i=0;i<Strlist.length;i++)
            {
                String[] tempStr =Strlist[i].replace(")","").split(",");
                a=Double.parseDouble(tempStr[1].toUpperCase().replace(reg.toUpperCase(), ""));
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