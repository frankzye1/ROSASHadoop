package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/3/1.
 */
public class Param_Analysis_16_UDF extends UDF {
    public int evaluate(String v_a, String operator, String v_b) {
        try {
            if(v_a==null || v_a.equals("")|| v_a.equals("null")||v_a.equals("NULL"))
            {
                return 0;
            }
            double a = Double.parseDouble(v_a.toUpperCase().replace("SA",""));
            double b = Double.parseDouble(v_b.toUpperCase().replace("SA",""));
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
