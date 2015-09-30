package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_32_UDFTEST {
    Param_Analysis_32_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_32_UDF();
        try {
            int v = ave.evaluate("INDOOR","4","5","","ge","14","and","le","30","ge","14","and","le","30");
            Assert.assertEquals(18, v);
        } catch (Exception e) {

        }
    }
}