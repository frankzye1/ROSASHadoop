package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/3/18.
 */
public class TrigonometricFun_COS extends UDF {
    public Double evaluate(Double parm) {
        try {
            return Math.round(Math.cos(parm * Math.PI / 180)*100000.0)/100000.0;
        } catch (Exception e) {
            return null;
        }

    }

    public  Double evaluate() {
        return null;
    }

}