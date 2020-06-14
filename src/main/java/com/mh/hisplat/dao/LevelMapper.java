package com.mh.hisplat.dao;

import com.mh.hisplat.bean.Level;

public interface LevelMapper {
    int deleteByPrimaryKey(Integer lId);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(Integer lId);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);
}