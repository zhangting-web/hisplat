package com.mh.hisplat.bean;

public class Interrogation {
    private Integer inId;

    private String inName;

    private Integer inSex;

    private String inProblem;

    private String inCardinalSymptom;

    private String inMedicine;

    private String inNeed;

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName == null ? null : inName.trim();
    }

    public Integer getInSex() {
        return inSex;
    }

    public void setInSex(Integer inSex) {
        this.inSex = inSex;
    }

    public String getInProblem() {
        return inProblem;
    }

    public void setInProblem(String inProblem) {
        this.inProblem = inProblem == null ? null : inProblem.trim();
    }

    public String getInCardinalSymptom() {
        return inCardinalSymptom;
    }

    public void setInCardinalSymptom(String inCardinalSymptom) {
        this.inCardinalSymptom = inCardinalSymptom == null ? null : inCardinalSymptom.trim();
    }

    public String getInMedicine() {
        return inMedicine;
    }

    public void setInMedicine(String inMedicine) {
        this.inMedicine = inMedicine == null ? null : inMedicine.trim();
    }

    public String getInNeed() {
        return inNeed;
    }

    public void setInNeed(String inNeed) {
        this.inNeed = inNeed == null ? null : inNeed.trim();
    }
}