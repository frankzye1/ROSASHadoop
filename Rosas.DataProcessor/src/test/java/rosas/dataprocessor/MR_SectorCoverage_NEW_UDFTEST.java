package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/12/3.
 */
public class MR_SectorCoverage_NEW_UDFTEST {
    MR_SectorCoverage_NEW_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new MR_SectorCoverage_NEW_UDF();
        try {
            String[] strString=new String[]{"11","12","13","14","15","16","7","8","9"};
            double v = ave.evaluate(strString);
            Assert.assertEquals(67.5, v);
        } catch (Exception e) {

        }
    }
}