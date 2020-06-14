package com.mh.hisplat.controller;

import com.mh.hisplat.bean.Hospital;
import com.mh.hisplat.entry.Response;
import com.mh.hisplat.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private Response response;
    @Autowired
    private HospitalService hospitalService;
    @RequestMapping("list")
    public Response list(){
        List<Hospital> list=hospitalService.selectAll();
        return response.success("查询成功",list);
    }

}