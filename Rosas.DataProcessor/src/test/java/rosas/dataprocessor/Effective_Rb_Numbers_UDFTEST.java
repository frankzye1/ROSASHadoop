package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/24.
 */
public class Effective_Rb_Numbers_UDFTEST {
    Effective_Rb_Numbers_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Effective_Rb_Numbers_UDF();
        try {
            String[] row = new String[]{"", "0", "0", "0", null, "2", "2", "2", "2", "2", "2"};
            int a = ave.evaluate(row);
            Assert.assertEquals(9, a);
        } catch (Exception e) {
        }
    }

}
