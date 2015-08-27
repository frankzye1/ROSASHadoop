package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/25.
 */
public class Interference_Level_UDFTEST {
    Interference_Level_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Level_UDF();
        try {
            String a = ave.evaluate(4.7,"GT","0","and","LE","1","GT","1","and","LE","2.5","GT","2.5","and","LE","4","GT","4");
            Assert.assertEquals("≥¨«ø∏…»≈", a);
        } catch (Exception e) {
        }
    }

}
