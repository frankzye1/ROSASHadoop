package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/7.
 */
public class MR_OverLapCoverage_UDAFTEST {
    MR_OverLapCoverageIndex_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new MR_OverLapCoverageIndex_UDAF.Evaluator();
        try {
            ave.iterate(5,4,"GT","0",10L,1);
            double v = ave.terminate();
            Assert.assertEquals(0.1, v);
        } catch (Exception e) {

        }
    }

}
