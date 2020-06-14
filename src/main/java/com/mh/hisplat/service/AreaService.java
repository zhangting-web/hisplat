package com.mh.hisplat.service;

import com.mh.hisplat.bean.Area;

import java.util.List;

public interface AreaService {
    List<Area> selectAllProvince();

    List<Area> selectCityBy(Integer provinceCode);
}
