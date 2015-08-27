package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/26.
 */
public class Interference_Type_2_UDF extends UDF {
    public double evaluate(String[] str) {
        try {
            double sum = 0;
            int effetiveNum = 0;
            for (int i = 0; i < str.length; i++) {
                if (str[i] != null && str[i] != "") {
                    sum += Double.parseDouble(str[i]);
                    effetiveNum++;
                }
            }
            if (effetiveNum == 0) {
                return 0;
            }
            double avg = sum / effetiveNum;
            double variance = 0;

            for (int i = 0; i < str.length; i++) {
                if (str[i] != null && str[i] != "") {
                    double temp = Double.parseDouble(str[i]) - avg;
                    variance += temp * temp;
                }
            }
            return variance / effetiveNum;
        } catch (Exception e) {
            return 0;
        }
    }
}