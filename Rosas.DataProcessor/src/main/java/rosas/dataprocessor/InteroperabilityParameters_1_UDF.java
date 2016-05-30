package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.List;

/**
 * Created by Administrator on 2016/5/17.
 * 234G»¥²Ù×÷²ÎÊý
 */
public class InteroperabilityParameters_1_UDF extends UDF {
    public double evaluate(String str,Double value) {
        try {
            String[] list = Common.StrToList(str);
            for (int i = 0; i < list.length; i++) {
                double a=Double.parseDouble(list[i].replace(")","").split(",")[1])*2;
                if ( a< value) {
                    return a;
                }
            }
        } catch (Exception ex) {
            return 0;
        }
        return 0;
    }
}
