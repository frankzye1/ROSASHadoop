package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Zhuang on 2015/8/26.
 */
public class Interference_Type_5_UDFTEST{

    Interference_Type_5_UDF ave;
    @Test
    public void evaluatesExpression() {
        ave = new Interference_Type_5_UDF();
        try {

            //异频A3事件偏移量为{(1,{37900,38098},3),(2,{37900,38098},3),(3,{37900,38098},3),(4,{37900,38098},3),(5,{37900,38098},3),(6,{37900,38098},3),(7,{37900,38098},3),(8,{37900,38098},3),(9,{37900,38098},3)}乘以0.5小于0或者大于3
            String[] row = new String[]{null,"51", "2", "1", "1", "2", "10", "11", "2", "1", "1", null, "5", "1", "2", "10", "21", "22", "23", "1"};
            String a = ave.evaluate(row);
            Assert.assertEquals("[6,23,12]", a);
        } catch (Exception e) {
        }
    }

}