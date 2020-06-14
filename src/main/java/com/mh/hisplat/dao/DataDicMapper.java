package com.mh.hisplat.dao;

import com.mh.hisplat.bean.DataDic;

public interface DataDicMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(DataDic record);

    int insertSelective(DataDic record);

    DataDic selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(DataDic record);

    int updateByPrimaryKey(DataDic record);
}