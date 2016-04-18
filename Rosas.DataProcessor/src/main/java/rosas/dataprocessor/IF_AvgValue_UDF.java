package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/4/6.
 * 求PRB 0到99 均值
 */
public class IF_AvgValue_UDF  extends UDF {
    public double evaluate(String[] str) {
        try {
            str=Common.MissingValueProcess(str);//处理空值

            double sum=0.0;
            for (int i=0;i<str.length;i++)
            {
                sum+=Double.parseDouble(str[i]);
            }
            return Math.round(sum*1000.0/str.length)/1000.0;

        } catch (Exception e) {
            return 0;
        }
    }
}