package rosas.dataprocessor;

/**
 * Created by Zhuang on 2015/8/6.
 */
public class CommonFunction {
    public static boolean compare(double temp1, String op, double temp2) {
        switch (OPERATOR.toOPERATOR(op)) {
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
}




