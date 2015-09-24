package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_28_UDFTEST {
    Param_Analysis_28_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_28_UDF();
        try {
            int v = ave.evaluate("DB0","DB3","ge","2","and","lt","4");
            Assert.assertEquals(1, v);
        } catch (Exception e) {

        }
    }
}