package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/25.
 */
public class Level1_Interference_Rb_Numbers_UDFTEST {
    Level1_Interference_Rb_Numbers_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Level1_Interference_Rb_Numbers_UDF();
        try {
            String[] row = new String[]{"", "10", "10", "10", "12", "12", "12", null, "10", "10", "10", "10", "10", "10", "10","", "10", "10", "10", null, "10", "10", "10", "10", "10", "10", "10"};
            int a = ave.evaluate("GT","5","and","LE","10",row);
            Assert.assertEquals(20, a);
        } catch (Exception e) {
        }
    }

}
