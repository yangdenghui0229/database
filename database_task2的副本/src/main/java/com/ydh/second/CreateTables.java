package com.ydh.second;

import com.ydh.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by yangdenghui on 2017/11/6.第一题建表
 */
public class CreateTables {
    static DBConnection dbc = new DBConnection();;
    static PreparedStatement pst;

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        String sql1="CREATE TABLE `user` (\n" +
                "  `id` int(32) NOT NULL,\n" +
                "  `name` varchar(255) DEFAULT NULL,\n" +
                "  `phone` varchar(255) DEFAULT NULL,\n" +
                "  `money` double(16,2) DEFAULT NULL,\n" +
                "  `address` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

        String sql2="CREATE TABLE `record` (\n" +
                "  `userId` int(32) DEFAULT NULL,\n" +
                "  `bikeId` int(32) DEFAULT NULL,\n" +
                "  `startAddr` varchar(255) DEFAULT NULL,\n" +
                "  `startTime` datetime DEFAULT NULL,\n" +
                "  `endAddr` varchar(255) DEFAULT NULL,\n" +
                "  `endTime` datetime DEFAULT NULL,\n" +
                "  `cost` double(16,2) DEFAULT NULL,\n" +
                "  KEY `hash_index` (`endAddr`) USING HASH,\n" +
                "  KEY `search_index` (`userId`,`endTime`,`endAddr`) USING HASH\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

        String sql3="CREATE TABLE `bike` (\n" +
                "  `id` int(32) NOT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

        String sql4="CREATE TABLE `bike_maintain` (\n" +
                "  `id` int(32) NOT NULL,\n" +
                "  `endAddress` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

        try {
            pst=dbc.conn.prepareStatement(sql1);
            pst.executeUpdate();
            System.out.println("完成User建表");
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            pst=dbc.conn.prepareStatement(sql2);
            pst.executeUpdate();
            System.out.println("完成record建表");
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            pst=dbc.conn.prepareStatement(sql3);
            pst.executeUpdate();
            System.out.println("完成bike建表");
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            pst=dbc.conn.prepareStatement(sql4);
            pst.executeUpdate();
            System.out.println("完成MaintainBike建表");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        dbc.close();
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

}

