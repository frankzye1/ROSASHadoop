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
    public String evaluate(int Param_Analysis_Num,String qianzhui,String str,String op1,String v1)
    {
        try
        {

            double V1=Double.parseDouble(v1.replace(qianzhui,""));
            double a=0;
            StringBuilder sb=new StringBuilder();
            Pattern pattern = Pattern.compile("\\d*,"+qianzhui+"\\d*");
            Matcher matchr=pattern.matcher(str);
            List<String> strList=new ArrayList<String>(){};
            while (matchr.find()) {
                strList.add(matchr.group());
            }

            for (int i=0;i<strList.size();i++)
            {
                String[] tempStr =strList.get(i).split(",");
                a=Double.parseDouble(tempStr[1].replace(qianzhui,""));
                if (!Common.compare(a,op1,V1)) {
                    sb.append("£¨QCI" + tempStr[0] + "£©Îª" + tempStr[1] +";");
                }
            }
            return sb.toString();

        }
        catch (Exception e)
        {
            return "Error";
        }
    }
}