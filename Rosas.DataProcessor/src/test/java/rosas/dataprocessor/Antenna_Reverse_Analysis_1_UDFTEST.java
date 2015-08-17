package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/7/31.
 */
public class Antenna_Reverse_Analysis_1_UDFTEST {

    Antenna_Reverse_Analysis_1_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Antenna_Reverse_Analysis_1_UDF();
        try {
            double a =ave.evaluate("200","70");
            Assert.assertEquals(130.0, a);
        } catch (Exception e) {

        }
    }
}