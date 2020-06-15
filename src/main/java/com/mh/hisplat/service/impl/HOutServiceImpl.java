package com.mh.hisplat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mh.hisplat.bean.HIn;
import com.mh.hisplat.bean.HOut;
import com.mh.hisplat.dao.HOutMapper;
import com.mh.hisplat.service.HOutService;
import com.mh.hisplat.utils.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class HOutServiceImpl  implements HOutService {
    @Autowired
    private HOutMapper hOutMapper;
    @Override
    public void add(HOut hOut) {
        log.warn("添加出院信息");
        hOut.setCreateTime(new Date());
        hOut.setUpdateTime(new Date());
        hOutMapper.insert(hOut);
    }

    @Override
    public void updateById(HOut hOut) {

        if (null == hOut || null == hOut.gethId()) {
            return;
        }
        hOutMapper.updateById(hOut);


    }

    @Override
    public void del(List ids) {
        if(null==ids ||ids.isEmpty()){
            return;
        }
        hOutMapper.del(ids);
    }

    @Override
    public PageInfo selectPageByname(HOut hOut, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<HOut> list= hOutMapper.selectList(hOut);
        return new PageInfo(list);
    }
}
