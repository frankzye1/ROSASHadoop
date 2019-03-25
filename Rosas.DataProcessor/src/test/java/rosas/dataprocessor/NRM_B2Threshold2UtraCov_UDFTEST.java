package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/11/10.
 */
public class NRM_B2Threshold2UtraCov_UDFTEST {
    NRM_B2Threshold2UtraCov_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new NRM_B2Threshold2UtraCov_UDF();
        try {
            String v = ave.evaluate("»ªÎª","(69,NA,12),(7,NA,12),(70,NA,12),(8,NA,12),(9,NA,12),(1,NA,12),(2,NA,12),(3,NA,12),(4,NA,12),(5,NA,12),(6,NA,12),(65,NA,12),(66,NA,12)");
            System.out.print("Êä³ö"+v);
            Assert.assertEquals(29, Integer.parseInt(v));
        } catch (Exception e) {

        }
    }
}