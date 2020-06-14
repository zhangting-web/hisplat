package com.mh.hisplat.service;

import com.mh.hisplat.bean.Department;
import com.mh.hisplat.bean.Hospital;

import java.util.List;

public interface DepartmentService {
    List<Department> selectListBy(Department department);
}
