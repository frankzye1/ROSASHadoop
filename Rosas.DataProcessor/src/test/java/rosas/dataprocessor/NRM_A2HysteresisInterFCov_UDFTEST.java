package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/11/10.
 */
public class NRM_A2HysteresisInterFCov_UDFTEST {
    NRM_A2HysteresisInterFCov_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new NRM_A2HysteresisInterFCov_UDF();
        try {
            String v = ave.evaluate("��Ϊ","(NA,)");
            System.out.print("���"+v);
            Assert.assertEquals(29, Integer.parseInt(v));
        } catch (Exception e) {

        }
    }
}