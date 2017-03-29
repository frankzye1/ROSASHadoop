package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuang on 2017/3/27.
 */
public class Convert_A3HysteresisInterFCov_UDF   extends UDF {
    public int evaluate(String str) {
        try {
            List<String> replace_str=new ArrayList<String>();
            replace_str.add("NA,");
            replace_str.add("},");
            replace_str.add("}");
            List<String> list = Common.getTeacherList(str,"NA,\\d+|\\d+(?=\\)})|},\\d+}",replace_str);

            for (String no : list) {
                if (Double.parseDouble(no) <0 || Double.parseDouble(no) >4) {
                    return 1;
                }
            }
            return 0;
        } catch (Exception ex) {
            return 0;
        }
    }



}
