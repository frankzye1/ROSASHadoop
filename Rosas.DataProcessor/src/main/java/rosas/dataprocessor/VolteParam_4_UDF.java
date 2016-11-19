package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/10/20.
 */
public class VolteParam_4_UDF extends UDF {
    public String evaluate(String str) {
        try {
            String[] list = Common.StrToList(str);
            for (int i = 0; i < list.length; i++) {
                String a = list[i].replace(")", "").split(",")[1];

                if(list[i].replace(")", "").split(",")[0].equals("NA"))
                {

                        return a;

                }

                if (Double.parseDouble(list[i].replace(")", "").split(",")[0]) == 1) {

                        return a;

                }
            }
        } catch (Exception ex) {
            return "NULL";
        }
        return "NULL";
    }
}
