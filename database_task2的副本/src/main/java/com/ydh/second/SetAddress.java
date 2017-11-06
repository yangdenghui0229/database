package com.ydh.second;

import com.ydh.RecordDAO;
import com.ydh.User;
import com.ydh.UserDAO;

import java.util.List;
import java.util.Iterator;
/**
 * Created by yangdenghui on 2017/11/6.第二题
 */
public class SetAddress {
    private static UserDAO userDAO=new UserDAO();
    private static RecordDAO recordDAO=new RecordDAO();

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        List<User> users = userDAO.getAllUser();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            String address = recordDAO.getAddress(user.getId());
            System.out.println(user.getName()+"的住址是"+address);
            user.setAddress(address);
            userDAO.update(user);
        }
        System.out.println("更新地址成功");
        userDAO.dbc.close();
        recordDAO.dbc.close();
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
