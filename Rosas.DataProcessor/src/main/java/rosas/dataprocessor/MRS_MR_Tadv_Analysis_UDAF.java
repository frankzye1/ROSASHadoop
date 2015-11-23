package rosas.dataprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;



public class MRS_MR_Tadv_Analysis_UDAF extends UDAF {
    public static class UDAFAvgPriceState {
        private double rate = 0;
        private double rateTotal = 0;
    }

    static final Log LOG = LogFactory.getLog(MRS_MR_Tadv_Analysis_UDAF.class.getName());

    public static class Evaluator implements UDAFEvaluator {

        UDAFAvgPriceState state;

        public Evaluator() {
            super();
            LOG.info("go into evaluator");
            state = new UDAFAvgPriceState();
            init();
        }

        public void init() {
            LOG.info("go into init");
            state.rate = 0;
            state.rateTotal = 0;
        }

        public boolean iterate(int num,String[] rates) throws Exception {
            try {
                int length = rates.length;
                for (int i = 0; i < length; i++) {
                    double rate = 0;
                    try {
                        rate = Double.parseDouble(rates[i].replace("\"", ""));
                    } catch (Exception e) {
                    }
                    if (i <=num) {
                        state.rate += rate;
                    }
                    state.rateTotal += rate;
                }
            } catch (Exception e) {
                LOG.error(e.toString());
                //throw e;
            }
            return true;
        }

        public UDAFAvgPriceState terminatePartial() {
            LOG.info("go into terminatePartial");
            return state;
        }

        public boolean merge(UDAFAvgPriceState mState) {
            try {
                if (mState != null) {
                    state.rate += mState.rate;
                    state.rateTotal += mState.rateTotal;
                }
            } catch (Exception e) {
                LOG.error(e.toString());
            }
            return true;
        }

        public double terminate() {
            if (state.rateTotal != 0) {
                return state.rate/state.rateTotal;
            } else
                return -1;
        }
    }
}

