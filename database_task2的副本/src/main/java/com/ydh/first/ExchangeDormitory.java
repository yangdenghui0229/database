package com.ydh.first;

import com.ydh.DistributionDAO;

/**
 * Created by yangdenghui on 2017/11/5.
 */
public class ExchangeDormitory {
    private static DistributionDAO distributionDAO = new DistributionDAO();

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        distributionDAO.exchange();
        System.out.println("软件学院男生女生交换宿舍成功");
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
