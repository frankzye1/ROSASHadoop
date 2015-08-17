package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/6.
 */
public class MR_OverCoverageIndex_UDFTEST {

    MR_OverCoverageIndex_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new MR_OverCoverageIndex_UDF();
        try {
            String a = ave.evaluate("10", "5", 5L, "6", "GT", "-6", "GT", "0.1", "GT");
            Assert.assertEquals("R1:trueR2:trueR:1", a);
        } catch (Exception e) {
        }
    }

}



