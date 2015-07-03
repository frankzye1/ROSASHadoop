package rosas.dataprocess;

/**
 * Created by fzhang1 on 2015/7/1.
 */

import static org.junit.Assert.assertEquals;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AverageUDAFTest {
    AverageUDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new AverageUDAF.Evaluator();
        String[] rates = new String[]{"0", "1", "2"};
        try {
            ave.iterate(rates);
            double v = ave.terminate();
            Assert.assertEquals(0.53, v);
        } catch (Exception e) {

        }
    }
}
