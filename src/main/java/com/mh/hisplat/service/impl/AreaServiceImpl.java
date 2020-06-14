package com.mh.hisplat.service.impl;

import com.mh.hisplat.bean.Area;
import com.mh.hisplat.dao.AreaMapper;
import com.mh.hisplat.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public List<Area> selectAllProvince() {
        return  areaMapper.selectAreasByPid(0);

    }

    @Override
    public List<Area> selectCityBy(Integer provinceCode) {
        return areaMapper.selectAreasByPid(provinceCode);
    }
}
