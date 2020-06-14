package com.mh.hisplat.dao;

import com.mh.hisplat.bean.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKeyWithBLOBs(Staff record);

    int updateByPrimaryKey(Staff record);
}