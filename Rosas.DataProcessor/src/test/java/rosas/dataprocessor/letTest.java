package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/11/25.
 */
public class letTest {
    LTE_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new LTE_UDAF.Evaluator();
        try {

            ave.iterate("10","5", 4L,"6","GT","-6","GT","0.1","GT");
            double v = ave.terminate();
            Assert.assertEquals(0.25, v);
        } catch (Exception e) {

        }
    }
}
