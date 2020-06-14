package com.mh.hisplat.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.mh.hisplat.bean.Medical;
import com.mh.hisplat.bean.MedicalWithBLOBs;
import com.mh.hisplat.bean.Register;
import com.mh.hisplat.entry.Response;
import com.mh.hisplat.service.MedicalService;
import com.mh.hisplat.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medical")
public class MedicalController {
    @Autowired
    private Response response;
    @Autowired
    private MedicalService medicalService;
    @RequestMapping("/add")
    public  Response add(@RequestBody MedicalWithBLOBs medical){
        medicalService.add(medical);
        return  response.success("添加成功");
    }
    @RequestMapping("/pagelist")
    public Response Pagelist(@RequestBody String json){
        MedicalWithBLOBs medical = JSONObject.parseObject(json,MedicalWithBLOBs.class);
        PageRequest pageRequest=JSONObject.parseObject(json,PageRequest.class);
        PageInfo pageResult= medicalService.selectPageList(medical,pageRequest);
        return response.success("查询成功",pageResult);
    }
    @RequestMapping("/pageByList")
    public Response ByList(@RequestBody String json){
        MedicalWithBLOBs medical = JSONObject.parseObject(json,MedicalWithBLOBs.class);
        PageRequest pageRequest=JSONObject.parseObject(json,PageRequest.class);
        PageInfo pageResult= medicalService.selectPageByList(medical,pageRequest);
        return response.success("查询成功",pageResult);
    }
    @RequestMapping("/del")
    public Response Del(@RequestBody String json) {
        JSONObject jsonObject=JSONObject.parseObject(json);
        JSONArray jsonArray=jsonObject.getJSONArray("ids");
        List ids=  new ArrayList();
        if(null!=jsonArray){
            for(int i = 0,length = jsonArray.size();i<length;i++){
                ids.add(jsonArray.get(i));
            }
        }
        medicalService.del(ids);
        return response.success("删除成功");
    }
    @RequestMapping("/update")
    public  Response update(@RequestBody MedicalWithBLOBs medicalWithBLOBs){
        medicalService.updateById(medicalWithBLOBs);
        return  response.success("修改成功");
    }
    }
