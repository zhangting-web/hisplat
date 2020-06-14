package com.mh.hisplat.controller;

import com.mh.hisplat.bean.Department;
import com.mh.hisplat.bean.Hospital;
import com.mh.hisplat.entry.Response;
import com.mh.hisplat.service.DepartmentService;
import com.mh.hisplat.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartmentController {
    @Autowired
    private Response response;
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("list")
    public Response list(@RequestBody Department department) {
        List<Department> list = departmentService.selectListBy(department);
        return response.success("查询成功", list);
    }

}
