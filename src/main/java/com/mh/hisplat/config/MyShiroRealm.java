package com.mh.hisplat.config;



import com.mh.hisplat.bean.Permission;
import com.mh.hisplat.bean.Role;
import com.mh.hisplat.bean.User;
import com.mh.hisplat.service.PermissionService;
import com.mh.hisplat.service.RoleService;
import com.mh.hisplat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @description：自定义 shiroRealm, 主要是重写其认证、授权
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

//    private IUserService iUserService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;


    /**
     * description: 授权
     *
     * @return 权限信息，包括角色以及权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.warn("开始执行授权操作.......");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //如果身份认证的时候没有传入User对象，这里只能取到userName
        //也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
        User user = (User) principals.getPrimaryPrincipal();

        // 查询用户角色，一个用户可能有多个角色
//        List<Role> roles = iRoleService.getUserRoles(user.getId());
        //这里一个用户只有一个角色
            Role role = roleService.gertUserRole(user.getrId());
//        for (Role role : roles) {
            authorizationInfo.addRole(role.getrName());
            // 根据角色查询权限
            List<Permission> permissions = permissionService.getRolePermissions(role.getrId());
            for (Permission p : permissions) {
                authorizationInfo.addStringPermission(p.getpName());
            }
//        }
        return authorizationInfo;
    }

    /**
     * description: 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     *
     * @return 身份验证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.warn("开始进行身份认证......");

        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();

        //通过username从数据库中查找 User对象.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.findByUsername(username);
        if (Objects.isNull(user)) {
            return null;
        }

        return new SimpleAuthenticationInfo(
                // 这里传入的是user对象，比对的是用户名，直接传入用户名也没错，但是在授权部分就需要自己重新从数据库里取权限
                user,
                // 密码,这里是指从数据库中获取的password。
                user.getPassword(),
                // salt = username + salt
//                ByteSource.Util.bytes(user.getCredentialsSalt()),
                // realm name
                getName()
        );
    }

}
