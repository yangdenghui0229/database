package com.ydh.first;

import com.ydh.DistributionDAO;

import java.util.List;

/**
 * Created by yangdenghui on 2017/11/5. 第三题
 */
public class SelectDepartment {
    private static DistributionDAO distributionDao = new DistributionDAO();

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        List<String> departments = distributionDao.getDepartment("王小星");
        System.out.print("\"王小星\"同学所在宿舍楼的所有院系为:");
        for (String str : departments) {
            System.out.print(str + ",");
        }
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

}
