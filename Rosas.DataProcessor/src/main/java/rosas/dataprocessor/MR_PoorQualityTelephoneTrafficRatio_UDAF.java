package rosas.dataprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

//
//MR质差话务比例
//

public class MR_PoorQualityTelephoneTrafficRatio_UDAF extends UDAF {
    public static class UDAFAvgPriceState {
        private int rate = 0;
        private int rateTotal = 0;
    }

    static final Log LOG = LogFactory.getLog(MR_PoorQualityTelephoneTrafficRatio_UDAF.class.getName());

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

        public boolean iterate(String[] rates) throws Exception {
            try {
                LOG.info("go into iterate");
                int length = rates.length;
                LOG.info("iterate length:" + length);
                for (int i = 0; i < length; i++) {
                    int rate = 0;
                    try {
                        rate = Integer.parseInt(rates[i].replace("\"", ""));
                    } catch (Exception e) {
                    }
                    if (i < 10) {
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
            LOG.info("terminate");
            LOG.info("state.rate:" + state.rate);
            LOG.info("state.rateTotal:" + state.rateTotal);
            if (state.rateTotal != 0) {
                return CommonFunction.ReservedDecimal(state.rate * 1.0 / state.rateTotal);
            } else
                return 0;
        }
    }
}