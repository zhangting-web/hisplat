package com.mh.hisplat.controller;

import com.mh.hisplat.bean.User;
import com.mh.hisplat.entry.CacheUser;
import com.mh.hisplat.entry.Response;
import com.mh.hisplat.service.UserService;
import com.mh.hisplat.utils.CommenUtils;
import com.mh.hisplat.utils.ShiroEncryUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description：登录Controller
 */
@Slf4j
@RestController
public class LoginController {

    @Resource
    private UserService userService;
    @Resource
    private ShiroEncryUtil shiroEncryUtil;
    @Resource
    private Response response;

    @Resource
    private CommenUtils commenUtils;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    /**
     * description: 登录
     *
     * @return 登录结果
     */
    @PostMapping("/login")
    public Response login( @RequestBody User user) {
        log.warn("进入登录.....");

        String username = user.getUsername();
        String password = user.getPassword();

        if (StringUtils.isBlank(username)) {
            return response.failure("用户名为空！");
        }

        if (StringUtils.isBlank(password)) {
            return response.failure("密码为空！");
        }

        CacheUser loginUser = userService.login(username, password);
        // 登录成功返回用户信息
        return response.success("登录成功！", loginUser);
    }

    /**
     * 获取验证码
     * @param phone
     * @param request
     * @return
     */
    @RequestMapping(value= "/vcode",method = RequestMethod.GET)
    public Response code(String phone, HttpServletRequest request){
        log.warn("获取验证码....");
        //校验手机号
        //判断同一手机号60s才能发送1次
        // 检测ip,同一ip一天最多发几次
        System.out.println(commenUtils.getIpAddress(request));
        //请求第三方（运营商）发送验证码

        //1.存数据库  手机号、验证码、创建时间、更新时间、有效期时间
        //2.存缓存
        //URL去连接第三方服务平台获取验证码
        if(commenUtils.isPhoneNum(phone)){
            Map resultMap = new HashMap();
            resultMap.put("code", commenUtils.getRandom());
//            resultMap.put()
            stringRedisTemplate.opsForValue().set(phone,resultMap.get("code").toString());
            stringRedisTemplate.expire(phone,10, TimeUnit.MINUTES);
            return response.success("请求成功",resultMap);
        }else{
            return response.failure("请检查手机号");
        }


    }

    /**
     * 注册加密
     * @param user
     * @return
     */
    @RequestMapping("/reg")
    public Response register(@RequestBody User user){
        log.warn("进入注册.....");

        String username = user.getUsername();
        String password = user.getPassword();

        if (StringUtils.isBlank(username)) {
            return response.failure("用户名为空！");
        }

        if (StringUtils.isBlank(password)) {
            return response.failure("密码为空！");
        }

        Map resultMap = userService.reg(user);
        if(Boolean.valueOf(resultMap.get("result").toString())){
            return response.success("注册成功");
        }else{
            return response.failure(resultMap.get("msg"));
        }

    }
    /**
     * description: 登出
     */
    @GetMapping("/logout")
    public Response logOut() {
        userService.logout();
        return response.success("登出成功！");
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * <br/>
     * <br/>
     * @return
     */
    @RequestMapping("/un_auth")
    public Response unAuth() {
        return response.failure(HttpStatus.UNAUTHORIZED, "用户未登录！", null);
    }

    /**
     * 未授权，无权限，此处返回未授权状态信息由前端控制跳转页面
     * <br/>
     * <br/>
     * @return
     */
    @RequestMapping("/unauthorized")
    public Response unauthorized() {
        return response.failure(HttpStatus.FORBIDDEN, "用户无权限！", null);
    }
}