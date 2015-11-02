package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/7.
 */
public class Interference_Type_12_UDFTEST {

    Interference_Type_12_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Type_12_UDF();
        try {

            int a = ave.evaluate(10,1,"ge","5","6","ge","5","ge","5","[92,5,52,7,90,50]","4","GE","7","EQ","92","EQ","50","GE","52","LE","and");
            Assert.assertEquals(1, a);
        } catch (Exception e) {
        }
    }
}
