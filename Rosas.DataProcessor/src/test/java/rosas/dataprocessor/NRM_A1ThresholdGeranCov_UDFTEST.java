package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/11/10.
 */
public class NRM_A1ThresholdGeranCov_UDFTEST {
    NRM_A1ThresholdGeranCov_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new NRM_A1ThresholdGeranCov_UDF();
        try {
            String v = ave.evaluate("»ªÎª","(1,),(2,29),(3,29),(4,29),(5,29),(6,29),(65,29),(66,29),(69,29),(7,29),(70,29),(8,29),(9,29)");
            System.out.print("Êä³ö"+v);
            Assert.assertEquals(29, Integer.parseInt(v));
        } catch (Exception e) {

        }
    }
}