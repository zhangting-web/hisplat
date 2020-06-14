package com.mh.hisplat.dao;

import com.mh.hisplat.bean.Report;

public interface ReportMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKeyWithBLOBs(Report record);

    int updateByPrimaryKey(Report record);
}