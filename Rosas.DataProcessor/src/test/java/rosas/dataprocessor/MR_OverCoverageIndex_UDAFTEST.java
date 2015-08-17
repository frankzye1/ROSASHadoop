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
            ave.iterate("10","5", 5L,"6","GT","-6","GT","0.1","GT");
            int v = ave.terminate();
            Assert.assertEquals(1, v);
        } catch (Exception e) {

        }
    }
}
