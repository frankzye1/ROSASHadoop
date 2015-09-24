package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_26_UDFTEST {
    Param_Analysis_26_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_26_UDF();
        try {
            int v = ave.evaluate("NOKIA1","AL08","NE","1","ne","0.8");
            Assert.assertEquals(1, v);
        } catch (Exception e) {

        }
    }
}