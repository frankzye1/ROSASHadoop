package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/5/20.
 */
public class InteroperabilityParameters_5_UDF extends UDF {
    public double evaluate(String str,Double p1,Double p2,String op,Double value) {
        try {
            String[] list = Common.StrToList(str);
            for (int i = 0; i < list.length; i++) {
                double a=Double.parseDouble(list[i].replace(")","").split(",")[1]);
                if ( Common.compare(a*p1+p2,op,value)) {
                    return 1;
                }
            }
        } catch (Exception ex) {
            return 0;
        }
        return 0;
    }
}
