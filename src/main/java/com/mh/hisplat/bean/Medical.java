package com.mh.hisplat.bean;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Medical {
    private Integer mId;

    private String mName;

    private String rId;

    private Integer mSex;

    private Integer mAge;

    private Date mDate;

    private String mPhone;

    private String mAddress;

    private Integer dId;

    private String mAllergyHis;

    private Integer docId;

    private String diagnosticReportUrl;

    private Integer mType;

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

    private Date createTime;

    private Date updateTime;


    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public Integer getmSex() {
        return mSex;
    }

    public void setmSex(Integer mSex) {
        this.mSex = mSex;
    }

    public Integer getmAge() {
        return mAge;
    }

    public void setmAge(Integer mAge) {
        this.mAge = mAge;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone == null ? null : mPhone.trim();
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress == null ? null : mAddress.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getmAllergyHis() {
        return mAllergyHis;
    }

    public void setmAllergyHis(String mAllergyHis) {
        this.mAllergyHis = mAllergyHis == null ? null : mAllergyHis.trim();
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getDiagnosticReportUrl() {
        return diagnosticReportUrl;
    }

    public void setDiagnosticReportUrl(String diagnosticReportUrl) {
        this.diagnosticReportUrl = diagnosticReportUrl == null ? null : diagnosticReportUrl.trim();
    }

    public Integer getmType() {
        return mType;
    }

    public void setmType(Integer mType) {
        this.mType = mType;
    }
}