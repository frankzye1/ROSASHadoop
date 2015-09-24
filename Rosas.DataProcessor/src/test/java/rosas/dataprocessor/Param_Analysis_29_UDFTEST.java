package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_29_UDFTEST {
    Param_Analysis_29_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_29_UDF();
        try {
            int v = ave.evaluate("3","gt","5");
            Assert.assertEquals(1, v);
        } catch (Exception e) {

        }
    }
}