package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/9/18.
 */
public class Param_Analysis_36_UDFTEST {
    Param_Analysis_36_UDF ave;

    @Test
    public void evaluatesExpression() {
        ave = new Param_Analysis_36_UDF();
        try {
            int v = ave.evaluate("{(10055,13),(10063,13),(10071,13),(10080,13),(10088,13),(10104,13),(10112,13),(10120,13)}","{(10055,-60),(10063,-60),(10071,-60),(10080,-60),(10088,-60),(10104,-60),(10112,-60),(10120,-60)}","1","ge","-93","and","le","-10");
            Assert.assertEquals(-93, v);
        } catch (Exception e) {

        }
    }
}