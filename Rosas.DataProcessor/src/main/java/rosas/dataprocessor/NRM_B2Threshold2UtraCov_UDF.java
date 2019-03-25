package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.*;

public class NRM_B2Threshold2UtraCov_UDF extends UDF {


    public String evaluate(String a, String b) {
        try {
            if(a=="»ªÎª") {
                String[] Strlist = b.replace("(", "").replace(",", "").replace(")", ",").split(",");
                TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
                for (int i = 0; i < Strlist.length; i++) {
                    int index = -1;
                    char[] chars = Strlist[i].toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        if (chars[j] == 'N') {
                            index = j;
                            break;
                        }
                    }
                    map.put(Integer.parseInt(Strlist[i].substring(0, index)), Integer.parseInt(Strlist[i].substring(index + 2)));
                }
                return String.valueOf(map.get(map.firstKey()));
            }
            else{
                return b.substring(b.indexOf(",", b.indexOf(",")+1)+1,b.indexOf(")"));
            }
        }
        catch (Exception e)
        {
            return  "NULL";
        }
    }



}
