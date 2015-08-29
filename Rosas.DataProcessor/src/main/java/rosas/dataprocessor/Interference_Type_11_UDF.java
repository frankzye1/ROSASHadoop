package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/28.
 */
public class Interference_Type_11_UDF extends UDF {
    public double evaluate(String[] str) {
        try {
            double a = 0;
            double b = 0;
            for (int i = 0; i < str.length; i++) {
                if (str[i] != null && str[i] != "") {
                    double temp_prb_value=Double.parseDouble(str[i]);
                    a+=i*temp_prb_value;
                    b+=temp_prb_value;
                }
            }
            double result=((100*a)-(4950*b))/8332500.0;

            return result;
        } catch (Exception e) {
            return 0;
        }
    }
}