package com.mh.hisplat.bean;

public class Hospital {
    private Integer hId;

    private String hName;

    private Integer hLevelId;

    private Integer hProvinceCode;

    private Integer hCityCode;

    private String hAddress;

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

    public Integer gethLevelId() {
        return hLevelId;
    }

    public void sethLevelId(Integer hLevelId) {
        this.hLevelId = hLevelId;
    }

    public Integer gethProvinceCode() {
        return hProvinceCode;
    }

    public void sethProvinceCode(Integer hProvinceCode) {
        this.hProvinceCode = hProvinceCode;
    }

    public Integer gethCityCode() {
        return hCityCode;
    }

    public void sethCityCode(Integer hCityCode) {
        this.hCityCode = hCityCode;
    }

    public String gethAddress() {
        return hAddress;
    }

    public void sethAddress(String hAddress) {
        this.hAddress = hAddress == null ? null : hAddress.trim();
    }
}