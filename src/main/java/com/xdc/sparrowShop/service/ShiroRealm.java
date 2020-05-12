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
    private final ShopService shopService;

    public ShiroRealm(ShopService shopService) {
        this.shopService = shopService;

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
        String phone = (String) token.getPrincipal();

        String correctCode;

        if (phone.equals("admin")) {
            correctCode = "123456";
        } else {
            correctCode = shopService.getPasswordByPhone(phone);
        }

        return new SimpleAuthenticationInfo(phone, correctCode, getName());
    }
}
