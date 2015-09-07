package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/28.
 */
public class Interference_Type_10_UDF extends UDF {
    public int evaluate(double slope_k, int position, String P5_V1, String P5_OP1, String P5_V2, String P5_OP2, String P5_LOGIC) {
        try {
            if (Common.LogicFun(Common.compare(position, P5_OP1, Double.parseDouble(P5_V1)), P5_LOGIC,
                    Common.compare(position, P5_OP2, Double.parseDouble(P5_V2))) && (slope_k > -0.1)) {
                return 1;

            } else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
    }
}