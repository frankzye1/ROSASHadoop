package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/11/10.
 */
public class Param_Analysis_34_UDFTEST {
    Param_Analysis_34_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_34_UDF();
        try {
            int v = ave.evaluate("{(38400,5),(38950,5),(37900,5)}","{(38400,-60),(38950,-60),(37900,-60),(38100,-61)}","0","ge","-112","and","le","-30");
            Assert.assertEquals(-110, v);
        } catch (Exception e) {

        }
    }
}
