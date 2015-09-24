package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_35_UDFTEST {
    Param_Analysis_35_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_35_UDF();
        try {
            int v = ave.evaluate("4","5","6","ge","24","and","le","30");
            Assert.assertEquals(26, v);
        } catch (Exception e) {

        }
    }
}