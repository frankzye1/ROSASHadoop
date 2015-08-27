package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/24.
 */
public class Max_Interference_Level_UDFTEST{
    Max_Interference_Level_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Max_Interference_Level_UDF();
        try {
            String[] row = new String[]{"-119.473347","-119.358505","-119.370438","-119.425945"};
            double a = ave.evaluate(row);
            Assert.assertEquals(-119.358505, a);
        } catch (Exception e) {
        }
    }

}
