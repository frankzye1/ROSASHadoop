package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/21.
 */
public class Param_Analysis_40_UDFTEST {
    Param_Analysis_40_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_40_UDF();
        try {
            int v = ave.evaluate("SF","{(1,SF160),(2,SF160),(3,SF160),(4,SF160),(5,SF150),(6,SF160),(7,SF160),(8,SF160),(9,SF160)}","NE","160");
            Assert.assertEquals(1, v);
        } catch (Exception e) {

        }
    }
}