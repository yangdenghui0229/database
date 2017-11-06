package com.ydh.second;

import com.ydh.DBConnection;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by yangdenghui on 2017/11/6. 第一题导入数据
 */
public class ImportTxt {
    static DBConnection dbc= new DBConnection();
    static PreparedStatement pst;

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        importUser("src/main/java/com/ydh/files/user.txt");
        importRecord("src/main/java/com/ydh/files/record.txt");
        importBike("src/main/java/com/ydh/files/MaintainBikes.txt");
        dbc.close();
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    public static void importUser (String filepath) {
        File file =new File(filepath);
        FileInputStream fis=null;
        String sql="insert into user(id,name,phone,money) values(?,?,?,?)";
        try {
            fis = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(input);
            String line = null;
            String[] info = null;
            try {
                pst=dbc.conn.prepareStatement(sql);
                while ((line=br.readLine())!=null) {
                    info =line.split(";");
                    pst.setString(1,info[0]);
                    pst.setString(2,info[1]);
                    pst.setString(3,info[2]);
                    pst.setString(4,info[3]);
                    pst.executeUpdate();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void importRecord (String filepath) {
        File file =new File(filepath);
        FileInputStream fis=null;
        String sql="insert into record(userId,bikeId,startAddr,startTime,endAddr,endTime) values(?,?,?,?,?,?)";
        try {
            fis = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(input);
            String line = null;
            String[] info = null;
            try {
                pst=dbc.conn.prepareStatement(sql);
                while ((line=br.readLine())!=null) {
                    info =line.split(";");
                    pst.setString(1,info[0]);
                    pst.setString(2,info[1]);
                    pst.setString(3,info[2]);
                    pst.setString(4,info[3]);
                    pst.setString(5,info[4]);
                    pst.setString(6,info[5]);
                    pst.executeUpdate();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void importBike (String filepath) {
        File file =new File(filepath);
        FileInputStream fis=null;
        String sql="insert into bike(id) values(?)";
        try {
            fis = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(input);
            String line = null;
            try {
                pst=dbc.conn.prepareStatement(sql);
                while ((line=br.readLine())!=null) {
                    pst.setString(1,line);
                    pst.executeUpdate();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
