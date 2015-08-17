package rosas.dataprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

/**
 * Created by Zhuang on 2015/7/28.
 * LTE邻区漏定义分析
 */


public class LTE_AdjacentAreaLeakageDefinition_UDAF extends UDAF {
    public static class UDAFState {
        private int index = 0;
        private Long total = 0L;
        private double v3 = 0;
        private String op3 = "";
    }

    static final Log LOG = LogFactory.getLog(LTE_AdjacentAreaLeakageDefinition_UDAF.class.getName());

    public static class Evaluator implements UDAFEvaluator {

        UDAFState state;

        public Evaluator() {
            super();
            LOG.info("go into evaluator");
            state = new UDAFState();
            init();
        }

        public void init() {
            LOG.info("go into init");
            state.index = 0;
            state.total = 0L;
            state.v3 = 0;
            state.op3 = "";
        }

        public boolean iterate(String LteScRSRP, String LteNcRSRP,
                               Long total, String value1, String operator1, String value2, String operator2,
                               String value3, String operator3) throws Exception {
            try {
                LOG.info("go into iterate");
                try {
                    double a = Double.parseDouble(LteScRSRP);
                    double b = Double.parseDouble(LteNcRSRP);
                    double v1 = Double.parseDouble(value1);
                    double v2 = Double.parseDouble(value2);
                    String op1 = operator1;
                    String op2 = operator2;
                    state.v3 = Double.parseDouble(value3);
                    state.op3 = operator3;

                    boolean result1 = compare(a, op1, v1);
                    boolean result2 = compare(b - a, op2, v2);

                    if (result1 && result2) {
                        state.index++;
                    }
                } catch (Exception e) {
                }
                state.total = total;
            } catch (Exception e) {
                LOG.error(e.toString());
                throw e;
            }
            return true;
        }

        private boolean compare(double temp1, String op, double temp2) {
            if (op == "大于") {
                return temp1 > temp2;
            } else if (op == "小于") {
                return temp1 < temp2;
            } else if (op == "大于等于") {
                return temp1 >= temp2;
            } else if (op == "小于等于") {
                return temp1 <= temp2;
            } else if (op == "等于") {
                return temp1 == temp2;
            } else {
                return false;
            }
        }

        public UDAFState terminatePartial() {
            LOG.info("go into terminatePartial");
            return state;
        }

        public boolean merge(UDAFState mState) {
            try {
                if (mState != null) {
                    state.index = mState.index;
                    state.total = mState.total;
                    state.v3 = mState.v3;
                    state.op3 = mState.op3;
                }
            } catch (Exception e) {
                LOG.error(e.toString());
            }
            return true;
        }

        public int terminate() {
            LOG.info("terminate");
            if (state.total != 0) {
                if (compare((state.index * 1.0 / state.total), state.op3, state.v3))
                    return 1;
                else
                    return 0;
            } else
                return 0;
        }
    }
}