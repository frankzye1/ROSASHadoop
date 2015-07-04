package rosas.dataprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;
import sun.security.util.BigInt;

import java.math.BigInteger;

//
//MR¹ı¸²¸ÇÏµÊı
//

public class MR_OverCoverageIndex_UDAF extends UDAF {
    public static class UDAFState {
        private int index = 0 ;
        private Long total = 0L ;
    }

    static final Log LOG = LogFactory.getLog(MR_OverCoverageIndex_UDAF.class.getName());

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

        public boolean iterate(String LteScRSRP,String LteNcRSRP, Long total) throws Exception {
            try {
                LOG.info("go into iterate");
                try {
                    int a = Integer.parseInt(LteScRSRP);
                    int b = Integer.parseInt(LteNcRSRP);
                    if (a > 6 && b - a > -6) {
                        state.index++;
                    }
                }catch(Exception e){}
                state.total =  total;
            } catch (Exception e) {
                LOG.error(e.toString());
                throw e;
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
                    state.index += mState.index;
                }
            } catch (Exception e) {
                LOG.error(e.toString());
            }
            return true;
        }

        public double terminate() {
            LOG.info("terminate");
            if (state.total != 0) {
                if (state.index * 1.0 / state.total > 0.01)
                    return 1;
                else
                    return 0;
            } else
                return 0;
        }
    }
}