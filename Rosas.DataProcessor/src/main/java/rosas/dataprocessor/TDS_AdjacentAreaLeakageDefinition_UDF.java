package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/3.
 */
public class TDS_AdjacentAreaLeakageDefinition_UDF extends UDF {
    public Integer evaluate(String MR_LteScRSRP, String op1, String v1) {

        try {
            double a = Double.parseDouble(MR_LteScRSRP);
            double b = Double.parseDouble(v1);

            if (compare(a, op1, b)) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }

    }

    private boolean compare(double temp1, String op, double temp2) {
        if (op.equals("大于")) {
            return temp1 > temp2;
        } else if (op.equals("小于")) {
            return temp1 < temp2;
        } else if (op.equals("大于等于")) {
            return temp1 >= temp2;
        } else if (op.equals("小于等于")) {
            return temp1 <= temp2;
        } else if (op.equals("等于")) {
            return temp1 == temp2;
        } else {
            return false;
        }
    }
}
