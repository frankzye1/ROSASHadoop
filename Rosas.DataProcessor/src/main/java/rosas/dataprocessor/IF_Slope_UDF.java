package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/4/6.
 * 新干扰算法里面的斜率，输入为PRB 0到99，返回斜率
 */
public class IF_Slope_UDF extends UDF {
    public double evaluate(String[] str) {
        try {
            str=Common.MissingValueProcess(str);//处理空值
            double a = 0;
            double b = 0;
            //double c=0;
            //double d=0;
            for (int i = 0; i < str.length; i++) {

                    double temp_prb_value=Double.parseDouble(str[i]);
                    a+=i*temp_prb_value;
                    b+=temp_prb_value;
               // c+=i;
               // d+=i*i;

            }
            double result=((80.0*a)-(3160.0*b))/3412800.0;

           // result=((str.length*a)-(c*b))/(str.length*d-(c*c));

            return Math.round(result*10000.0)/10000.0;
        } catch (Exception e) {
            return 0;
        }
    }
}