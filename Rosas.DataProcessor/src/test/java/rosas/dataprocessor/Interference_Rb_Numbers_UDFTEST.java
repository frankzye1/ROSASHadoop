package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/25.
 */
public class Interference_Rb_Numbers_UDFTEST {
    Interference_Rb_Numbers_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Rb_Numbers_UDF();
        try {
            String[] row = new String[]{"", "10", "10", "10", "12", "12", "12", null, "10", "10", "10", "10", "10", "10", "10","", "10", "10", "10", null, "10", "10", "10", "10", "10", "10", "10"};
            int a = ave.evaluate("GT","5",row);
            Assert.assertEquals(23, a);
        } catch (Exception e) {
        }
    }

}
