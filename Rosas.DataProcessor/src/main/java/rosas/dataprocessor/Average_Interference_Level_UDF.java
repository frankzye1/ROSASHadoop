package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/24.
 * 平均干扰电平
 */
public class Average_Interference_Level_UDF extends UDF {
    public double evaluate(String[] str) {
        try {
            double sum = 0;
            int effetiveNum=0;
            for (int i = 0; i < str.length; i++) {
                if (str[i] != null && str[i] != "") {
                    sum+=Math.pow(10,Double.parseDouble(str[i])/10);
                    effetiveNum++;
                }
            }
            double avg=10*Math.log10(sum/effetiveNum);
            return Common.ReservedDecimal(avg);
        } catch (Exception e) {
            return 0;
        }
    }
}