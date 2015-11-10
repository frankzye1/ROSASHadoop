package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/21.
 */
public class Param_Analysis_41_UDFTEST {
    Param_Analysis_41_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_41_UDF();
        try {
            int v = ave.evaluate("NOKIA","{(1,PSF18),(2,PSF8),(3,PSF8),(4,PSF18),(5,PSF8),(6,PSF8),(7,PSF8),(8,PSF8),(9,PSF8)}","EQ","8","EQ","18");
            Assert.assertEquals(1, v);
        } catch (Exception e) {

        }
    }
}