package com.sky.boot.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author Administrator
 * 实现认证领域
 */
public class Realm extends AuthorizingRealm {

    /**
     * 用来授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        return null;
    }

    /**
     * 用于用户认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证");
        // 模仿数据库用户信息
        String username = "root";
        String password = "root";
        // 将提交的用户令牌对象转化为用户令牌
        UsernamePasswordToken currentUserToken = (UsernamePasswordToken) authenticationToken;
        if (!username.equals(currentUserToken.getUsername())) {
            // return null;相当于抛出了 UnKnowAccountException
            return null;
        }
        // 密码不用进行校验,因为密码设计安全信息,shiro帮助我们完成了校验
        return new SimpleAuthenticationInfo("", password, "");
    }
}
