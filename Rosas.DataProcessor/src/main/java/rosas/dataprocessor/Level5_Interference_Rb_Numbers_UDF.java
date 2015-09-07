package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/28.
 */
public class Level5_Interference_Rb_Numbers_UDF  extends UDF {
    public int evaluate(String op1,String value1,String[] str) {
        try {
            double v1=Double.parseDouble(value1);

            int accordNums = 0;
            for (int i = 0; i < str.length; i++) {
                if (str[i] != null && str[i] != "") {
                    double tempValue=Double.parseDouble(str[i]);
                    boolean b1= Common.compare(tempValue, op1, v1);
                    if (b1)
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