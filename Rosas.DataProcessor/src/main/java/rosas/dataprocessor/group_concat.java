package rosas.dataprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

/**
 * Created by Administrator on 2016/9/26.
 */
public class group_concat    extends UDAF {
    public static class UDAFState {
        private String result_str = "";
    }

    static final Log LOG = LogFactory.getLog(Concat_Group_UDAF.class.getName());

    public static class Evaluator implements UDAFEvaluator {

        UDAFState state;

        public Evaluator() {
            super();
            state = new UDAFState();
            init();
        }

        public void init() {
            state.result_str="";
        }

        public boolean iterate(String fengefu,String str) throws Exception {
            try {
                state.result_str+=str+fengefu;
            } catch (Exception e) {
            }
            return true;
        }



        public UDAFState terminatePartial() {
            return state;
        }

        public boolean merge(UDAFState mState) {
            try {
                if (mState != null) {
                    state.result_str += mState.result_str;
                }
            } catch (Exception e) {
                LOG.error(e.toString());
            }
            return true;
        }

        public String terminate() {
            int length=state.result_str.length()>4000?4000:state.result_str.length();
            return state.result_str.substring(0, length-1);
        }
    }
}