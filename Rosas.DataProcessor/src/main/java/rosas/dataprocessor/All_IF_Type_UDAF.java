package rosas.dataprocessor;

        import org.apache.commons.logging.Log;
        import org.apache.commons.logging.LogFactory;
        import org.apache.hadoop.hive.ql.exec.UDAF;
        import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

/**
 * Created by Zhuang on 2015/8/4.
 */
public class All_IF_Type_UDAF  extends UDAF {
    public static class UDAFState {
        private int index = 0;
        private Long total = 0L;
        private double v3 = 0;
        private String op3 = "";
        private String all_type="";
    }

    static final Log LOG = LogFactory.getLog(All_IF_Type_UDAF.class.getName());

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
            state.all_type="";
        }

        public boolean iterate(String type) throws Exception {
            try {
                LOG.info("go into iterate");
                state.all_type+=(";"+type);


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
                    state.all_type=mState.all_type;
                }
            } catch (Exception e) {
                LOG.error(e.toString());
            }
            return true;
        }

        public String terminate() {
            LOG.info("terminate");
            return state.all_type.substring(1,state.all_type.length());
        }
    }
}