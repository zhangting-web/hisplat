package com.mh.hisplat.controller;

import com.mh.hisplat.bean.Department;
import com.mh.hisplat.bean.User;
import com.mh.hisplat.entry.Response;
import com.mh.hisplat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private Response response;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response update(@RequestBody User user){
        try{
            userService.update(user);
            return response.success("修改成功");
        }catch(Exception e){
            return response.failure("失败："+e.getMessage());
        }
    }

    /**
     * 根据部门编号查询医生
     * @param user
     * @return
     */
    @RequestMapping("byDepart")
    public Response selectByDepart(@RequestBody User user) {
        List<User> list = userService.selectBy(user);
        return response.success("查询成功", list);
    }
}
