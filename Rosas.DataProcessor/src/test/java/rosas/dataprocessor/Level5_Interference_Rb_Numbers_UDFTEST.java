package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/29.
 */
public class Level5_Interference_Rb_Numbers_UDFTEST {
    Level5_Interference_Rb_Numbers_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Level5_Interference_Rb_Numbers_UDF();
        try {
            String[] row = new String[]{"", "10", "10", "-83.991469", "-83.991469", "12", "12", null, "10", "10", "10", "10", "10", "10", "10","", "10", "10", "10", null, "10", "10", "10", "10", "10", "10", "10"};
            int a = ave.evaluate("GE","-85",row);
            Assert.assertEquals(23, a);
        } catch (Exception e) {
        }
    }

}
