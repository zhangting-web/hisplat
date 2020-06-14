package com.mh.hisplat.service;

import com.github.pagehelper.PageInfo;
import com.mh.hisplat.bean.HIn;
import com.mh.hisplat.utils.PageRequest;

import java.util.List;


public interface HinService {
    /**
     * 添加住院信息
     * @param hin
     */
    void add(HIn hin);

    /**
     * 修改住院信息
     * @param hin
     */
    void updateById(HIn hin);

    /**
     * 删除住院信息
     * @param ids
     */
    void del(List ids);

    /**
     * 根据条件查询住院信息列表
     * @param hin
     * @param pageRequest
     * @return
     */
    PageInfo selectPageByname(HIn hin, PageRequest pageRequest);
}
