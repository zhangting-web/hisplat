package com.mh.hisplat.bean;

import java.util.Date;

public class HOut {
    private Integer hId;

    private String hName;

    private Integer hSex;

    private Integer hAge;

    private Integer bedNo;

    private Integer docId;

    private Integer nurseId;

    private Date inDate;

    private Integer dId;

    private Integer hCheck;

    private Date hOutTime;

    private String hDiadnosticSymptom;

    private Integer inPhone;

    public Integer getInPhone() {
        return inPhone;
    }

    public void setInPhone(Integer inPhone) {
        this.inPhone = inPhone;
    }

    private String hOperation;

    private String hCondition;

    private String hMark;

    private String hCheckPhysician;

    private Date createTime;

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

    private Date updateTime;

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName == null ? null : hName.trim();
    }

    public Integer gethSex() {
        return hSex;
    }

    public void sethSex(Integer hSex) {
        this.hSex = hSex;
    }

    public Integer gethAge() {
        return hAge;
    }

    public void sethAge(Integer hAge) {
        this.hAge = hAge;
    }

    public Integer getBedNo() {
        return bedNo;
    }

    public void setBedNo(Integer bedNo) {
        this.bedNo = bedNo;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer gethCheck() {
        return hCheck;
    }

    public void sethCheck(Integer hCheck) {
        this.hCheck = hCheck;
    }

    public Date gethOutTime() {
        return hOutTime;
    }

    public void sethOutTime(Date hOutTime) {
        this.hOutTime = hOutTime;
    }

    public String gethDiadnosticSymptom() {
        return hDiadnosticSymptom;
    }

    public void sethDiadnosticSymptom(String hDiadnosticSymptom) {
        this.hDiadnosticSymptom = hDiadnosticSymptom == null ? null : hDiadnosticSymptom.trim();
    }

    public String gethOperation() {
        return hOperation;
    }

    public void sethOperation(String hOperation) {
        this.hOperation = hOperation == null ? null : hOperation.trim();
    }

    public String gethCondition() {
        return hCondition;
    }

    public void sethCondition(String hCondition) {
        this.hCondition = hCondition == null ? null : hCondition.trim();
    }

    public String gethMark() {
        return hMark;
    }

    public void sethMark(String hMark) {
        this.hMark = hMark == null ? null : hMark.trim();
    }

    public String gethCheckPhysician() {
        return hCheckPhysician;
    }

    public void sethCheckPhysician(String hCheckPhysician) {
        this.hCheckPhysician = hCheckPhysician == null ? null : hCheckPhysician.trim();
    }


}