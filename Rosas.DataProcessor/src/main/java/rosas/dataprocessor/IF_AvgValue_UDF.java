package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/4/6.
 * 求PRB 0到99 均值
 */
public class IF_AvgValue_UDF  extends UDF {
    public double evaluate(String[] str) {
        try {
            double sum=0.0;
            int cnt=Common.GetEffectValueCount(str);
            if(cnt<=55)//有效数小于55的
            {
                for (int i=0;i<str.length;i++)
                {
                    if(str[i]!=null&&str[i]!=""){
                    sum+=Double.parseDouble(str[i]);
                    }
                }
                if (cnt==0)
                {
                    return 0;
                }
                return Math.round(sum*1000.0/cnt)/1000.0;

            }

            str=Common.MissingValueProcess(str);//处理空值


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