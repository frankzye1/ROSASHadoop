package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/28.
 */
public class Interference_Type_7_UDFTEST {

    Interference_Type_3_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Type_3_UDF();
        try {
            String[] row = new String[]{"1", "1", "1", "1", null, "1"};
            double a = ave.evaluate(row);
            Assert.assertEquals(-0.002838, a);
        } catch (Exception e) {
        }
    }

}