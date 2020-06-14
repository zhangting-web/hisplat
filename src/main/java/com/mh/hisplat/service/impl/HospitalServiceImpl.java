package com.mh.hisplat.service.impl;

import com.mh.hisplat.bean.Hospital;
import com.mh.hisplat.dao.HospitalMapper;
import com.mh.hisplat.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HospitalServiceImpl  implements HospitalService {
    @Autowired
    private HospitalMapper hospitalMapper;
    @Override
    public List<Hospital> selectAll() {
        return hospitalMapper.selectAll();

    }


}
