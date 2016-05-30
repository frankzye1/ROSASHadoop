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
            String[] row = new String[]{"10", "10", "10", "10", "10", "10", "10"};
            double a = ave.evaluate(row);
            double result=236.0/23.0;

            Assert.assertEquals(Common.ReservedDecimal(result), a);
        } catch (Exception e) {
        }
    }

}