package com.ydh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangdenghui on 2017/11/6.
 */
public class UserDAO {
    public DBConnection dbc= new DBConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void update(User user) {
        String sql="update user set name=?,phone=?,money=?,address=? WHERE id=?";
        try {
            pst=dbc.conn.prepareStatement(sql);
            pst.setObject(1,user.getName());
            pst.setObject(2,user.getPhone());
            pst.setObject(3,user.getMoney());
            pst.setObject(4,user.getAddress());
            pst.setObject(5,user.getId());
            pst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();
        String sql="select * from user";
        try
        {
            pst=dbc.conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                User user=new User(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getDouble(4),
                        rs.getString(5));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateMoney (long id,double cost) {
        String sql="update user SET money=(money-?) WHERE id=?";
        try{
            pst=dbc.conn.prepareStatement(sql);
            pst.setObject(1,cost);
            pst.setObject(2,id);
            pst.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
