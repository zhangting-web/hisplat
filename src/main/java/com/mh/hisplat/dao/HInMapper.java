package com.mh.hisplat.dao;

import com.mh.hisplat.bean.HIn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HInMapper {
    int deleteByPrimaryKey(Integer inId);

    int insert(HIn record);

    int insertSelective(HIn record);

    HIn selectByPrimaryKey(Integer inId);

    int updateByPrimaryKeySelective(HIn record);

    int updateByPrimaryKey(HIn record);

    void updateById(HIn hin);

    /**
     * 删除住院信息
     * @param ids
     */
    void del(@Param("ids")List ids);

    /**
     * 根据条件查询用户列表
     * @param hin
     * @return
     */
    List<HIn> selectList(HIn hin);
}