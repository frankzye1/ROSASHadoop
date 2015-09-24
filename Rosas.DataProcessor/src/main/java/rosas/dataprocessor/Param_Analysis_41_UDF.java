package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zhuang on 2015/9/21.
 */
public class Param_Analysis_41_UDF extends UDF
{
    public String evaluate(int Param_Analysis_Num,String qianzhui,String ver,String str,String op1,String v1,String op2,String v2)
    {
        try
        {

            double V1=Double.parseDouble(v1.replace(qianzhui,""));
            double V2=Double.parseDouble(v2.replace(qianzhui,""));
            double a=0;
            boolean IsFirst=true;
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
                if (ver=="NOKIA") {
                    if (!Common.compare(a, op1, V1)) {
                        sb.append("QCI" + tempStr[0] + "ֵΪ" + tempStr[1] + ";");
                    }
                }
                else
                {
                    if (!Common.compare(a, op2, V2)) {
                        sb.append("QCI" + tempStr[0] + "ֵΪ" + tempStr[1] + ";");
                    }
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