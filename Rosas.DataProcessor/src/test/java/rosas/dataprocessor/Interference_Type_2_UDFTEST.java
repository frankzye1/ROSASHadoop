package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/26.
 */
public class Interference_Type_2_UDFTEST {

    Interference_Type_2_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Type_2_UDF();
        try {
            String[] row = new String[]{"", "5", "15", "10", null, "10"};
            double a = ave.evaluate(row);
            Assert.assertEquals(12.5, a);
        } catch (Exception e) {
        }
    }

}