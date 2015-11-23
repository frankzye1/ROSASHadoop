package rosas.dataprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Update_site_info_UDAF extends UDAF {
    public static class UDAFAvgPriceState {
        private List<Double> list =new ArrayList<Double>();
        private int num = 0;
        private int index = 0;
    }

    static final Log LOG = LogFactory.getLog(Update_site_info_UDAF.class.getName());

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
            state.num = 0;
            state.index = 0;
            state.list =new ArrayList<Double>();
        }

        public boolean iterate(int num, String rates) throws Exception {
            try {

                state.num = num;
                double rate = 0;
                try {
                    rate = Double.parseDouble(rates.replace("\"", ""));
                }catch (Exception ex)
                {}
                if (state.index < state.num) {
                    state.list.add( rate);
                    state.index++;
                } else {
                    Collections.sort(state.list);
                    if (rate < state.list.get(state.num - 1)) {
                        state.list.remove(state.num - 1);
                        state.list.add(rate);
                    }


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
                    state.list = mState.list;
                    state.index += mState.index;
                    state.num += mState.num;
                }
            } catch (Exception e) {
                LOG.error(e.toString());
            }
            return true;
        }

        public double terminate() {

            double sum = 0;
            for (int i = 0; i < state.index; i++) {

                sum += state.list.get(i);
            }


            return sum / state.index;
        }
    }
}
