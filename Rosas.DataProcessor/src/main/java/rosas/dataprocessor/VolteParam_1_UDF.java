package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/8/25.
 */
public class VolteParam_1_UDF extends UDF {
    public String evaluate(String str,String p) {
        try {
            String[] list = Common.StrToList(str);
            for (int i = 0; i < list.length; i++) {
                String a = list[i].replace(")", "").split(",")[1];

                if(list[i].replace(")", "").split(",")[0].equals("NA"))
                {
                    if (!(a.equals(p))) {
                        return a;
                    }
                }

                if (Double.parseDouble(list[i].replace(")", "").split(",")[0]) == 1) {
                    if (!(a.equals(p))) {
                        return a;
                    }
                }
            }
        } catch (Exception ex) {
            return "0";
        }
        return "0";
    }
}
