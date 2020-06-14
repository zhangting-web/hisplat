package com.mh.hisplat.service.impl;

import com.mh.hisplat.bean.User;
import com.mh.hisplat.dao.UserMapper;
import com.mh.hisplat.entry.CacheUser;
import com.mh.hisplat.exception.LoginException;
import com.mh.hisplat.exception.ValidationCodeException;
import com.mh.hisplat.service.UserService;
import com.mh.hisplat.utils.ShiroEncryUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Resource
    private ShiroEncryUtil shiroEncryUtil;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public CacheUser login(String username, String password) {
        // 获取Subject实例对象，用户实例
        Subject currentUser = SecurityUtils.getSubject();

        // 将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        CacheUser cacheUser;

        // 4、认证
        try {
            // 传到 MyShiroRealm 类中的方法进行认证
            currentUser.login(token);
            // 构建缓存用户信息返回给前端
            User user = (User) currentUser.getPrincipals().getPrimaryPrincipal();
            // java8 使用builder创建实体 并链式赋值
            cacheUser = CacheUser.builder()
                    .token(currentUser.getSession().getId().toString())
                    .build();
            BeanUtils.copyProperties(user, cacheUser);
            log.warn("CacheUser is {}", cacheUser.toString());
        } catch (UnknownAccountException e) {
            log.error("账户不存在异常：", e);
            throw new LoginException("账号不存在!", e);
        } catch (IncorrectCredentialsException e) {
            log.error("凭据错误（密码错误）异常：", e);
            throw new LoginException("密码不正确!", e);
        } catch (AuthenticationException e) {
            log.error("身份验证异常:", e);
            throw new LoginException("用户验证失败!", e);
        }
        return cacheUser;
    }

    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        //subject.hasAllRoles();
        subject.logout();
    }

    @Override
    public Map reg(User user) {
        Map resultMap = new HashMap();
        //校验手机验证码
        String phone = user.getPhone();
        String vcode = stringRedisTemplate.opsForValue().get(phone);
        stringRedisTemplate.delete(phone);
        if(StringUtils.isBlank(vcode)){
            resultMap.put("result",false);
            resultMap.put("msg","验证码已过期，请重新获取");
            return resultMap;
        }
        if(!user.getVcode().equals(vcode)){
            resultMap.put("result",false);
            resultMap.put("msg","验证码错误请重新获取");
            return resultMap;
        }
        //判断用户名是否存在
        User u = userMapper.findByUsername(user.getUsername());
        if(null != u){
            resultMap.put("result",false);
            resultMap.put("msg","账号重复");
        }else {
            log.warn("password加密前："+user.getPassword());
            String password = shiroEncryUtil.encryPwd(user.getPassword());
            user.setPassword(password);
            log.warn("password加密后："+password);
            user.setrId(4);//init 角色id
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userMapper.insert(user);
            resultMap.put("result",true);
        }
        return resultMap;
    }

    @Override
    public void update(User user) {
        if (null == user ){
            throw new IllegalArgumentException("缺少必要信息");
        }

        if(StringUtils.isNotBlank(user.getPhone())){
            //校验验证码
            String vcodeVal = stringRedisTemplate.opsForValue().get(user.getPhone());
            if (StringUtils.isBlank(user.getVcode())||!vcodeVal.equals(user.getVcode())){
                throw new ValidationCodeException("请先获取验证码！");
            }
            stringRedisTemplate.delete(user.getPhone());
        }
        User sessionUser = (User) SecurityUtils.getSubject().getPrincipal();
        //用户id从当前session缓存中取
        user.setuId(sessionUser.getuId());
        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> selectBy(User user) {
        user.setrId(2);
        return userMapper.selectBy(user);
    }
}
