package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/21.
 */
public class Param_Analysis_40_UDFTEST {
    Param_Analysis_40_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_40_UDF();
        try {
            String v = ave.evaluate(40,"SF","{(1,SF160),(2,SF150),(3,SF140),(4,SF160),(5,SF160),(6,SF160),(7,SF160),(8,SF160),(9,SF160)}","EQ","160");
            Assert.assertEquals("£¨QCI2£©ÎªSF150;£¨QCI3£©ÎªSF140;", v);
        } catch (Exception e) {

        }
    }
}