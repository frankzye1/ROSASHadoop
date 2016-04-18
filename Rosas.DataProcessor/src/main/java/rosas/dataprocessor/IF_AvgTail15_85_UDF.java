package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/4/14.
 */
public class IF_AvgTail15_85_UDF  extends UDF {
    public double evaluate(String[] str) {
        try {
            str=Common.MissingValueProcess(str);//¥¶¿Ìø’÷µ

            double x=0.0;
            double y=0.0;
            for (int i=0;i<str.length;i++)
            {
                if (i<85) {
                    x += Double.parseDouble(str[i]);
                }
                else
                {
                    y+=Double.parseDouble(str[i]);
                }
            }
            return Math.round(((y/15)-(x/85))*1000.0)/1000.0;

        } catch (Exception e) {
            return 0;
        }
    }
}