package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/4.
 */
public class GSM_AdjacentAreaLeakageDefinition_UDFTEST {
    GSM_AdjacentAreaLeakageDefinition_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new GSM_AdjacentAreaLeakageDefinition_UDF();
        try {
            int a =ave.evaluate("200","µÈÓÚ","200");
            Assert.assertEquals(1, a);
        } catch (Exception e) {

        }
    }
}
