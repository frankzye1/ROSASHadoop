package rosas.dataprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

/**
 * Created by Zhuang on 2015/8/3.
 */
public class TDS_AdjacentAreaLeakageDefinition_UDAF extends UDAF {
    public static class UDAFState {
        private int index = 0;
        private Long total = 0L;
        private double v3 = 0;
        private String op3 = "";
    }

    static final Log LOG = LogFactory.getLog(TDS_AdjacentAreaLeakageDefinition_UDAF.class.getName());

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
//MR_TdsPccpchRSCP,op2,v2,totle,op3,v3
        public boolean iterate(String MR_TdsPccpchRSCP, String op2, String v2,
                               Long total, String op3, String v3) throws Exception {
            try {
                LOG.info("go into iterate");
                try {
                    double a = Double.parseDouble(MR_TdsPccpchRSCP);
                    double b = Double.parseDouble(v2);
                    state.v3 = Double.parseDouble(v3);
                    state.op3 = op3;
                    state.total=total;
                    if (compare(a, op2, b)) {
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