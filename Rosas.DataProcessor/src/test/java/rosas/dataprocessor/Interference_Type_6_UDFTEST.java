package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/27.
 */
public class Interference_Type_6_UDFTEST {

    Interference_Type_6_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Type_6_UDF();
        try {
            String[] row = new String[]{"1", "2", "1", "1", null, "5"};
            String a = ave.evaluate(row);
            Assert.assertEquals("[5.0,5.0,5.0]", a);
        } catch (Exception e) {
        }
    }

}