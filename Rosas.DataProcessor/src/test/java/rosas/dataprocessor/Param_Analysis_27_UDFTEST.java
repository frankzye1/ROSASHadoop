package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_27_UDFTEST {
    Param_Analysis_27_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_27_UDF();
        try {
            int v = ave.evaluate("38","60","NE","1","or","ne","0.8","NE","1","or","ne","0.8");
            Assert.assertEquals(1, v);
        } catch (Exception e) {

        }
    }
}