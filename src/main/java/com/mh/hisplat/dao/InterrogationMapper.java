package com.mh.hisplat.dao;

import com.mh.hisplat.bean.Interrogation;

public interface InterrogationMapper {
    int deleteByPrimaryKey(Integer inId);

    int insert(Interrogation record);

    int insertSelective(Interrogation record);

    Interrogation selectByPrimaryKey(Integer inId);

    int updateByPrimaryKeySelective(Interrogation record);

    int updateByPrimaryKey(Interrogation record);
}