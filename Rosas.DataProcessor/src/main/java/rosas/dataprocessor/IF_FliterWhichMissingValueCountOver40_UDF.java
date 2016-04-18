package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/4/14.
 */
public class IF_FliterWhichMissingValueCountOver40_UDF  extends UDF {
    public boolean evaluate(String[] str) {
        try {


            int MissingValueCount=0;
            for (int i=0 ;i<str.length;i++)
            {

                try
                {
                    Double.parseDouble(str[i]);
                }
                catch (Exception ex)
                {
                    MissingValueCount++;
                }

            }

            if (MissingValueCount>40)
            {
                return false;
            }
            else
            {
                return true;
            }



        } catch (Exception e) {
            return false;
        }
    }
}