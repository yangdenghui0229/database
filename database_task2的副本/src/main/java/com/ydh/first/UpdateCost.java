package com.ydh.first;

import com.ydh.DistributionDAO;

/**
 * Created by yangdenghui on 2017/11/5.第四题
 */
public class UpdateCost {
    private static DistributionDAO distributionDao = new DistributionDAO();

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        distributionDao.updateCost();
        System.out.println("修改费用成功/n");
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
