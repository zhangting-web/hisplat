package com.mh.hisplat.controller;

import com.mh.hisplat.bean.Area;
import com.mh.hisplat.entry.Response;
import com.mh.hisplat.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("area")
public class AreaController {
    @Autowired
    private Response response;
    @Autowired
    private AreaService areaService;
    //返回所有的省
    @RequestMapping(value = "/province",method = RequestMethod.POST)
    public Response province(){
        List<Area> list = areaService.selectAllProvince();
        return response.success("查询成功",list);
    }
    @RequestMapping(value = "/city" ,method = RequestMethod.POST)
    public Response city(@RequestBody Area area){
        List<Area> list = areaService.selectCityBy(area.getPid());
        return response.success("查询成功",list);
    }
}
