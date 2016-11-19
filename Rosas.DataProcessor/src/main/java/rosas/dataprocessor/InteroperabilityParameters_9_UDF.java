package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/10/20.
 */
public class InteroperabilityParameters_9_UDF  extends UDF {
    public String evaluate(String str) {
        try {
            String[] list = Common.StrToList1(str);
            if (list.length==0)
            {
                return "null";
            }
            for (int i = 0; i < list.length; i++) {
                String[] temp=list[i].replace("(","").replace(")","").split(",");
                String a=temp[0];
                if ( a.equals("NA")|| a.equals("1")) {
                    return temp[2];
                }
            }
        } catch (Exception ex) {
            return "null";
        }
        return "null";
    }
}