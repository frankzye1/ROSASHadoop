package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/5/19.
 */
public class InteroperabilityParameters_4_UDF  extends UDF {
    public int evaluate(String str) {
        try {
            String[] list = Common.StrToList(str);
            for (int i = 0; i < list.length; i++) {
                double a=Double.parseDouble(list[i].replace(")","").split(",")[1]);
                if (a != 4 && a != 5 && a != 6 && a != 7) {
                    return 1;
                }
            }
        } catch (Exception ex) {
            return 0;
        }
        return 0;
    }
}
