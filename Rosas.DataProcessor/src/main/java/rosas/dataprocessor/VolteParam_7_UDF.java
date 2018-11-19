package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Wei on 2018/08/01.
 */
 public class VolteParam_7_UDF extends UDF{
	 public String evaluate(String str){
		 try {
			 String[] Strlist=str.replace("{","").replace("}","").replace("(","").replace(")","").split(",");
			 int min=-100000;
			 for(int i=0;i<Strlist.length;i++)
			 {
				 if(!Strlist[i].equals("NA"))
				 {
					 min=Integer.parseInt(Strlist[i])<min?Integer.parseInt(Strlist[i]):min;
				 }
			 }
			 return String.valueOf(min);
			 } catch (Exception ex) {
				 return "NULL";
			}
	 }
 }
 