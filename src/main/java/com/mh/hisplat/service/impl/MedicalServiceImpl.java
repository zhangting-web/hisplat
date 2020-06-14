package com.mh.hisplat.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mh.hisplat.bean.MedicalWithBLOBs;
import com.mh.hisplat.dao.MedicalMapper;
import com.mh.hisplat.service.MedicalService;
import com.mh.hisplat.utils.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class MedicalServiceImpl implements MedicalService {
    @Autowired
    private MedicalMapper medicalMapper;
    @Override
    public void add(MedicalWithBLOBs medical) {
        log.warn("添加病例");
        medical.setCreateTime(new Date());
        medical.setUpdateTime(new Date());
        medicalMapper.insert(medical);

    }

    @Override
    public PageInfo selectPageList(MedicalWithBLOBs medical, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<MedicalWithBLOBs> list= medicalMapper.selectList(medical);
        return new PageInfo(list);
    }

    @Override
    public void del(List ids) {
        if(null==ids ||ids.isEmpty()){
            return;
        }
        medicalMapper.del(ids);
    }

    @Override
    public void updateById(MedicalWithBLOBs medicalWithBLOBs) {
        if(null==medicalWithBLOBs||null==medicalWithBLOBs.getmId()){
            return;
        }
        medicalMapper.updateByPrimaryKeySelective(medicalWithBLOBs);
    }

    @Override
    public PageInfo selectPageByList(MedicalWithBLOBs medical, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<MedicalWithBLOBs> list= medicalMapper.selectByList(medical);
        return new PageInfo(list);
    }
}
