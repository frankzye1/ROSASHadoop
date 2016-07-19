package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/6/23.
 */
public class InteroperabilityParameters_7_UDF extends UDF {
    public int evaluate(String str) {
        try {
            List<String> replace_str=new ArrayList<String>();
            replace_str.add("MS");
            replace_str.add("ms");
            List<String> list = Common.getTeacherList(str,"(MS|ms)\\d+|\\d+(?=\\)})",replace_str);

            for (String no : list) {
                if (!(Double.parseDouble(no) == 320.0 || Double.parseDouble(no) == 8.0)) {
                    return 1;
                }
            }
            return 0;
        } catch (Exception ex) {
            return 0;
        }
    }



}


