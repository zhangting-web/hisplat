package com.mh.hisplat.service;

import com.mh.hisplat.bean.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getRolePermissions(Integer rId);
}
