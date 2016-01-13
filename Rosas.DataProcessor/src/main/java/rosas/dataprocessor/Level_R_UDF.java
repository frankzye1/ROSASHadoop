package rosas.dataprocessor;

/**
 * Created by Administrator on 2016/1/13.
 */
public class Level_R_UDF {
    public int evaluate(String valuestr) {
        try {
            String[] Strlist = Common.StrToList(valuestr);
            int level=0;
            for (int i=0;i<Strlist.length;i++)
            {
                int value=Integer.parseInt(Strlist[i].replace(")", "").split(",")[1]);
                if (value==4||value==5)
                {
                    if (level!=2) {
                        level = 1;
                    }
                }
                if (value>=6)
                {
                    level=2;
                }

            }
            return level;
        } catch (Exception e) {
            return 0;
        }
    }
}
