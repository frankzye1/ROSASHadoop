package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zhuang on 2015/9/21.
 */
public class Param_Analysis_41_UDF extends UDF {
    public int evaluate(String ver, String str, String op1, String v1, String op2, String v2) {
        try {

            if(ver==null || ver.equals("")|| ver.equals("null")||ver.equals("NULL"))
            {
                return 0;
            }
            if(str==null || str.equals("")|| str.equals("null")||str.equals("NULL"))
            {
                return 0;
            }
            double V1 = Double.parseDouble(v1.toUpperCase().replace("PSF", ""));
            double V2 = Double.parseDouble(v2.toUpperCase().replace("PSF", ""));
            double a = 0;
            String[] Strlist = Common.StrToList(str);
            for (int i = 0; i < Strlist.length; i++) {
                String[] tempStr = Strlist[i].replace(")", "").split(",");
                a = Double.parseDouble(tempStr[1].toUpperCase().replace("PSF", ""));
                if (ver == "NOKIA") {
                    if (Common.compare(a, op1, V1)) {
                        return 1;
                    }
                } else {
                    if (Common.compare(a, op2, V2)) {
                        return 2;
                    }
                }
            }
            return 0;

        } catch (Exception e) {
            return -1;
        }
    }
}