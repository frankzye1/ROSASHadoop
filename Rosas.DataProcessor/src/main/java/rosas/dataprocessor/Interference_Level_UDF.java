package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/8/25.
 */
public class Interference_Level_UDF extends UDF {
    public int evaluate(double IF_INDEX, String p1_op1, String p1_v1, String p1_LOGIC, String p1_op2, String p1_v2, String P2_op1, String P2_v1, String P2_LOGIC, String P2_op2, String P2_v2, String P3_op1, String P3_v1, String P3_LOGIC, String P3_op2, String P3_v2, String P4_op1, String P4_v1) {
        try {
            if (IF_INDEX == 0)
            {
                return 1;//"无干扰"
            }
            else if (Common.LogicFun(Common.compare(IF_INDEX, p1_op1, Double.parseDouble(p1_v1)), p1_LOGIC, Common.compare(IF_INDEX, p1_op2, Double.parseDouble(p1_v2))))
            {
                return 2;//"弱干扰"
            }
            else if (Common.LogicFun(Common.compare(IF_INDEX, P2_op1, Double.parseDouble(P2_v1)), P2_LOGIC, Common.compare(IF_INDEX, P2_op2, Double.parseDouble(P2_v2))))
            {
                return 3;//"一般干扰"
            }
            else if (Common.LogicFun(Common.compare(IF_INDEX, P3_op1, Double.parseDouble(P3_v1)), P3_LOGIC, Common.compare(IF_INDEX, P3_op2, Double.parseDouble(P3_v2))))
            {
                return 4;//"强干扰"
            }
            else if (Common.compare(IF_INDEX, P4_op1, Double.parseDouble(P4_v1)))
            {
                return 5;//"超强干扰"
            }
            else
            {
                return 6;//"参数无效"
            }

        } catch (Exception e) {
            return -1;
        }
    }
}