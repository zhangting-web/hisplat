package com.mh.hisplat.service;


import com.github.pagehelper.PageInfo;
import com.mh.hisplat.bean.Register;
import com.mh.hisplat.utils.PageRequest;
import com.mh.hisplat.utils.PageResult;

import java.util.List;

public interface RegisterService {

    void insert(Register register);
    /**
     * 获取当前客户的预约列表
     * @param register
     * @param pageRequest
     * @return
     */

    PageInfo selectPageList(Register register, PageRequest pageRequest);

    /**
     * 获取当前医生的预约列表
     * @param register
     * @param pageRequest
     * @return
     */
    PageInfo selectDocPageList(Register register, PageRequest pageRequest);

    /**假删除
     * 根据ids删除预约列表
     * @param list
     */
    void delDocList(List list);

    /**
     * 根据主键查询
     * @param register
     * @return
     */
    Register getById(Register register);

    /**
     * 根据姓名查询
     * @param register
     * @param pageRequest
     * @return
     */
    PageInfo selectDocBynamelist(Register register, PageRequest pageRequest);

    /**
     * 更改预约表中支付状态为已支付
     * @param out_trade_no
*/
    void updaterStateById(String out_trade_no);
}
