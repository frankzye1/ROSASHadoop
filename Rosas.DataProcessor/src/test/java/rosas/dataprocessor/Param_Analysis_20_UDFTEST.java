package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/17.
 */
public class Param_Analysis_20_UDFTEST {
    Param_Analysis_20_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_20_UDF();
        try {
            int v = ave.evaluate("-104","lt","-105","or","gt","-100");
            Assert.assertEquals(0, v);
        } catch (Exception e) {

        }
    }
}