package rosas.dataprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

/**
 * Created by Administrator on 2016/5/26.
 */
public class Concat_Group_UDAF   extends UDAF {
    public static class UDAFState {
        private String result_str = "";
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
            state.result_str="";
        }

        public boolean iterate(String str) throws Exception {
            try {
                LOG.info("go into iterate");
                state.result_str+=str+",";
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
                    state.result_str = mState.result_str;
                }
            } catch (Exception e) {
                LOG.error(e.toString());
            }
            return true;
        }

        public String terminate() {
            LOG.info("terminate");
                return state.result_str.substring(0,state.result_str.length()-1);
        }
    }
}