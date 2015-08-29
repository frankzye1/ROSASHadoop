package rosas.dataprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

/**
 * Created by Zhuang on 2015/8/7.
 */
public class MR_OverLapCoverageIndex_UDAF extends UDAF {
    public static class UDAFState {
        private int index = 0;
        private Long total = 0L;
        private double v3 = 0;
        private String op3 = "";
    }

    static final Log LOG = LogFactory.getLog(MR_OverLapCoverageIndex_UDAF.class.getName());

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
        }

        //ev3(MR_LteNcRSRP,MR_LteScRSRP,op2,v2,YB_totle1)
        public boolean iterate(int LteNcRSRP, int LteScRSRP,String operator, String value,Long total, int flag) throws Exception {
            try {
                LOG.info("go into iterate");
                if (flag != 1) {
                    return true;
                }
                try {

                    String op = operator;
                    double v = Double.parseDouble(value);

                    if (CommonFunction.compare(LteNcRSRP - LteScRSRP, op, v)) {
                        state.index++;
                    }
                } catch (Exception e) {
                }
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
                }
            } catch (Exception e) {
                LOG.error(e.toString());
            }
            return true;
        }

        public double terminate() {
            LOG.info("terminate");
            if (state.total != 0) {
                try {
                    return CommonFunction.ReservedDecimal(state.index * 100.0 / state.total);
                } catch (Exception e) {
                    return 0;
                }
            } else
                return 0;
        }
    }
}