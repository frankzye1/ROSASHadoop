package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/4/7.
 * 前50RB干扰值斜率
 */
public class IF_SlopeFor41Params_UDF extends UDF {
    public double evaluate(String[] str) {
        try {
            str=Common.MissingValueProcess(str);//处理空值
            double a = 0;
            double b = 0;
            for (int i = 0; i < str.length; i++) {

                double temp_prb_value=Double.parseDouble(str[i]);
                a+=i*temp_prb_value;
                b+=temp_prb_value;

            }
            double result=((41.0*a)-(820.0*b))/235340.0;

            return Math.round(result*100.0)/100.0;
        } catch (Exception e) {
            return 0;
        }
    }
}
