package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/26.
 */
public class Interference_Type_1_UDFTEST {

    Interference_Type_1_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Type_1_UDF();
        try {
            String[] row = new String[]{"", "10", "10", "10", "12", "12", "12", null, "10", "10", "10", "10", "10", "10", "10","", "10", "10", "10", null, "10", "10", "10", "10", "10", "10", "10"};
            double a = ave.evaluate(row);
            Assert.assertEquals(236.0/23.0, a);
        } catch (Exception e) {
        }
    }

}