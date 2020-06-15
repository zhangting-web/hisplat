package com.mh.hisplat.service;

import com.github.pagehelper.PageInfo;
import com.mh.hisplat.bean.HOut;
import com.mh.hisplat.utils.PageRequest;

import java.util.List;

public interface HOutService {

    void add(HOut hOut);

    void updateById(HOut hOut);

    void del(List ids);

    PageInfo selectPageByname(HOut hOut, PageRequest pageRequest);
}
