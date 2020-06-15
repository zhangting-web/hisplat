package com.mh.hisplat.dao;
import com.mh.hisplat.bean.HOut;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface HOutMapper {
    int deleteByPrimaryKey(Integer hId);

    int insert(HOut record);

    int insertSelective(HOut record);

    HOut selectByPrimaryKey(Integer hId);

    int updateByPrimaryKeySelective(HOut record);

    int updateByPrimaryKey(HOut record);

    /**
     * 修改出院信息
     * @param hOut
     */
    void updateById(HOut hOut);
    
    /**
     * 删除出院信息
     * @param ids
     */
    void del(@Param("ids")List ids);

    List<HOut> selectList(HOut hOut);
}