package com.mh.hisplat.service;
import com.github.pagehelper.PageInfo;
import com.mh.hisplat.bean.MedicalWithBLOBs;
import com.mh.hisplat.utils.PageRequest;

import java.util.List;

public interface MedicalService {
     void add(MedicalWithBLOBs medical);

    PageInfo selectPageList(MedicalWithBLOBs medical, PageRequest pageRequest);

    /**
     * 支持批量真删除
     * @param ids
     */
    void del(List ids);

    /**
     * 根据id修改
     * @param medicalWithBLOBs
     */
    void updateById(MedicalWithBLOBs medicalWithBLOBs);

    PageInfo selectPageByList(MedicalWithBLOBs medical, PageRequest pageRequest);
}
