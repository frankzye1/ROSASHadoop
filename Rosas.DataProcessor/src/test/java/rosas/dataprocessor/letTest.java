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

        InteroperabilityParameters_11_UDF aaa=new InteroperabilityParameters_11_UDF();
        //String aa=aaa.evaluate("{NA,{38950,37900,38400},30}");
        //String bb=aaa.evaluate("{(1,{38950,37900,38350,1650,100,1825,500},3),(2,{38950,37900,38350,1650,100,1825,500},3),(3,{38950,37900,38350,1650,100,1825,500},3),(4,{38950,37900,38350,1650,100,1825,500},3),(5,{38950,37900,38350,1650,100,1825,500},3),(6,{38950,37900,38350,1650,100,1825,500},3),(7,{38950,37900,38350,1650,100,1825,500},3),(8,{38950,37900,38350,1650,100,1825,500},3),(9,{38950,37900,38350,1650,100,1825,500},3)}");
        //String cc=aaa.evaluate("{(NA,NA,6)}");
        //String ss=aaa.evaluate("{(1,NA,2),(2,NA,2),(3,NA,2),(4,NA,2),(5,NA,2),(6,NA,2),(7,NA,2),(8,NA,2),(9,NA,2)}");
        //String[] a= Common.MissingValueProcess(new String[]{"89",null,"89","89",null,"90","89",null,"89","95",null,null,null,null,null});
        InteroperabilityParameters_11_UDF ak=new InteroperabilityParameters_11_UDF();
String kkkk=ak.evaluate("{(1,NA,2),(2,NA,2),(3,NA,2),(4,NA,2),(5,NA,2),(6,NA,2),(7,NA,2),(8,NA,2),(9,NA,44)}");


        return;

    }
}
