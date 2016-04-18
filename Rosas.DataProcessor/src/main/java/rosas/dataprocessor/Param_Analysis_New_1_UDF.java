package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/1/18.
 */
public class Param_Analysis_New_1_UDF extends UDF {
    public int evaluate(String PA, String BANDINDICATOR, String ANTENNAPORTSCOUNT) {
        try {
            if (PA == null || PA.equals("") || PA.equals("null") || PA.equals("NULL")) {
                return 0;
            }


            if (BANDINDICATOR == "38" || BANDINDICATOR == "39") {
                if (PA != "DB-3") {
                    return 1;
                }
            } else if (BANDINDICATOR == "40") {
                if (ANTENNAPORTSCOUNT!="AN1") {
                    if (PA != "DB-3")
                    {
                        return 1;
                    }
                }
                else
                {
                    if (PA != "DB-0")
                    {
                        return 1;
                    }
                }
            }


            return 0;

        } catch (Exception e) {
            return -1;
        }
    }
}