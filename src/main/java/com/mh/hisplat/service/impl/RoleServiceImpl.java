package com.mh.hisplat.service.impl;

import com.mh.hisplat.bean.Role;
import com.mh.hisplat.dao.RoleMapper;
import com.mh.hisplat.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Role gertUserRole(Integer rId) {
        return roleMapper.selectByPrimaryKey(rId);
    }
}
