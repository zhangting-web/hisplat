package com.mh.hisplat.dao;

import com.mh.hisplat.bean.Hospital;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HospitalMapper {
    int deleteByPrimaryKey(Integer hId);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    Hospital selectByPrimaryKey(Integer hId);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);

    List<Hospital> selectAll();
}