package rosas.dataprocessor;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zhuang on 2015/8/6.
 */
public class Common {

    //managers(输入的字符串)，regex（正则表达式），replace_str（要替换为空的字符）
    public static List<String> getTeacherList(String managers,String regex,List<String> replace_str) {
        List<String> ls = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(managers);
        while (matcher.find()) {
            String temp=matcher.group();
            for (String replace:replace_str) {
                temp=temp.replace(replace, "");
            }
            ls.add(temp);
        }
        return ls;
    }

    //�ȽϺ��� ����(����1,�����,����2)  ���� true or false
    public static boolean compare(double temp1, String op, double temp2) {
        switch (OPERATOR.toOPERATOR(op.toUpperCase())) {
            case GT:
                return temp1 > temp2;
            case LT:
                return temp1 < temp2;
            case GE:
                return temp1 >= temp2;
            case LE:
                return temp1 <= temp2;
            case EQ:
                return temp1 == temp2;
            case NE:
                return temp1 != temp2;
            default:
                return false;
        }
    }

    public enum OPERATOR {
        GT, LT, GE, LE, EQ, NE;

        public static OPERATOR toOPERATOR(String str) {
            return valueOf(str);
        }
    }

    //�����  ����(����1,"and"/"or",����2)
    public static boolean LogicFun(boolean temp1, String logic, boolean temp2) {
        switch (LOGIC.toLOGIC(logic.toLowerCase())) {
            case and:
                return temp1 && temp2;
            case or:
                return temp1 || temp2;
            default:
                return false;
        }
    }

    public enum LOGIC {
        and, or;

        public static LOGIC toLOGIC(String str) {
            return valueOf(str);
        }
    }


    public static int GetMinIndexInDoubleList(List<Double> list) {
        int min_index = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(min_index) > list.get(i)) {
                min_index = i;
            }
        }

        return min_index;
    }

    //��ȡvalue��list�е�index
    public static int GetIndexFromList(List<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            if (value == list.get(i)) {
                return i;
            }
        }
        return 0;

    }

    public static double ReservedDecimal(double result) {
       /* DecimalFormat df = new DecimalFormat("#.######");
        String returnStr = df.format(result);
        if (returnStr.contains("E")) {
            BigDecimal bd = new BigDecimal(returnStr);
            int index = bd.toPlainString().indexOf(".") + 7;
            if (index > bd.toPlainString().length()) {
                index = bd.toPlainString().length();
            }
            returnStr = bd.toPlainString().substring(0, index);
        }*/

        result=Math.round(result*10000.0)/10000.0;

        return result;
    }

    public static String[] StrToList(String Str) {
        String[] Strlist = Str.replace("{", "").replace("}", "").replace("(", "").split("\\),");
        return Strlist;
    }


    //缺失值处理
    public  static  String[] MissingValueProcess1(String[] str)
    {
        int MissingValueCount=0;
        for (int i=0 ;i<str.length;i++)
        {
            if (str[i]==null || str[i]=="" )
            {
                MissingValueCount++;
                int front_1=i-1<0?str.length+(i-1):i-1;
                int front_2=i-2<0?str.length+(i-2):i-2;
                int after_1=i+1>=str.length?i+1-str.length:i+1;
                int after_2=i+2>=str.length?i+2-str.length:i+2;
                double sum=0;//前后n 个数的和
                double IsNotNullCount=0;
                if (str[front_1]!=null&&str[front_1]!="")
                {
                    try {
                        sum+=Double.parseDouble(str[front_1]);
                        IsNotNullCount++;
                    }
                    catch (Exception ex)
                    {

                    }

                }

                if (str[front_2]!=null&&str[front_2]!="")
                {
                    try {
                        sum+=Double.parseDouble(str[front_2]);
                        IsNotNullCount++;
                    }
                    catch (Exception ex)
                    {

                    }

                }

                if (str[after_1]!=null&&str[after_1]!="")
                {
                    try {
                        sum+=Double.parseDouble(str[after_1]);
                        IsNotNullCount++;
                    }
                    catch (Exception ex)
                    {

                    }

                }

                if (str[after_2]!=null&&str[after_2]!="")
                {
                    try {
                        sum+=Double.parseDouble(str[after_2]);
                        IsNotNullCount++;
                    }
                    catch (Exception ex)
                    {

                    }

                }

                if (IsNotNullCount==0)
                {

                    str[i]="-118";
                }
                else
                {
                    str[i]=Double.toString(Math.round(sum*10000.0/IsNotNullCount)/10000.0);

                }

            }


        }

        if (MissingValueCount>200)
        {
            str=new String[]{};
        }
        return str;
    }



    //缺失值处理
    public  static  String[] MissingValueProcess(String[] str)
    {
        int MissingValueCount=0;
        for (int i=0 ;i<str.length;i++)
        {
            if (str[i]==null || str[i]=="" )
            {
                MissingValueCount++;
                int IsNotNullCount=0;
                double sum=0;

                for(int j=1;j<10;j++)
                {
                    if (str[i-j<0?0:i-j]!=null&&str[i-j<0?0:i-j]!="")
                    {
                        IsNotNullCount++;
                        sum+=Double.parseDouble(str[i-j<0?0:i-j]);

                    }

                    if(str[i+j>=str.length?str.length-1:i+j]!=null&&str[i+j>=str.length?str.length-1:i+j]!="")
                    {
                        IsNotNullCount++;
                        sum+=Double.parseDouble(str[i+j>=str.length?str.length-1:i+j]);
                    }

                    if (IsNotNullCount>0)
                    {
                        str[i]=Double.toString(Math.round(sum * 100.0 / IsNotNullCount) / 100.0);
                        break;
                    }


                }



            }


        }

        if (MissingValueCount>200)
        {
            str=new String[]{};
        }
        return str;
    }

    public  static  Double FUN1(Double param)
    {
        try {
            return  Math.pow(10, param / 10);
        }catch (Exception ex)
        {
            return 0.0;
        }

    }

    public  static  Double FUN2(Double param)
    {
        try {
            return  10*Math.log10(param);
        }catch (Exception ex)
        {
            return 0.0;
        }

    }



}




