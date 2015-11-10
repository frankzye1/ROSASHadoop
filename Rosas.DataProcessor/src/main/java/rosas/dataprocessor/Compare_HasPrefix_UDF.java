package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/21.
 */
public class Compare_HasPrefix_UDF extends UDF {
    public int evaluate(String v_a, String operator, String v_b,String prefix) {
        try {
            double a = Double.parseDouble(v_a.toUpperCase().replace(prefix.toUpperCase(),""));
            double b = Double.parseDouble(v_b);
            String op = operator;
            if (Common.compare(a, op, b)) {
                return 1;
            } else {
                return 0;
            }
        }
        catch (Exception e)
        {
            return  0;
        }
    }
}