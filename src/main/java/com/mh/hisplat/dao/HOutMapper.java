package com.mh.hisplat.dao;

import com.mh.hisplat.bean.HOut;

public interface HOutMapper {
    int deleteByPrimaryKey(Integer hId);

    int insert(HOut record);

    int insertSelective(HOut record);

    HOut selectByPrimaryKey(Integer hId);

    int updateByPrimaryKeySelective(HOut record);

    int updateByPrimaryKey(HOut record);
}