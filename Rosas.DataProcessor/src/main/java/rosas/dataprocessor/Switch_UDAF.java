package rosas.dataprocessor;

import org.apache.avro.generic.GenericData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/12/1.
 */
public class Switch_UDAF   extends UDAF {
    public static class UDAFState {
        private List<Double> list;
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
            state.list=new ArrayList<Double>();
        }

        public boolean iterate(Double num) throws Exception {
            try {
                LOG.info("go into iterate");
                state.list.add(num);


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
                    state.list.addAll(mState.list);
                }
            } catch (Exception e) {
                LOG.error(e.toString());
            }
            return true;
        }

        public int terminate() {
            LOG.info("terminate");
            Collections.sort(state.list);
            Collections.reverse(state.list);
            Double k=0.0;
            for(int i=0;i<state.list.size();i++)
            {
                k+=state.list.get(i);
                if (k>=0.5)
                {
                    return i+1;
                }
            }
            return 0;
        }
    }
}