package rosas.dataprocessor;

import junit.framework.Assert;
import org.junit.Test;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/11/25.
 */
public class letTest {
    LTE_UDAF.Evaluator ave;

    @Test
    public void evaluatesExpression() {


        Double asd=Common.FUN1(121D);
        Double asd1=Common.FUN2(asd*2);

        InteroperabilityParameters_8_UDF aaa=new InteroperabilityParameters_8_UDF();
        double a=aaa.evaluate("{(NA,NA,2)}\n" +
                "{(NA,3),(NA,6)}\n" +
                "{(NA,4)}\n" +
                "{NA,{38950,37900,38098},}\n" +
                "{NA,{39148,38098,38950,38400},0}\n" +
                "{(NA,6)}\n" +
                "{(NA,0),(NA,8)}\n" +
                "{(NA,0),(NA,30)}\n" +
                "{}\n" +
                "{(NA,{37900,38098,38950,39148,38952},3)}\n" +
                "{(NA,{37900,38098,38950,40936},3)}\n" +
                "{(NA,{37900,38100,38950,38544},3)}\n" +
                "{(NA,{37900,38950,38350},3)}\n" +
                "{(NA,{37900,38950,39148,38098,38544},3)}\n" +
                "{(NA,{37900,39250,38100,38400},3)}\n" +
                "{(NA,{38100,38350,38950},3)}\n");


        InteroperabilityParameters_5_UDF aa=new InteroperabilityParameters_5_UDF();
        double b =aa.evaluate("{NA,{28950},0}" ,0.5, 0.0, "GT", 3.0);

        return;

    }
}
