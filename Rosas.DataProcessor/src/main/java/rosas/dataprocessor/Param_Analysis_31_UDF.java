package rosas.dataprocessor;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/30.
 */
public class Param_Analysis_31_UDF extends UDF {
    public int evaluate(String Str, String op1, String v1) {
        try {
            if(Str==null || Str.equals("")|| Str.equals("null")||Str.equals("NULL"))
            {
                return 0;
            }
            //"{(1,),(1,),(1,),(1,),(2,),(2,)}"
            String[] Strlist = Common.StrToList(Str);

            for (int i = 0; i < Strlist.length; i++) {
                Str= Strlist[i].split(",")[0];
                if (Common.compare(Double.parseDouble(Str),op1,Double.parseDouble(v1)))
                {
                    return 1;
                }
            }

            return 0;

        } catch (Exception e) {
            return -1;
        }
    }
}