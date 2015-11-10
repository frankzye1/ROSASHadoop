package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/11/10.
 */
public class Param_Analysis_46_UDFTEST {
    Param_Analysis_46_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_46_UDF();
        try {
            int v = ave.evaluate("{(1,RF160),(2,RF160),(3,RF160),(4,RF160),(5,RF150),(6,RF160),(7,RF160),(8,RF160),(9,RF160)}","NE","160");
            Assert.assertEquals(1, v);
        } catch (Exception e) {

        }
    }
}