package com.mh.hisplat.dao;

import com.mh.hisplat.bean.Register;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RegisterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(String  id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKeyWithBLOBs(Register record);

    int updateByPrimaryKey(Register record);

    List<Register> selectByRegister(Register register);

    void updateByPrimaryKeys(Register register);

    List<Register> selectDocBynamelist(Register register);
}