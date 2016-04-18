package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/4/7.
 * 标准差
 */
public class IF_StandardDeviation_UDF extends UDF {
    public double evaluate(String[] str) {
        try {
            str=Common.MissingValueProcess(str);//处理空值

            IF_AvgValue_UDF ave=new IF_AvgValue_UDF();

            double value1=ave.evaluate(str);
            double temp=0;
            for (int i = 0; i < str.length; i++) {

                temp+=Math.pow(Double.parseDouble(str[i]) - value1, 2);

            }


            return Math.round(Math.sqrt(temp * 0.01)*10000.0)/10000.0;
        } catch (Exception e) {
            return 0;
        }
    }
}