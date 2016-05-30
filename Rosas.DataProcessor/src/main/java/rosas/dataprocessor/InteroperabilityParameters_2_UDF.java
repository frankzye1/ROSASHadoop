package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/5/17.
 */
public class InteroperabilityParameters_2_UDF  extends UDF {
    public int evaluate(String str,Double value) {
        try {
            String[] list = Common.StrToList(str);
            for (int i = 0; i < list.length; i++) {
                double a=Double.parseDouble(list[i].replace(")","").split(",")[1]);
                if ( a!= value) {
                    return 1;
                }
            }
        } catch (Exception ex) {
            return 0;
        }
        return 0;
    }
}
