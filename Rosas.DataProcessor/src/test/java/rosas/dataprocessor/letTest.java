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

        InteroperabilityParameters_5_UDF aa=new InteroperabilityParameters_5_UDF();
        double b =aa.evaluate("{(NA,25)}" ,1.0, - 115.0, "LT", - 93.0);

        return;

    }
}
