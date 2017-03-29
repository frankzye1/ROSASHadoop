package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/6/3.
 */
public class InteroperabilityParameters_6_UDF  extends UDF {
    public int evaluate(String str,Double value) {
        try {
            String[] list = Common.StrToList(str);
            for (int i = 0; i < list.length; i++) {
                double a=Double.parseDouble(list[i].replace(")","").split(",")[1]);
                if ( a> value) {
                    return 1;
                }
            }
        } catch (Exception ex) {
            return 0;
        }
        return 0;
    }
}