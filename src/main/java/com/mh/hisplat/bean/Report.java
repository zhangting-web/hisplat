package com.mh.hisplat.bean;

import java.util.Date;

public class Report {
    private Integer rId;

    private String rName;

    private Integer rSex;

    private Integer rAge;

    private Integer rDiagnosisType;

    private String rGeneralCheck;

    private String rPathologicalDiagnosis;

    private Integer rImmune;

    private String rResult;

    private String rPhysician;

    private String rCheckPhysician;

    private Date rTime;

    private String rDescribe;

    private Integer rDivision;

    private String rClinicalDiagnosis;

    private Integer dId;

    private Date rCheckTime;

    private String rInspectionItem;

    private String rMark;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
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

    public Integer getrAge() {
        return rAge;
    }

    public void setrAge(Integer rAge) {
        this.rAge = rAge;
    }

    public Integer getrDiagnosisType() {
        return rDiagnosisType;
    }

    public void setrDiagnosisType(Integer rDiagnosisType) {
        this.rDiagnosisType = rDiagnosisType;
    }

    public String getrGeneralCheck() {
        return rGeneralCheck;
    }

    public void setrGeneralCheck(String rGeneralCheck) {
        this.rGeneralCheck = rGeneralCheck == null ? null : rGeneralCheck.trim();
    }

    public String getrPathologicalDiagnosis() {
        return rPathologicalDiagnosis;
    }

    public void setrPathologicalDiagnosis(String rPathologicalDiagnosis) {
        this.rPathologicalDiagnosis = rPathologicalDiagnosis == null ? null : rPathologicalDiagnosis.trim();
    }

    public Integer getrImmune() {
        return rImmune;
    }

    public void setrImmune(Integer rImmune) {
        this.rImmune = rImmune;
    }

    public String getrResult() {
        return rResult;
    }

    public void setrResult(String rResult) {
        this.rResult = rResult == null ? null : rResult.trim();
    }

    public String getrPhysician() {
        return rPhysician;
    }

    public void setrPhysician(String rPhysician) {
        this.rPhysician = rPhysician == null ? null : rPhysician.trim();
    }

    public String getrCheckPhysician() {
        return rCheckPhysician;
    }

    public void setrCheckPhysician(String rCheckPhysician) {
        this.rCheckPhysician = rCheckPhysician == null ? null : rCheckPhysician.trim();
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public String getrDescribe() {
        return rDescribe;
    }

    public void setrDescribe(String rDescribe) {
        this.rDescribe = rDescribe == null ? null : rDescribe.trim();
    }

    public Integer getrDivision() {
        return rDivision;
    }

    public void setrDivision(Integer rDivision) {
        this.rDivision = rDivision;
    }

    public String getrClinicalDiagnosis() {
        return rClinicalDiagnosis;
    }

    public void setrClinicalDiagnosis(String rClinicalDiagnosis) {
        this.rClinicalDiagnosis = rClinicalDiagnosis == null ? null : rClinicalDiagnosis.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Date getrCheckTime() {
        return rCheckTime;
    }

    public void setrCheckTime(Date rCheckTime) {
        this.rCheckTime = rCheckTime;
    }

    public String getrInspectionItem() {
        return rInspectionItem;
    }

    public void setrInspectionItem(String rInspectionItem) {
        this.rInspectionItem = rInspectionItem == null ? null : rInspectionItem.trim();
    }

    public String getrMark() {
        return rMark;
    }

    public void setrMark(String rMark) {
        this.rMark = rMark == null ? null : rMark.trim();
    }
}