package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Wei on 2018/08/01.
 */
 public class VolteParam_6_UDF extends UDF{
	 public String evaluate(String str){
		 try {
			 String[] Strlist=str.replace("{","").replace("}","").replace("(","").replace(")","").split(",");
			 int max=-100000;
			 for(int i=0;i<Strlist.length;i++)
			 {
				 if(!Strlist[i].equals("NA"))
				 {
					 max=Integer.parseInt(Strlist[i])>max?Integer.parseInt(Strlist[i]):max;
				 }
			 }
			 return String.valueOf(max);
			 } catch (Exception ex) {
				 return "NULL";
			}
	 }
 }
 