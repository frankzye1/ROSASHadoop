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
            String v = ave.evaluate(41,"PSF","defff","{(1,PSF18),(2,PSF8),(3,PSF8),(4,PSF18),(5,PSF8),(6,PSF8),(7,PSF8),(8,PSF8),(9,PSF8)}","EQ","8","EQ","18");
            Assert.assertEquals("QCI2ֵΪPSF8;QCI3ֵΪPSF8;QCI5ֵΪPSF8;QCI6ֵΪPSF8;QCI7ֵΪPSF8;QCI8ֵΪPSF8;QCI9ֵΪPSF8;", v);
        } catch (Exception e) {

        }
    }
}