package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/17.
 */
public class Param_Analysis_17_UDFTEST {
    Param_Analysis_17_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_17_UDF();
        try {
            int v = ave.evaluate("38","5","NE","6","or","NE","5","ne","7");
            Assert.assertEquals(1, v);
        } catch (Exception e) {

        }
    }
}
