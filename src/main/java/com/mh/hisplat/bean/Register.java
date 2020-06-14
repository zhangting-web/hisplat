package com.mh.hisplat.bean;

import java.util.Date;
import java.util.List;

public class Register {
    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    private Integer dId;

    private String rName;

    private Integer rSex;

    private Integer rType;

    private Date rAppointmentTime;

    private Integer docId;

    private Integer rState;

    private Date createTime;

    private Date updateTime;

    private Date payTime;

    private Integer hId;

    private Integer uId;

    private Integer rAge;

    private Integer delFlag;

    private List ids;//主键列表id

    private String rPatientCondition;
    /**
     * 冗余字段
     * @return
     */
    public String hName;
    public String rSexName;
    public String docName;//医生名称
    private String  phone;
    private String  address;
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    private String departName;
    public List getIds() {
        return ids;
    }

    public void setIds(List ids) {
        this.ids = ids;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getrSexName() {
        return rSexName;
    }

    public void setrSexName(String rSexName) {
        this.rSexName = rSexName;
    }

    public String getrTypeName() {
        return rTypeName;
    }

    public void setrTypeName(String rTypeName) {
        this.rTypeName = rTypeName;
    }

    public String rTypeName;


    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }


    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public Integer getrSex() {
        return rSex;
    }

    public void setrSex(Integer rSex) {
        this.rSex = rSex;
    }

    public Integer getrType() {
        return rType;
    }

    public void setrType(Integer rType) {
        this.rType = rType;
    }

    public Date getrAppointmentTime() {
        return rAppointmentTime;
    }

    public void setrAppointmentTime(Date rAppointmentTime) {
        this.rAppointmentTime = rAppointmentTime;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getrState() {
        return rState;
    }

    public void setrState(Integer rState) {
        this.rState = rState;
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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getrAge() {
        return rAge;
    }

    public void setrAge(Integer rAge) {
        this.rAge = rAge;
    }

    public String getrPatientCondition() {
        return rPatientCondition;
    }

    public void setrPatientCondition(String rPatientCondition) {
        this.rPatientCondition = rPatientCondition == null ? null : rPatientCondition.trim();
    }
}