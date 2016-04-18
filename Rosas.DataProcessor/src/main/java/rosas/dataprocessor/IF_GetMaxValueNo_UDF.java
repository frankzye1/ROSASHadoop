package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/4/12.
 */
public class IF_GetMaxValueNo_UDF extends UDF {
    public int evaluate(String[] str) {
        try {
            str=Common.MissingValueProcess(str);//¥¶¿Ìø’÷µ

            double max=-100000.0;
            int max_no=0;
            for (int i=0;i<str.length;i++)
            {
                if (Double.parseDouble(str[i])>max) {
                    max = Double.parseDouble(str[i]);
                    max_no = i;
                }
            }
            return max_no;

        } catch (Exception e) {
            return 0;
        }
    }
}