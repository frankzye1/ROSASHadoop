package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/3.
 */
public class LTE_AdjacentAreaLeakageDefinition_UDAFTEST {
    LTE_AdjacentAreaLeakageDefinition_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new LTE_AdjacentAreaLeakageDefinition_UDAF.Evaluator();
        try {

            ave.iterate("1","2",50L,"0","����","0","����","0.02","����");
            double v = ave.terminate();
            Assert.assertEquals(111, v);
        } catch (Exception e) {

        }
    }

}
