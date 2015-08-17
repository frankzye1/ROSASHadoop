package rosas.dataprocessor;

/*
 * Created by Zhuang on 2015/7/31.
 */

import org.apache.hadoop.hive.ql.exec.UDF;

public class Antenna_Reverse_Analysis_UDF extends UDF {
    public Integer evaluate(String DIR, String MR_SECTOR_BEARING) {

        try {
            double a = Double.parseDouble(DIR);
            double b = Double.parseDouble(MR_SECTOR_BEARING);
            if (a >= 120) {
                if (a - b > 120 || a - b < -120) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (b < (a + 240) && b > (a + 120)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } catch (Exception e) {
            return 0;
        }

    }
}
