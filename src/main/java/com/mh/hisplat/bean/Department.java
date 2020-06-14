package com.mh.hisplat.bean;

public class Department {
    private Integer dId;

    private String dName;

    private Integer dNum;

    private String dTel;

    private Integer dLevelId;

    private Integer hId;

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

    public Integer getdNum() {
        return dNum;
    }

    public void setdNum(Integer dNum) {
        this.dNum = dNum;
    }

    public String getdTel() {
        return dTel;
    }

    public void setdTel(String dTel) {
        this.dTel = dTel == null ? null : dTel.trim();
    }

    public Integer getdLevelId() {
        return dLevelId;
    }

    public void setdLevelId(Integer dLevelId) {
        this.dLevelId = dLevelId;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }
}