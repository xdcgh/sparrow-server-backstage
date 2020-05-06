package com.xdc.sparrowShop.service;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

@Service
public class ShiroRealm extends AuthorizingRealm {
    private final UserService userService;

    public ShiroRealm(UserService userService) {
        this.userService = userService;

        this.setCredentialsMatcher((token, info) ->
                new String((char[]) token.getCredentials())
                        .equals(info.getCredentials()));
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String id = (String) token.getPrincipal();

        String correctCode = userService.getOpenidById(id);

        return new SimpleAuthenticationInfo(id, correctCode, getName());
    }
}
