package rosas.dataprocessor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Zhuang on 2015/8/6.
 */
public class Common {

    //比较函数 输入(参数1,运算符,参数2)  返回 true or false
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

    //与或函数  输入(参数1,"and"/"or",参数2)
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

    //获取value在list中的index
    public static int GetIndexFromList(List<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            if (value == list.get(i)) {
                return i;
            }
        }
        return 0;

    }

    public static double ReservedDecimal(double result) {
        DecimalFormat df = new DecimalFormat("#.######");
        String returnStr = df.format(result);
        if (returnStr.contains("E")) {
            BigDecimal bd = new BigDecimal(returnStr);
            int index = bd.toPlainString().indexOf(".") + 7;
            if (index > bd.toPlainString().length()) {
                index = bd.toPlainString().length();
            }
            returnStr = bd.toPlainString().substring(0, index);
        }
        return Double.parseDouble(returnStr);
    }

    public static String[] StrToList(String Str) {
        String[] Strlist = Str.replace("{", "").replace("}", "").replace("(", "").split("\\),");
        return Strlist;
    }
}




