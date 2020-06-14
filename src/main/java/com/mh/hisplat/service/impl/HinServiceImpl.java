package com.mh.hisplat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mh.hisplat.bean.HIn;
import com.mh.hisplat.bean.MedicalWithBLOBs;
import com.mh.hisplat.dao.HInMapper;
import com.mh.hisplat.service.HinService;
import com.mh.hisplat.utils.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class HinServiceImpl implements HinService {
    @Autowired
    private HInMapper hinMapper;
    @Override
    public void add(HIn hin) {
        log.warn("添加住院信息");
        hin.setCreateTime(new Date());
        hin.setUpdateTime(new Date());
        hinMapper.insert(hin);
    }

    @Override
    public void updateById(HIn hin) {
            if(null==hin||null==hin.getinId()){
                return;
            }
        hinMapper.updateById(hin);

    }

    @Override
    public void del(List ids) {
        if(null==ids ||ids.isEmpty()){
            return;
        }
        hinMapper.del(ids);
    }

    @Override
    public PageInfo selectPageByname(HIn hin, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<HIn> list= hinMapper.selectList(hin);
        return new PageInfo(list);
    }
}
