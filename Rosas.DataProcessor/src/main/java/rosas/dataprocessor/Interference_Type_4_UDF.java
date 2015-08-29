package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/26.
 * ?干扰最严重的PRB为position ，position是对干扰电平值排序后的最大值所对应的PRB序号
 */
public class Interference_Type_4_UDF extends UDF {
    public int evaluate(String[] str) {
        try {
            double max = -1000000;
            int max_position =-1;

            for (int i = 0; i < str.length; i++) {
                if (str[i] != null && str[i] != "") {
                    if (Double.parseDouble(str[i])>max)
                    {
                        max=Double.parseDouble(str[i]);
                        max_position=i;
                    }
                }
            }
            return max_position;
        } catch (Exception e) {
            return 0;
        }
    }
}