package rosas.dataprocessor;

/**
 * Created by fzhang1 on 2015/7/1.
 */

import junit.framework.Assert;
import org.junit.Test;

public class MR_Coverage_Rate_UDAFTEST {
    MR_SectorCoverage_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new MR_SectorCoverage_UDAF.Evaluator();
        String[] rates = new String[]{"0", "1", "2"};
        try {
            ave.iterate(rates);
            double v = ave.terminate();
            Assert.assertEquals(0.53, v);
        } catch (Exception e) {

        }
    }
}
