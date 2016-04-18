package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.*;

/**
 * Created by Administrator on 2016/4/11.
 */
public class IF_Top15AndTail15_UDF extends UDF {
    public double evaluate(String[] str) {
        try {
            str = Common.MissingValueProcess(str);
            Map<Integer, Double> map = new HashMap<Integer, Double>();
            for (int i = 0; i < str.length; i++) {
                map.put(i, Double.parseDouble(str[i]));
            }
            List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(map.entrySet());
            //∂‘÷µ≈≈–Ú
            Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
                public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                    return Double.compare(o2.getValue() * 100, (o1.getValue()) * 100);
                }
            });
            //»°top15
            list.subList(0, list.size() < 15 ? list.size() : 15);

            double result = 0;
            List<Integer> Tail15=new ArrayList<Integer>(){};
            Tail15.add(99);
            Tail15.add(98);
            Tail15.add(97);
            Tail15.add(96);
            Tail15.add(95);
            Tail15.add(94);
            Tail15.add(93);
            Tail15.add(92);
            Tail15.add(91);
            Tail15.add(90);
            Tail15.add(89);
            Tail15.add(88);
            Tail15.add(87);
            Tail15.add(86);
            Tail15.add(85);


            for (int i = 0; i < (list.size() < 15 ? list.size() : 15) - 1; i++) {
                 if (Tail15.contains(list.get(i).getKey()))
                 {
                     result++;
                 }
            }
            return Math.round(result * 10000.0 / 15) / 10000.0;
        } catch (Exception e) {
            return 0;
        }
    }
}