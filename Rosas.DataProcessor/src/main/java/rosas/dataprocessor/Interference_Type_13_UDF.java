package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/10/22.
 */
public class Interference_Type_13_UDF extends UDF {
    public double evaluate(String[] str) {
        try {
            double max = -1000000;

            for (int i = 0; i < str.length; i++) {
                if (str[i] != null && str[i] != "") {
                    if (Double.parseDouble(str[i])>max)
                    {
                        max=Double.parseDouble(str[i]);
                    }
                }
            }
            return max;
        } catch (Exception e) {
            return -120;
        }
    }
}