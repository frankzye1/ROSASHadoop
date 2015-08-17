package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/7.
 */
public class Compare_UDFTEST {

    Compare_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Compare_UDF();
        try {
            int a = ave.evaluate("6", "LT", "-6");
            Assert.assertEquals(0, a);
        } catch (Exception e) {
        }
    }

}
