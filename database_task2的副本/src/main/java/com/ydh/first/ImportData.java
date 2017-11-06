package com.ydh.first;

import com.ydh.DBConnection;
import jxl.*;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by yangdenghui on 2017/11/5. 第二题
 */
public class ImportData {
    static DBConnection dbc= new DBConnection();
    static PreparedStatement pst;
    static String sql;


    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        importTXT("src/main/java/com/ydh/files/电话.txt");
        importExcel("src/main/java/com/ydh/files/分配方案.xls");
        dbc.close();
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    public static void importTXT (String filepath) {
        File file =new File(filepath);
        FileInputStream fis=null;
        sql="insert into dormitory(name,phone) values(?,?)";
        try {
            fis = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(input);
            int i=0;
            String line = null;
            String[] info = null;
            try {
                pst=dbc.conn.prepareStatement(sql);
                while ((line=br.readLine())!=null) {
                    if(i>=1){
                        info =line.split(";");
                        pst.setString(1,info[0]);
                        pst.setString(2,info[1]);
                        pst.executeUpdate();
                    }
                    i++;
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

    public static void importExcel(String filepath) {
        File excelFile =new File(filepath);
        sql="insert into distribution values(?,?,?,?,?,?,?)";
        try {
            pst=dbc.conn.prepareStatement(sql);
            Workbook workbook = Workbook.getWorkbook(excelFile);
            Sheet rs =workbook.getSheet(0);
            int rows=rs.getRows();
            System.out.println(rows);
            for(int i=1;i<rows;i++) {
                pst.setString(1,rs.getCell(0,i).getContents());
                pst.setString(2,rs.getCell(1,i).getContents());
                pst.setString(3,rs.getCell(2,i).getContents());
                pst.setString(4,rs.getCell(3,i).getContents());
                pst.setString(5,rs.getCell(4,i).getContents());
                pst.setString(6,rs.getCell(5,i).getContents());
                pst.setString(7,rs.getCell(6,i).getContents());
                pst.executeUpdate();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (JXLException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
