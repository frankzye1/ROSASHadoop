package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/5/18.
 */
public class InteroperabilityParameters_3_UDF  extends UDF {
    public int evaluate(String str,Double value) {
        try {
            String[] list = Common.StrToList(str);
            for (int i = 0; i < list.length; i++) {
                double a=Double.parseDouble(list[i].replace(")","").split(",")[1].replace("DB",""));
                if ( Math.abs(a)> value) {
                    return 1;
                }
            }
        } catch (Exception ex) {
            return 0;
        }
        return 0;
    }
}