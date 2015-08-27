package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * Created by Zhuang on 2015/8/24.
 * 最大干扰电平
 */
public class Max_Interference_Level_UDF extends UDF {
    public double evaluate(String[] str) {
        try {
            double max=-1000000;
            for (int i = 0; i < str.length; i++) {
                if (str[i] != null && str[i] != "") {
                    double RBxValue=Double.parseDouble(str[i]);
                    if(RBxValue>max)
                    {
                        max=RBxValue;
                    }
                }
            }
            return max;
        } catch (Exception e) {
            return 0;
        }
    }
}