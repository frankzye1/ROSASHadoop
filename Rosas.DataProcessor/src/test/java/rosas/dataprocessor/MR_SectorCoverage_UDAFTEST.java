package rosas.dataprocessor;

/**
 * Created by fzhang1 on 2015/7/1.
 */

import static org.junit.Assert.assertEquals;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MR_SectorCoverage_UDAFTEST {
    MR_SectorCoverage_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new MR_SectorCoverage_UDAF.Evaluator();
        String[] rates = new String[]{"0", "1", "2"};
        try {
            ave.iterate(rates);
            double v = ave.terminate();
            Assert.assertEquals(0.3333, v);
        } catch (Exception e) {

        }
    }
}
