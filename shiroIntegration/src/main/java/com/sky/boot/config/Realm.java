package com.sky.boot.config;

import com.sky.boot.entity.User;
import com.sky.boot.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @author Administrator
 * 实现认证领域
 */
public class Realm extends AuthorizingRealm {
    @Resource
    private UserServiceImpl userService;

    /**
     * 用来授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        // 获取当前用户对象
        Subject subject = SecurityUtils.getSubject();
        // 初始化授权信息对象
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 获取principal对象,强转为用户对象,因为principal对象封装了用户对象信息
        User user = (User) subject.getPrincipal();
        // 给用户授权
        simpleAuthorizationInfo.addStringPermission(user.getPermissions());

        return simpleAuthorizationInfo;
    }

    /**
     * 用于用户认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证");
        // 将提交的用户令牌对象转化为用户令牌
        UsernamePasswordToken currentUserToken = (UsernamePasswordToken) authenticationToken;

        User user = userService.queryUserByName(currentUserToken.getUsername());
        if (user != null) {
            if (!user.getName().equals(currentUserToken.getUsername())) {
                // return null;相当于抛出了 UnKnowAccountException
                return null;
            }
        } else {
            return null;
        }
        // principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象
        Object principal = user;
<<<<<<< HEAD
        // credentials 密码
=======
        // credentials 账户名
>>>>>>> 38b4364... 我的spring boot练习
        String credentials = user.getName();

        // realmName:当前realm对象的name,调用父类的getName()方法即可
        String realm = getName();

        // credentials 的盐值加密
        ByteSource salt = ByteSource.Util.bytes(user.getName());

        Subject currentSubject = SecurityUtils.getSubject();

        Session session = currentSubject.getSession();
        session.setAttribute("user", user);
        // 密码校验,使用 盐值加密方式来获取认证信息 密码校验shiro帮助我们校验
        return new SimpleAuthenticationInfo(principal, credentials, salt, realm);
    }

}
