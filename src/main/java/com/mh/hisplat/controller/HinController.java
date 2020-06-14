package com.mh.hisplat.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.mh.hisplat.bean.HIn;
import com.mh.hisplat.bean.MedicalWithBLOBs;
import com.mh.hisplat.entry.Response;
import com.mh.hisplat.service.HinService;
import com.mh.hisplat.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hin")
public class HinController {
    @Autowired
    private Response response;
    @Autowired
    private HinService hinService;
    @RequestMapping("/add")
    public  Response add(@RequestBody HIn hin){
        hinService.add(hin);
        return  response.success("添加成功");
    }
    @RequestMapping("/update")
    public  Response update(@RequestBody HIn hin){
        hinService.updateById(hin);
        return  response.success("修改成功");
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
        hinService.del(ids);
        return response.success("删除成功");
    }
    @RequestMapping("/pagelist")
    public Response Pagelist(@RequestBody String json){
        HIn hin = JSONObject.parseObject(json,HIn.class);
        PageRequest pageRequest=JSONObject.parseObject(json,PageRequest.class);
        PageInfo pageResult= hinService.selectPageByname(hin,pageRequest);
        return response.success("查询成功",pageResult);
    }

}