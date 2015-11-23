package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/11/20.
 */
public class Update_site_info_UDAFTEST {
    Update_site_info_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new Update_site_info_UDAF.Evaluator();
        try {
            ave.iterate(6,"2");
            double v = ave.terminate();
            Assert.assertEquals(2.0, v);
        } catch (Exception e) {

        }
    }

}
