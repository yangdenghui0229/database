package com.ydh;

import java.lang.ref.SoftReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangdenghui on 2017/11/6.
 */
public class RecordDAO {
    public DBConnection dbc= new DBConnection();
    PreparedStatement pst;
    ResultSet rs;

    public String getAddress(long userId) {
        String addr=null;
        String sql="select endAddr from record where userId=? and date_format(endTime,'%T')>='18:00:00' and date_format(endTime,'%T')<='24:00:00' group by endAddr order by count(endAddr) desc limit 1";
        try {
            pst=dbc.conn.prepareStatement(sql);
            pst.setObject(1,userId);
            rs=pst.executeQuery();
            if(rs.next()) {
                addr = rs.getString(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return addr;
    }

    public void updateCost() {
        String sql = "update record SET cost=CASE WHEN timestampdiff(minute,startTime,endTime)<=30 THEN 1.0 WHEN timestampdiff(minute,startTime,endTime)>30 AND timestampdiff(minute,startTime,endTime)<=60 THEN 2 WHEN timestampdiff(minute,startTime,endTime)>60 AND timestampdiff(MINUTE ,startTime,endTime)<=90 THEN 3 ELSE 4 END ";
        try {
            pst=dbc.conn.prepareStatement(sql);
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public double getCharge(long userId) {
        double cost=0;
        String sql = "SELECT sum(cost) FROM record WHERE userId=? GROUP BY userId";
        try {
            pst=dbc.conn.prepareStatement(sql);
            pst.setObject(1,userId);
            rs=pst.executeQuery();
            if(rs.next()) {
                cost=rs.getDouble(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cost;
    }

    public List<Long> getMaintainedBike() {
        List<Long> ids = new ArrayList<Long>();
        String sql = "select a.bikeId from (select bikeId,sum(timestampdiff(minute,startTime,endTime)) as time from record group by bikeId) as a where time>=12000";
        try {
            pst=dbc.conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()) {
                ids.add(rs.getLong(1));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

    public String getEndAddress(long bikeId) {
        String endAddress=null;
        String sql = "select endAddr from record WHERE bikeId=? AND endTime=(SELECT MAX(endTime) FROM record WHERE bikeId=?)";
        try {
            pst=dbc.conn.prepareStatement(sql);
            pst.setObject(1,bikeId);
            pst.setObject(2,bikeId);
            rs=pst.executeQuery();
            if(rs.next()) {
                endAddress=rs.getString(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return endAddress;
    }
}
