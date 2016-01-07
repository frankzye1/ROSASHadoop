package rosas.dataprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

/**
 * Created by Zhuang on 2015/9/29.
 */
public class Param_Analysis_8_UDAF extends UDAF {
    public static class UDAFAvgPriceState {

        private int count = 0;
    }

    static final Log LOG = LogFactory.getLog(Param_Analysis_8_UDAF.class.getName());

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
            //state.count = 0;
        }

        public boolean iterate(String a,String b) throws Exception {
            try {
                LOG.info("go into iterate");
                if (a==b)
                {
                    state.count+=1;

                }

            } catch (Exception e) {
                LOG.error(e.toString());
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
                    state.count += mState.count;
                }
            } catch (Exception e) {
                LOG.error(e.toString());
            }
            return true;
        }

        public int terminate() {
            LOG.info("terminate");
            LOG.info("state.count:" + state.count);
            return state.count;
        }
    }
}