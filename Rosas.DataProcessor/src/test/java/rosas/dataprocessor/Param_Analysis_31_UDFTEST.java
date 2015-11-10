package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/11/9.
 */
public class Param_Analysis_31_UDFTEST {
    Param_Analysis_31_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_31_UDF();
        try {
            int v = ave.evaluate("{(1,),(1,),(1,),(1,),(2,),(2,)}","lt","1");
            Assert.assertEquals(0, v);
        } catch (Exception e) {

        }
    }
}
