package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_36_UDFTEST {
    Param_Analysis_36_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_36_UDF();
        try {
            int v = ave.evaluate("5","6","1","ge","22","and","le","30");
            Assert.assertEquals(23, v);
        } catch (Exception e) {

        }
    }
}