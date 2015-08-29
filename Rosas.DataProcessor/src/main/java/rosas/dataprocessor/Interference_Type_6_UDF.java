package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhuang on 2015/8/27.
 * 返回 [最大值-1 ,最大值 , 最大值+1]
 */
public class Interference_Type_6_UDF extends UDF {
    public String evaluate(String[] str) {
        try {
            double max = -1000000;
            int max_position =-1;

            for (int i = 0; i < str.length; i++) {
                if (str[i] != null && str[i] != "") {
                    if (Double.parseDouble(str[i])>max)
                    {
                        max=Double.parseDouble(str[i]);
                        max_position=i;
                    }
                }
            }

            int left=max_position-1;
            int right=max_position+1;
            if (left<0)
            {
                left=0;
            }
            if (right>str.length-1)
            {
                right=str.length-1;
            }

            List<Double> result=new ArrayList<Double>(){};
            result.add(Double.parseDouble((((str[left])!=null)&&(str[left])!="")?str[left]:str[max_position]));
            result.add(Double.parseDouble(str[max_position]));
            result.add(Double.parseDouble((((str[right])!=null)&&(str[right])!="")?str[right]:str[max_position]));

            return result.toString().replace(" ","");
        } catch (Exception e) {
            return "Error";
        }
    }
}