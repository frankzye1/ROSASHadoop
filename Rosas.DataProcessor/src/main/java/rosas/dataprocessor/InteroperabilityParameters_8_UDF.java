package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/24.
 */
public class InteroperabilityParameters_8_UDF  extends UDF {
    public int evaluate(String str) {
        try {
            List<String> replace_str=new ArrayList<String>();
            replace_str.add("NA,");
            replace_str.add("},");
            replace_str.add("}");
            List<String> list = Common.getTeacherList(str,"NA,\\d+|\\d+(?=\\)})|},\\d+}",replace_str);

            for (String no : list) {
                if (Double.parseDouble(no) <0 || Double.parseDouble(no) >3) {
                    return 1;
                }
            }
            return 0;
        } catch (Exception ex) {
            return 0;
        }
    }



}
