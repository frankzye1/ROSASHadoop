package rosas.dataprocessor;

/**
 * Created by Zhuang on 2015/7/31.
 */
import junit.framework.Assert;
import org.junit.Test;

public class Antenna_Reverse_Analysis_UDFTEST {
    Antenna_Reverse_Analysis_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Antenna_Reverse_Analysis_UDF();
        try {
            int a =ave.evaluate("200","70");
            Assert.assertEquals(1, a);
        } catch (Exception e) {

        }
    }
}
