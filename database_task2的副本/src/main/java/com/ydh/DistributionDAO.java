package com.ydh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangdenghui on 2017/11/5.
 */
public class DistributionDAO {
    public DBConnection dbc= new DBConnection();
    PreparedStatement pst;
    ResultSet rs;

    public List<String> getDepartment(String name){
        String sql = "select distinct(a.department) from distribution a,distribution b where a.dormitory=b.dormitory and b.name=?";
        List<String> strings=new ArrayList<String>();
        try{
            pst=dbc.conn.prepareStatement(sql);
            pst.setObject(1,name);
            rs=pst.executeQuery();
            while (rs.next()){
                strings.add(rs.getString(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        dbc.close();
        return strings;
    }

    public void update(String sql){
        try {
            pst = dbc.conn.prepareStatement(sql);
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateCost() {
        try {
            String sql="update distribution set cost=1200 where dormitory='陶园1舍'";
            pst = dbc.conn.prepareStatement(sql);
            pst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        dbc.close();
    }

    public void exchange() {
        try {
            String sql="update distribution s,(select distinct(dormitory),sex from distribution b where b.department='软件学院') as a set s.dormitory=a.dormitory where s.department='软件学院' and s.sex!=a.sex;";;
            pst = dbc.conn.prepareStatement(sql);
            pst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        dbc.close();
    }
}
