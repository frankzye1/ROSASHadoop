package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;
import parquet.it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import parquet.it.unimi.dsi.fastutil.doubles.DoubleList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class MR_SectorCoverage_NEW_UDF extends UDF {
    public double evaluate(String[] rates) {
        try {
            List<Double> aoa = new ArrayList<Double>();

            for (int i = 0; i < rates.length; i++) {
                double a = 0;
                try {
                    a = Double.parseDouble(rates[i]);
                } catch (Exception ex) {
                }
                aoa.add(a);
            }
            double five_aoa_sum=0;
            double max=-10000;
            double result=0;
            int j1,j2,j3,j4,j5;
            for(int j=0;j<aoa.size();j++)
            {
                j1=j;
                j2=j+1;
                j3=j+2;
                j4=j+3;
                j5=j+4;
                if (j2>=aoa.size())
                {
                    j2=j2-aoa.size();
                }
                if (j3>=aoa.size())
                {
                    j3=j3-aoa.size();
                }
                if (j4>=aoa.size())
                {
                    j4=j4-aoa.size();
                }
                if (j5>=aoa.size())
                {
                    j5=j5-aoa.size();
                }
                five_aoa_sum=aoa.get(j1)+aoa.get(j2)+aoa.get(j3)+aoa.get(j4)+aoa.get(j5);
                if (five_aoa_sum>max)
                {
                    max=five_aoa_sum;
                    result=j3;
                }

            }


            return (result*5-2.5);
        } catch (Exception e) {
            return -1;
        }
    }
}