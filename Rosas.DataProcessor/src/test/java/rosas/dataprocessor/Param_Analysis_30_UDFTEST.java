package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_30_UDFTEST {
    Param_Analysis_30_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_30_UDF();
        try {
            int v = ave.evaluate("3","4","5","ge","24");
            Assert.assertEquals(24, v);
        } catch (Exception e) {

        }
    }
}