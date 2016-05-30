package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/4/22.
 * 聚类突变top数量值
 */
public class IF_ClusterMutationTopCount_UDF  extends UDF {
    public int evaluate(String[] str) {
        try {
            str=Common.MissingValueProcess(str);//处理空值

            List<Double> list = new ArrayList<Double>();
            for (int i = 0; i < str.length; i++) {
                list.add(Double.parseDouble(str[i]));
            }
            Collections.sort(list);
            //Collections.reverse(list);
            int result=0;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i+1)-list.get(i)>1.8)
                {
                    result=list.size()-(i+1);
                    break;
                }

            }
            return result;

        } catch (Exception e) {
            return 0;
        }
    }
}