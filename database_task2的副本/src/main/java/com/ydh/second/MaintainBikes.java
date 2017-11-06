package com.ydh.second;

import com.ydh.MaintainBike;
import com.ydh.MaintainBikeDAO;
import com.ydh.RecordDAO;

import java.util.Iterator;
import java.util.List;

/**
 * Created by yangdenghui on 2017/11/6.第四题
 */
public class MaintainBikes {
    public static RecordDAO recordDAO =new RecordDAO();
    public static MaintainBikeDAO maintainBikeDAO =new MaintainBikeDAO();

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        List<Long> bikes = recordDAO.getMaintainedBike();
        Iterator<Long> iterator = bikes.iterator();
        while (iterator.hasNext()) {
            long id=iterator.next();
            String addr = recordDAO.getEndAddress(id);
            MaintainBike bike = new MaintainBike(id,addr);
            maintainBikeDAO.addBike(bike);
        }
        System.out.println("添加需要维修的车辆成功");
        recordDAO.dbc.close();
        maintainBikeDAO.dbc.close();
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

}
