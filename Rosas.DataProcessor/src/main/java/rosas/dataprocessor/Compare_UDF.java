package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/7.
 */
public class Compare_UDF extends UDF {
    public int evaluate(String v_a, String operator, String v_b) {
        try {
            if(v_a==null || v_a.equals("")|| v_a.equals("null")||v_a.equals("NULL"))
            {
                return 0;
            }
            double a = Double.parseDouble(v_a);
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
            return  -1;
        }
    }
}