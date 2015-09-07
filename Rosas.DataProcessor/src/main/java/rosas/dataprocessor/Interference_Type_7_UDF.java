package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/28.
 */
public class Interference_Type_7_UDF extends UDF {
    public int evaluate(double variance, double avg_if, String P1_V1, String P1_OP1, String P2_V1, String P2_OP1) {
        try {
            if (Common.compare(variance, P1_OP1, Double.parseDouble(P1_V1))
                    && Common.compare(avg_if, P2_OP1, Double.parseDouble(P2_V1))) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
    }
}