package com.mh.hisplat.dao;

import com.mh.hisplat.bean.Area;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
/*查询所有省列表*/

    //List<Area> selectAllProvince();
//根据pid获取地区列表
    List<Area> selectAreasByPid(@Param("pid") Integer pid);
}