package rosas.dataprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

/**
 * Created by Zhuang on 2015/8/4.
 */
public class GSM_AdjacentAreaLeakageDefinition_UDAF  extends UDAF {
    public static class UDAFState {
        private int index = 0;
        private Long total = 0L;
        private double v3 = 0;
        private String op3 = "";
    }

    static final Log LOG = LogFactory.getLog(GSM_AdjacentAreaLeakageDefinition_UDAF.class.getName());

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

        public boolean iterate(String p1, String op2, String v2,
                               Long total, String op3, String v3) throws Exception {
            try {
                LOG.info("go into iterate");
                try {
                    double a = Double.parseDouble(p1);
                    double b = Double.parseDouble(v2);

                    if (Common.compare(a, op2, b)) {
                        state.index++;
                    }
                } catch (Exception e) {
                }
                state.v3 = Double.parseDouble(v3);
                state.op3 = op3;
                state.total = total;
            } catch (Exception e) {
                LOG.error(e.toString());
                //throw e;
            }
            return true;
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
                if (Common.compare((state.index * 1.0 / state.total), state.op3, state.v3))
                    return 1;
                else
                    return 0;
            } else
                return 0;
        }
    }
}