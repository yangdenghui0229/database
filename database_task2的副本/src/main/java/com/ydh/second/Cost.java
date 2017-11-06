package com.ydh.second;

import com.ydh.RecordDAO;
import com.ydh.User;
import com.ydh.UserDAO;

import java.util.Iterator;
import java.util.List;

/**
 * Created by yangdenghui on 2017/11/6. 第三题
 */
public class Cost {
    private static UserDAO userDAO =new UserDAO();
    private static RecordDAO recordDAO = new RecordDAO();

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        recordDAO.updateCost();
        List<User> users = userDAO.getAllUser();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            double cost = recordDAO.getCharge(user.getId());
            userDAO.updateMoney(user.getId(),cost);
        }
        System.out.println("更行花费成功");
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
