package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/29.
 */
public class Param_Analysis_8_UDAFTEST {
    Param_Analysis_8_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_8_UDAF.Evaluator();
        try {
            ave.iterate("a","a");
            int v = ave.terminate();
            Assert.assertEquals(1, v);
        } catch (Exception e) {

        }
    }
}
