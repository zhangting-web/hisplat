package com.mh.hisplat.dao;

import com.mh.hisplat.bean.Medical;
import com.mh.hisplat.bean.MedicalWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicalMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(MedicalWithBLOBs record);

    int insertSelective(MedicalWithBLOBs record);

    MedicalWithBLOBs selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(MedicalWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MedicalWithBLOBs record);

    int updateByPrimaryKey(Medical record);

    List<MedicalWithBLOBs> selectList(MedicalWithBLOBs medical);

    /**
     * 根据主键批量删除
     * @param ids
     */

    void del(@Param("ids") List ids);

    List<MedicalWithBLOBs> selectByList(MedicalWithBLOBs medical);
}