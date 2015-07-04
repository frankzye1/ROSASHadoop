package rosas.dataprocessor;

/**
 * Created by fzhang1 on 2015/7/1.
 */

import junit.framework.Assert;
import org.junit.Test;
import sun.security.util.BigInt;

import java.math.BigInteger;

public class MR_OverCoverageIndex_UDAFTEST {
    MR_OverCoverageIndex_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new MR_OverCoverageIndex_UDAF.Evaluator();
        try {
            ave.iterate("10","5", 12L);
            double v = ave.terminate();
            Assert.assertEquals(1.0, v);
        } catch (Exception e) {

        }
    }
}
