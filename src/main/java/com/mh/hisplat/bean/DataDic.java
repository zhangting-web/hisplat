package com.mh.hisplat.bean;

public class DataDic {
    private Integer dId;

    private String dName;

    private String dValue;

    private String dColum;

    private String dis;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public String getdValue() {
        return dValue;
    }

    public void setdValue(String dValue) {
        this.dValue = dValue == null ? null : dValue.trim();
    }

    public String getdColum() {
        return dColum;
    }

    public void setdColum(String dColum) {
        this.dColum = dColum == null ? null : dColum.trim();
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis == null ? null : dis.trim();
    }
}