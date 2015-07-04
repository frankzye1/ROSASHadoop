package rosas.dataprocessor;

/**
 * Created by fzhang1 on 2015/7/1.
 */

import junit.framework.Assert;
import org.junit.Test;

public class MR_DistrictUserDistribution_UDAFTEST {
    MR_DistrictUserDistribution_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new MR_DistrictUserDistribution_UDAF.Evaluator();
        String[] rates = new String[]{"abc", "0", "0", "0", "0", "0", "0", "2", "2", "2", "2", "2", "2"};
        try {
            ave.iterate(rates);
            double v = ave.terminate();
            Assert.assertEquals(1.0, v);
        } catch (Exception e) {

        }
    }
}
