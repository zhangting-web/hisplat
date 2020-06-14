package com.mh.hisplat.bean;

import org.springframework.stereotype.Component;

@Component
public class MedicalWithBLOBs extends Medical {
    private String mPatientCondition;

    private String medicationInfo;

    private String mark;

    public String getmPatientCondition() {
        return mPatientCondition;
    }

    public void setmPatientCondition(String mPatientCondition) {
        this.mPatientCondition = mPatientCondition == null ? null : mPatientCondition.trim();
    }

    public String getMedicationInfo() {
        return medicationInfo;
    }

    public void setMedicationInfo(String medicationInfo) {
        this.medicationInfo = medicationInfo == null ? null : medicationInfo.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}