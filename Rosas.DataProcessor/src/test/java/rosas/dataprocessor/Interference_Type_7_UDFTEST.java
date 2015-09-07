package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/28.
 */
public class Interference_Type_7_UDFTEST {

    Interference_Type_7_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Type_7_UDF();
        try {

            int a = ave.evaluate(0,2,"0.5","GT","1.5","LE");
            Assert.assertEquals(0, a);
        } catch (Exception e) {
        }
    }

}