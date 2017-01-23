package rosas.dataprocessor;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/4/12.
 */
public class IF_GetTypeNo_UDF extends UDF {
    public int evaluate(double avg10to89 ,double slope9to49,double slope50to90,int ClusterMutationTopCount,int max_no, double slope, double smoothness, double standarddeviation, String peakindicatorvector, String peakindicatorvector_2, double top40indexaggregation, double top15andtail15, String flag, double xgxs, double Top40AndLast60Broadcast, double AvgTail15_85,double ave_if_nl,String BAND) {
        try {

            //网外干扰：
            //斜率（9-49）<-0.10  and 斜率（50-89）>0.10  and聚类突变top数量值<10 and峰值指示向量不存在（20-80）中
            if (slope9to49 < -0.10 && slope50to90 > 0.10 && ClusterMutationTopCount < 10 && !fun1(peakindicatorvector,20, 80) && standarddeviation<2.0 ) {
                return 9;
            }
            //杂散干扰：
            //IF  |斜率|>K6 0.12  and平滑度>K7 0.86 and标准差>2.8 and 聚类突变top数量值<4 and最后15个prb均值-前面85个PRB均值<4 and 峰值指示向量不存在（20-80）中
            else if (Math.abs(slope) > 0.12 && smoothness > 0.86 && standarddeviation > 2.8 && ClusterMutationTopCount<4&&AvgTail15_85<4&&!fun1(peakindicatorvector,20, 80)&&ave_if_nl<-100.0) {
                return 1;
            }
            //GPS干扰：
            //IF 49 or 50处为峰值and聚类突变top数量值<10，并且本小区相邻10公里的小区中有存在GPS故障小区。
            else if ((peakindicatorvector.indexOf("49") >= 0 || peakindicatorvector.indexOf("50") >= 0) && ClusterMutationTopCount<10 && flag == "1"&&ave_if_nl<-100.0) {
                return 2;
            }
            //同频干扰：
            //IF  {|斜率|<0.1 and平滑度>0.80 and 47 or 48 or 49 or 50 or 51处为峰值 and 峰值向量数<10聚类突变top数量值<10)} or {峰值指示向量只存在（47、48、49、50、51）}中 。
            else if (
                    ((Math.abs(slope) < 0.1 && smoothness > 0.80&& peakindicatorvector.split(",").length<10 && ClusterMutationTopCount<10
                            && (peakindicatorvector.indexOf("49") >= 0 || peakindicatorvector.indexOf("50") >= 0 || peakindicatorvector.indexOf("47") >= 0 || peakindicatorvector.indexOf("51") >= 0 || peakindicatorvector.indexOf("48") >= 0))&&ave_if_nl<-100.0)
                    || (Arrays.asList("47,48,49,50,51".split(",")).containsAll(Arrays.asList(peakindicatorvector.split(",")))&&ave_if_nl<-100.0)
                    ) {
                return 4;
            }
            //阻塞干扰：
            //IF -0.15<斜率<0.15 and平滑度>0.9 and 0-15存在峰值指示量and 相关性系数>0.60 and 均值(10-89prb)>-110 and 聚类突变top数量值<10  and  |斜率（9-49）|<0.1 and|斜率（50-89）|<0.1
            else if ((xgxs == 1111.0 || xgxs > 0.6) && slope > -0.15 && slope < 0.15 && smoothness > 0.9 && fun1(peakindicatorvector,0, 15) &&  ClusterMutationTopCount < 10 && Math.abs(slope9to49) < 0.1 && Math.abs(slope50to90) < 0.1) {
                return 6;
            }
            //宽频干扰：
            //IF |斜率|<0.1 and and |斜率（9-49）|<0.1 and|斜率（50-89）|<0.1 and平滑度>0.95  and 标准差<2.5 and最后15个prb均值-前面85个PRB均值<5 and相关性系数<0.6 and 均值(10-89prb)>-110 and 峰值指示向量数（参数为2）<3 and聚类突变top数量值<10，则判断为网外干扰-宽频干扰 。
            else if (Math.abs(slope) < 0.1 && Math.abs(slope9to49) < 0.1 && Math.abs(slope50to90) < 0.1 && smoothness > 0.95 && standarddeviation < 2.5 && AvgTail15_85 < 5.0 && avg10to89 > -110.0 && peakindicatorvector_2.split(",").length < 3 && ClusterMutationTopCount < 10 && (xgxs == 1111.0 || xgxs < 0.6)&&ave_if_nl>-95.0) {
                return 5;
            }
            //互调干扰：
            //IF峰值数量(参数为2的)大于等于3个 and 8、9、10、18、19、20时段存在干扰 and聚类突变top数量值<15  and最后15个prb均值-前面85个PRB均值<4
            else if (peakindicatorvector_2.split(",").length >= 3  && ClusterMutationTopCount < 15&& AvgTail15_85<4&&ave_if_nl<-95.0) {
                return 3;
            }
            //广电干扰：
            //IF  平滑度>0.80   and 20<聚类突变top数量值<70
            else if (smoothness > 0.8    && (ClusterMutationTopCount > 20 && ClusterMutationTopCount < 70)&& Math.abs(slope)<0.1&&BAND.equals("D")) {
                return 7;
            }
            //PHS干扰：
            //If 斜率>0 and平滑度>0.82 and 最后15个prb均值-前面85个PRB均值>5.
            else if (slope > 0.0 && smoothness > 0.82 && AvgTail15_85 > 5) {
                return 8;
            } else {
                return 0;//其他干扰
            }

        } catch (Exception e) {
            return 0;
        }


    }
//0-p存在峰值指示量
    public boolean fun1(String a,int n,int p){

        List<String> list = new ArrayList<String>() {
        };
        for (int i = n; i <= p; i++) {
            list.add(Integer.toString(i));
        }
        List<String> list1=Arrays.asList(a.split(","));
        try {
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (Integer.parseInt(list1.get(i)) == Integer.parseInt(list.get(j))) {
                        return true;
                    }

                }
            }
        }
        catch (Exception ex)
        {
            return false;
        }
        return false;

    }

}

/*

//杂散干扰：
//IF斜率<K6 -0.12 and平滑度>K7 0.86 and标准差>3
if (slope < -0.12 && smoothness > 0.86 && standarddeviation > 3) {
        return 1;
        }
        //GPS干扰：
        //IF 49 or 50处为峰值，并且本小区相邻10公里的小区中有存在GPS故障小区。
        else if ((peakindicatorvector.indexOf("49") >= 0 || peakindicatorvector.indexOf("50") >= 0) && flag == "1") {
        return 2;
        }
        //同频干扰：
        //IF  |斜率|<0.02 and平滑度>0.95 and 47 ~ 51 其中一处为峰值。
        else if (Math.abs(slope) < 0.02 && smoothness > 0.88 && (peakindicatorvector.indexOf("49") >= 0 || peakindicatorvector.indexOf("50") >= 0 || peakindicatorvector.indexOf("47") >= 0 || peakindicatorvector.indexOf("51") >= 0 || peakindicatorvector.indexOf("48") >= 0)) {
        return 4;
        }
        //阻塞干扰：
        //IF-0.018<斜率<0.01 and平滑度>0.9 and 0-9存在峰值指示量and 相关性系数>0.60
        else if ((xgxs==1111.0||xgxs > 0.6) && slope > -0.018 && slope < 0.01 && smoothness > 0.9 && fun1(peakindicatorvector)) {
        return 6;
        }
        //宽频干扰：
        //IF |斜率|<0.05 and 平滑度>0.9  and 标准差<2 and相关性系数<0.3，则判断为宽频干扰。
        else if (Math.abs(slope) < 0.05 && smoothness > 0.9 && standarddeviation < 2 && (xgxs==1111.0||xgxs < 0.3)) {
        return 5;
        }
        //互调干扰：
        //IF峰值数量大于等于4个 and 0.2 <平滑度<0.9
        else if (peakindicatorvector_2.split(",").length >= 4 && (smoothness > 0.2 && smoothness < 0.9)) {
        return 3;
        }
        //广电干扰：
        //IF  平滑度>0.80 and top40索引度>0.88.and top40均值-last60均值>15.
        else if (smoothness > 0.8 && top40indexaggregation > 0.88 && Top40AndLast60Broadcast > 15) {
        return 7;
        }
        //PHS干扰：
        //If 斜率>0.01 and平滑度>0.82 and TOP15与TAIL15索引重叠度>0.90 and 最后15个prb均值-前面85个PRB均值>15.
        else if (slope > 0.01 && smoothness > 0.82 && top15andtail15 > 0.9 && AvgTail15_85 > 15) {
        return 8;
        } else {
        return 0;//其他干扰
        }


        */