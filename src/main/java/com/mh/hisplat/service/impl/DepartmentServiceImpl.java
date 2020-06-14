package com.mh.hisplat.service.impl;

import com.mh.hisplat.bean.Department;
import com.mh.hisplat.bean.Hospital;
import com.mh.hisplat.dao.DepartmentMapper;
import com.mh.hisplat.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> selectListBy(Department department) {
        return departmentMapper.selectListBy(department);
    }
}
