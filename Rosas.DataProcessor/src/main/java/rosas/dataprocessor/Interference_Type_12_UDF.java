package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/7.
 */
public class Interference_Type_12_UDF  extends UDF {
    public int evaluate(String variance,String P11_OP1,String P11_V1,String P12_OP1,String P12_V1,
            String peak_position,String P7_V1,String P7_OP1,
                        String P8_V1,String P8_OP1,String P9_V1,String P9_OP1,
                        String P10_V1,String P10_OP1,String P10_V2,String P10_OP2,String P10_LOGIC)
    {
        try {
            if (peak_position.length() <= 2) {
                return 0;
            }
            peak_position = peak_position.replace("[", "").replace("]", "");
            String[] positions = peak_position.split(",");
            if (Common.compare(positions.length, P7_OP1, Integer.parseInt(P7_V1)))
            {
                //int count = 0;
                boolean b1=false;
                boolean b2=false;
                boolean b3=false;
                boolean b4=false;
                boolean b5=false;

                if (Common.compare(positions.length, P12_OP1, Integer.parseInt(P12_V1)))
                {
                    b4=true;
                }

                if (Common.compare(Double.parseDouble(variance), P11_OP1, Double.parseDouble(P11_V1)))
                {
                    b5=true;
                }

                for (int i = 0; i < 4; i++)
                {
                    int position = Integer.parseInt(positions[i]);
                    if (Common.compare(position, P8_OP1, Integer.parseInt(P8_V1)))
                    {
                        b1=true;
                    }
                }
                for (int i = 0; i < 4; i++)
                {
                    int position = Integer.parseInt(positions[i]);
                    if (Common.compare(position, P9_OP1, Integer.parseInt(P9_V1)))
                    {
                        b3=true;
                    }
                }

                for (int i = 0; i < 4; i++)
                {
                    int position = Integer.parseInt(positions[i]);
                    if(Common.LogicFun(Common.compare(position, P10_OP1, Integer.parseInt(P10_V1)), P10_LOGIC, Common.compare(position, P10_OP2, Integer.parseInt(P10_V2))))
                    {
                        b2=true;
                    }
                }

                if (b1&&b2&&b3)
                {
                    return 1;
                }
                else if (b4&&b5)
                {
                    return 2;
                }
                else
                {
                    return 0;
                }

            } else {
                return 0;
            }



        } catch (Exception e) {
            return -1;
        }
    }
}