package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/7/31.
 */

public class Antenna_Reverse_Analysis_1_UDF extends UDF {
    public double evaluate(String DIR, String MR_SECTOR_BEARING) {

        try {
            double a = Double.parseDouble(DIR);
            double b = Double.parseDouble(MR_SECTOR_BEARING);
            double result=(Math.abs(a - b) + 360) % 360;
            return CommonFunction.ReservedDecimal(result);
        } catch (Exception e) {
            return 0;
        }

    }
}
