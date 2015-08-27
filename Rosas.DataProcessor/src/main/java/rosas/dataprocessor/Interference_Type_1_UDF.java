package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/26.
 * <p/>
 * 干扰类型   UDF1  求均值
 */
public class Interference_Type_1_UDF extends UDF {
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
            if (effetiveNum==0)
            {
                return 0;
            }
            return sum / effetiveNum;
        } catch (Exception e) {
            return 0;
        }
    }
}