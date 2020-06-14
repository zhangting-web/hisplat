package com.mh.hisplat.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.mh.hisplat.bean.Register;
import com.mh.hisplat.entry.Response;

import com.mh.hisplat.service.RegisterService;
import com.mh.hisplat.utils.Constant;
import com.mh.hisplat.utils.PageRequest;
import com.mh.hisplat.utils.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/register")
@Slf4j
public class RegisterController {
    @Autowired
    private Response response;
    @Autowired
    private RegisterService registerService;
    @RequestMapping("/add")
    //权限设置
   @RequiresRoles({Constant.CUSTOMER})
   // @RequiresPermissions({"user:register:add"})
    public Response register(@RequestBody Register register){
        registerService.insert(register);
        return response.success("注册成功",register);
    }
    /**
     * pageNo
     * pageSize
     * searchCondition
     * totlePage
     * data
     *
     */

    @RequestMapping("/pagelist")
    public Response pagelist(@RequestBody String json){
        Register register =JSONObject.parseObject(json,Register.class);
        PageRequest pageRequest=JSONObject.parseObject(json,PageRequest.class);
        PageInfo pageResult= registerService.selectPageList(register,pageRequest);
        return response.success("查询成功",pageResult);
    }
    @RequestMapping("/doc/pagelist")
    public Response docPagelist(@RequestBody String json){
        Register register =JSONObject.parseObject(json,Register.class);
        PageRequest pageRequest=JSONObject.parseObject(json,PageRequest.class);
        PageInfo pageResult= registerService.selectDocPageList(register,pageRequest);
        return response.success("查询成功",pageResult);
    }

    /**
     * 根据预约主键查询
     * @param register
     * @return
     */
    @RequestMapping("/doc/get")
    public Response docGetBy(@RequestBody Register register){
        register = registerService.getById(register);
        return response.success(register);
    }
    @RequestMapping("/doc/del")
    public Response docDel(@RequestBody String json){
        JSONObject jsonObject =JSONObject.parseObject(json);
        JSONArray jsonArray=jsonObject.getJSONArray("ids");
        List list=new ArrayList<>();
        for(int i = 0;i<jsonArray.size();i++){
            list.add(jsonArray.get(i));
        }
        //删除 真删除 假删除
        registerService.delDocList(list);
        System.out.println(jsonArray);
        return response.success("删除成功");
    }
    @RequestMapping("/doc/bynamelist")
    public Response docBynamelist(@RequestBody String json){
        Register register =JSONObject.parseObject(json,Register.class);
        PageRequest pageRequest=JSONObject.parseObject(json,PageRequest.class);
        PageInfo pageResult= registerService.selectDocBynamelist(register,pageRequest);
        return response.success("查询成功",pageResult);
    }


}
