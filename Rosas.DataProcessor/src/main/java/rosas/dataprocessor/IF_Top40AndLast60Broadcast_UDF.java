package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.*;

/**
 * Created by Administrator on 2016/4/11.
 * IF_Top40AndLast60◊Ó–°≤Ó“Ï
 */
public class IF_Top40AndLast60Broadcast_UDF extends UDF {
    public double evaluate(String[] str) {
        try {
            str = Common.MissingValueProcess(str);
            List<Double> list = new ArrayList<Double>();
            for (int i = 0; i < str.length; i++) {
                list.add(Double.parseDouble(str[i]));
            }
            Collections.sort(list);
            Collections.reverse(list);
            double avg_top40 = 0;
            double avg_last60 = 0;

            for (int i = 0; i < str.length; i++) {
                if (i < 40) {
                    avg_top40 += list.get(i);

                } else {
                    avg_last60 += list.get(i);
                }
            }
            avg_top40 = avg_top40 / 40.0;
            avg_last60 = avg_last60 / 60.0;

            return Math.round((avg_top40 - avg_last60)*100.0)/100.0;

        } catch (Exception e) {
            return 0;
        }
    }
}