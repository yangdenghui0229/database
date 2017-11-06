package com.ydh;

import java.lang.ref.SoftReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yangdenghui on 2017/11/6.
 */
public class MaintainBikeDAO {
    public DBConnection dbc= new DBConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void addBike(MaintainBike bike) {
        String sql="insert into bike_maintain VALUES(?,?) ";
        try {
            pst=dbc.conn.prepareStatement(sql);
            pst.setObject(1,bike.getId());
            pst.setObject(2,bike.getEndAddress());
            pst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}