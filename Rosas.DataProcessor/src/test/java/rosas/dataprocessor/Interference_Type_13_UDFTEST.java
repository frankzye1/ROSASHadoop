package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/10/22.
 */
public class Interference_Type_13_UDFTEST {

    Interference_Type_13_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Type_13_UDF();
        try {
            String[] row = new String[]{"1", "12", "11", "10", null, "-1"};
            double a = ave.evaluate(row);
            Assert.assertEquals(12.0, a);
        } catch (Exception e) {
        }
    }

}