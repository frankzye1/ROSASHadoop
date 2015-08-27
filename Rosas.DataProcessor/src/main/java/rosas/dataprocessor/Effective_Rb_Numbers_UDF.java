package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/24.
 */
public class Effective_Rb_Numbers_UDF extends UDF {
    public int evaluate(String[] str) {
        try {
            int nums = 0;
            for (int i = 0; i < str.length; i++) {
                if (str[i] != null && str[i] != "") {
                    nums++;
                }
            }
            return nums;
        } catch (Exception e) {
            return 0;
        }
    }
}