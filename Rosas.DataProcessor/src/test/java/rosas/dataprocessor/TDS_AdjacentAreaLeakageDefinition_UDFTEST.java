package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/3.
 */
public class TDS_AdjacentAreaLeakageDefinition_UDFTEST {
    TDS_AdjacentAreaLeakageDefinition_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new TDS_AdjacentAreaLeakageDefinition_UDF();
        try {
            int a = ave.evaluate("10","µÈÓÚ", "10");
            Assert.assertEquals(1, a);
        } catch (Exception e) {

        }
    }

}
