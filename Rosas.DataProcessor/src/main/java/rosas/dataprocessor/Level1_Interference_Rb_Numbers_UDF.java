package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/25.
 */
public class Level1_Interference_Rb_Numbers_UDF extends UDF {
    public int evaluate(String op1,String value1,String logic,String op2,String value2,String[] str) {
        try {
            double v1=Double.parseDouble(value1);
            double v2=Double.parseDouble(value2);

            int accordNums = 0;
            for (int i = 0; i < str.length; i++) {
                if (str[i] != null && str[i] != "") {
                    double tempValue=Double.parseDouble(str[i]);
                    boolean b1=CommonFunction.compare(tempValue, op1, v1);
                    boolean b2=CommonFunction.compare(tempValue, op2, v2);
                    if (CommonFunction.LogicFun(b1,logic,b2))
                    {
                        accordNums++;
                    }
                }
            }
            return accordNums;
        } catch (Exception e) {
            return 0;
        }
    }
}