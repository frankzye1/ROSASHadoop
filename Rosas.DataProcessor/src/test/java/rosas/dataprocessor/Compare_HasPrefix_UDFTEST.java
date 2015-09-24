package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/21.
 */
public class Compare_HasPrefix_UDFTEST {

    Compare_HasPrefix_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Compare_HasPrefix_UDF();
        try {
            int a = ave.evaluate("rf6", "gT", "-6","rf");
            Assert.assertEquals(1, a);
        } catch (Exception e) {
        }
    }

}
