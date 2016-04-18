package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/4/6.
 * 最大值
 */
public class IF_MaxValue_UDF extends UDF {
    public double evaluate(String[] str) {
        try {
            str=Common.MissingValueProcess(str);//处理空值

            double max=-100000.0;
            for (int i=0;i<str.length;i++)
            {
                max=Double.parseDouble(str[i])>max?Double.parseDouble(str[i]):max;
            }
            return max;

        } catch (Exception e) {
            return 0;
        }
    }
}