

package rosas.dataprocessor;

        import junit.framework.Assert;
        import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/3.
 */
public class All_IF_Type_UDAFTEST {
    All_IF_Type_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {
        ave = new All_IF_Type_UDAF.Evaluator();
        try {
            ave.iterate("超级干扰");
            String v = ave.terminate();
            Assert.assertEquals("超级干扰", v);
        } catch (Exception e) {

        }
    }

}
