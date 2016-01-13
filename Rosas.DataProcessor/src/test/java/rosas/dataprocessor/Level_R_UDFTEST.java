package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2016/1/13.
 */
public class Level_R_UDFTEST {
    Level_R_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Level_R_UDF();
        try {

            int a = ave.evaluate("{(37900,5),(38950,1),(38400,6),(38098,1),(38550,1)}");
            Assert.assertEquals(0, a);
        } catch (Exception e) {
        }
    }
}
