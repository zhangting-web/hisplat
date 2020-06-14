package com.mh.hisplat.bean;

import java.util.Date;

public class Prescription {
    private Integer pId;

    private String pName;

    private Integer pSex;

    private Integer pAge;

    private Integer bedNo;

    private Integer nurseId;

    private Date createTime;

    private String pPrescription;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer getpSex() {
        return pSex;
    }

    public void setpSex(Integer pSex) {
        this.pSex = pSex;
    }

    public Integer getpAge() {
        return pAge;
    }

    public void setpAge(Integer pAge) {
        this.pAge = pAge;
    }

    public Integer getBedNo() {
        return bedNo;
    }

    public void setBedNo(Integer bedNo) {
        this.bedNo = bedNo;
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getpPrescription() {
        return pPrescription;
    }

    public void setpPrescription(String pPrescription) {
        this.pPrescription = pPrescription == null ? null : pPrescription.trim();
    }
}