package com.ydh.first;

import com.ydh.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by yangdenghui on 2017/11/5. 第一题
 */
public class CreateTable {

    static String sql1 = null;
    static String sql2 = null;
    static DBConnection dbc = new DBConnection();;
    static PreparedStatement pst;

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        sql1="CREATE TABLE `distribution` (\n" +
                "  `department` varchar(255) DEFAULT NULL,\n" +
                "  `stuId` varchar(255) NOT NULL,\n" +
                "  `name` varchar(255) DEFAULT NULL,\n" +
                "  `sex` varchar(255) DEFAULT NULL,\n" +
                "  `campus` varchar(255) DEFAULT NULL,\n" +
                "  `dormitory` varchar(255) DEFAULT NULL,\n" +
                "  `cost` int(32) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`stuId`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

        sql2="CREATE TABLE `dormitory` (\n" +
                "  `name` varchar(255)  NOT NULL,\n" +
                "  `phone` varchar(255) NOT NULL,\n" +
                "  PRIMARY KEY (`name`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

        try {
            pst=dbc.conn.prepareStatement(sql1);
            pst.executeUpdate();
            System.out.println("完成建表");
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            pst=dbc.conn.prepareStatement(sql2);
            pst.executeUpdate();
            System.out.println("完成建表");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        dbc.close();
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

}
