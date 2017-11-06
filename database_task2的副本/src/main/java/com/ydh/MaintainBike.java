package com.ydh;

/**
 * Created by yangdenghui on 2017/11/6.
 */
public class MaintainBike {
    private long id;
    private String endAddress;

    public MaintainBike() {
    }

    public MaintainBike(long id, String endAddress) {
        this.id = id;
        this.endAddress = endAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }
}
