package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/10/14.
 */
public class VolteParam_3_UDF extends UDF {
    public String evaluate(String str) {
        try {
            String[] list = Common.StrToList(str);

            for (int i = 0; i < list.length; i++) {

                if(list[i].replace(")", "").split(",")[0].equals("NA")||list[i].replace(")", "").split(",")[0].equals("1"))
                {
                    return  list[i].replace(")", "").split(",")[1];
                }

            }
            return "null";

        } catch (Exception ex) {
            return "null";
        }

    }
}
