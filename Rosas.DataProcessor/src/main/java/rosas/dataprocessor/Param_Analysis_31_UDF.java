package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by Zhuang on 2015/9/30.
 */
public class Param_Analysis_31_UDF extends UDF
{
    public int evaluate(String Str,String op1,String v1)
    {
        try
        {
           return 0;

        }
        catch (Exception e)
        {
            return 0;
        }
    }
}