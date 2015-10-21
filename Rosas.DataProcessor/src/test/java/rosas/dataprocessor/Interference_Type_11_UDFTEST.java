package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/28.
 */
public class Interference_Type_11_UDFTEST {

    Interference_Type_11_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Type_11_UDF();
        try {

            int a = ave.evaluate("[93,90]","3","GE",48,"[-118.678403,-117.127443,-117.180142]","47","GE","52","LE","and");
            Assert.assertEquals(1, a);
        } catch (Exception e) {
        }
    }

}