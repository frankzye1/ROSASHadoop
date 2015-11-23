package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/11/19.
 */
public class MRS_MR_Tadv_Analysis_UDAFTEST {
    MRS_MR_Tadv_Analysis_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new MRS_MR_Tadv_Analysis_UDAF.Evaluator();
        String[] rates = new String[]{"\"0\"","\"0\"","\"0\"","\"1\"","\"25\"","\"117\"","\"36\"","\"145\"","\"261\"","\"57\"","\"1\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\"","\"0\""};
        try {
            ave.iterate(6,rates);
            double v = ave.terminate();
            Assert.assertEquals(0.1, v);
        } catch (Exception e) {

        }
    }
}
