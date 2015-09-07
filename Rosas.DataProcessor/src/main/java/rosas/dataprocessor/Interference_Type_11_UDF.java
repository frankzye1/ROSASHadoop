package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.List;

/**
 * Created by Zhuang on 2015/8/28.
 */
public class Interference_Type_11_UDF extends UDF {
    public int evaluate(int position,String left_max_right,String P6_V1,String P6_OP1,String P6_V2,String P6_OP2,String P6_LOGIC)
    {
        try
        {

            left_max_right=left_max_right.replace("[","").replace("]","");
            String[] temp= left_max_right.split(",");
            double left=Double.parseDouble(temp[0]);
            double max=Double.parseDouble(temp[1]);
            double right=Double.parseDouble(temp[2]);
            double avg=(left+max+right)/3;
            double variance=(((left-avg)*(left-avg))+((max-avg)*(max-avg))+((right-avg)*(right-avg)))/3;

            if ((variance>0.001)&&Common.LogicFun(Common.compare(position,P6_OP1,Double.parseDouble(P6_V1)),P6_LOGIC,Common.compare(position,P6_OP2,Double.parseDouble(P6_V2))))
            {
                return 1;
            }
            else
            {
                return 0;
            }


        } catch (Exception e) {
            return -1;
        }
    }
}