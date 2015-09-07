package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/28.
 */
public class Interference_Type_10_UDFTEST {

    Interference_Type_10_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Type_10_UDF();
        try {
            //String[] row = new String[]{"1", "1", "1", "1", null, "1"};
            int a = ave.evaluate(11,1,"0.1","GE","10","LT","and");
            Assert.assertEquals(1, a);
        } catch (Exception e) {
        }
    }

}