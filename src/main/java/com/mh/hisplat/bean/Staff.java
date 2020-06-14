package com.mh.hisplat.bean;

import java.util.Date;

public class Staff {
    private Integer sId;

    private String sName;

    private Date sBirthday;

    private Integer sSex;

    private Integer idRole;

    private Integer hId;

    private String sAddress;

    private Integer dId;

    private Integer sPhone;

    private String sLevel;

    private String hAddress;

    private String hMployeeProfile;

    private String hRelatedDocument;

    private Date createTime;

    private Date updateTime;

    private String hWorkExperience;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Date getsBirthday() {
        return sBirthday;
    }

    public void setsBirthday(Date sBirthday) {
        this.sBirthday = sBirthday;
    }

    public Integer getsSex() {
        return sSex;
    }

    public void setsSex(Integer sSex) {
        this.sSex = sSex;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress == null ? null : sAddress.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getsPhone() {
        return sPhone;
    }

    public void setsPhone(Integer sPhone) {
        this.sPhone = sPhone;
    }

    public String getsLevel() {
        return sLevel;
    }

    public void setsLevel(String sLevel) {
        this.sLevel = sLevel == null ? null : sLevel.trim();
    }

    public String gethAddress() {
        return hAddress;
    }

    public void sethAddress(String hAddress) {
        this.hAddress = hAddress == null ? null : hAddress.trim();
    }

    public String gethMployeeProfile() {
        return hMployeeProfile;
    }

    public void sethMployeeProfile(String hMployeeProfile) {
        this.hMployeeProfile = hMployeeProfile == null ? null : hMployeeProfile.trim();
    }

    public String gethRelatedDocument() {
        return hRelatedDocument;
    }

    public void sethRelatedDocument(String hRelatedDocument) {
        this.hRelatedDocument = hRelatedDocument == null ? null : hRelatedDocument.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String gethWorkExperience() {
        return hWorkExperience;
    }

    public void sethWorkExperience(String hWorkExperience) {
        this.hWorkExperience = hWorkExperience == null ? null : hWorkExperience.trim();
    }
}