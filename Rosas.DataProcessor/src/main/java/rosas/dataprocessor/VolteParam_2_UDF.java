package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/8/25.
 */
public class VolteParam_2_UDF extends UDF {
    public Double evaluate(String str) {
        try {
            String[] list = Common.StrToList(str.replace("NA,",""));
            for (int i = 0; i < list.length; i++) {
                Double a = Double.parseDouble(list[i].replace(")", "").split(",")[1]);
                if (Double.parseDouble(list[i].replace(")", "").split(",")[0]) == 1) {
                        return a;
                }
            }
        } catch (Exception ex) {
            return 0.0;
        }
        return 0.0;
    }
}
