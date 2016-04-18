package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/4/7.
 * 平滑度
 */
public class IF_Smoothness_UDF  extends UDF {
    public double evaluate(double v1,String[] str) {
        try {
            str=Common.MissingValueProcess(str);//处理空值
            double a=0.0;
            double b=0.0;
            double value1=v1;

            for (int i = 0; i < str.length-1; i++) {
                a=Math.abs(Double.parseDouble(str[i]) - Double.parseDouble(str[i + 1]));
                a=Math.ceil(a - value1)>0?Math.ceil(a - value1):0;
                a=a<1?a:1;
                b=b+a;
            }

            return Math.round((1.0-(b/79.0))*10000.0)/10000.0;
        } catch (Exception e) {
            return 0;
        }
    }
}