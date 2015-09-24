package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/17.
 */
public class Param_Analysis_19_UDFTEST  {
    Param_Analysis_19_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_19_UDF();
        try {
            int v = ave.evaluate("40","5","AN2","NE","6","NE","5");
            Assert.assertEquals(1, v);
        } catch (Exception e) {

        }
    }
}