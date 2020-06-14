package com.mh.hisplat.service.impl;

import com.mh.hisplat.bean.Permission;
import com.mh.hisplat.dao.PermissionMapper;
import com.mh.hisplat.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> getRolePermissions(Integer rId) {
        return permissionMapper.getRolePermissions(rId);
    }
}
