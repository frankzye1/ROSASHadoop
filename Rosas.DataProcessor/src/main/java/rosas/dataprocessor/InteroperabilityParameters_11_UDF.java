package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Administrator on 2016/10/21.
 */
public class InteroperabilityParameters_11_UDF  extends UDF {
    public String evaluate(String str) {
        try {
            if (str.indexOf("(")>=0)//{(9,NA,20),(8,NA,20),(7,NA,20),(6,NA,20),(5,NA,20),(4,NA,20),(3,NA,20),(2,NA,20),(1,NA,22)}
            {
                String[] strlist=Common.StrToList1(str);

                for(int i=0 ;i<strlist.length;i++)
                {
                    String aa=strlist[i].replace("(","").replace(")","");
                    String[] kk=aa.split(",");
                    if (kk[0].equals("NA")||kk[0].equals("9"))
                    {

                        return  kk[kk.length-1];
                    }
                    //{(1,{38950,37900,39150,1825,100,1650,500},3),(2,{38950,37900,39150,1825,100,1650,500},3),(3,{38950,37900,39150,1825,100,1650,500},3),(4,{38950,37900,39150,1825,100,1650,500},3),(5,{38950,37900,39150,1825,100,1650,500},3),(6,{38950,37900,39150,1825,100,1650,500},3),(7,{38950,37900,39150,1825,100,1650,500},3),(8,{38950,37900,39150,1825,100,1650,500},3),(9,{38950,37900,39150,1825,100,1650,500},3)}

                }
            }
            else//{NA,{46,64,70,49,566,37,43,34,73,88,16,55,79,13,58,85,61},25}
            {
                return  str.substring(str.lastIndexOf(",")+1,str.lastIndexOf("}"));
            }
        } catch (Exception ex) {
            return "NULL";
        }
        return "NULL";
    }
}