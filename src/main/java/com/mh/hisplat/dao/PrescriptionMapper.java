package com.mh.hisplat.dao;

import com.mh.hisplat.bean.Prescription;

public interface PrescriptionMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    Prescription selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKeyWithBLOBs(Prescription record);

    int updateByPrimaryKey(Prescription record);
}