package com.xdc.sparrowShop.service;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.xdc.sparrowShop.dao.UserDao;
import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.myEntity.Account;
import com.xdc.sparrowShop.entity.myEntity.WxUserInfo;
import com.xdc.sparrowShop.generate.User;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    private final WxMaService wxMaService = getWxMaService();

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User createUserIfNotExist(WxUserInfo wxUserInfo) {
        // 先去获取 openid ,再来执行插入操作
        String openid = getOpenidFromCode(wxUserInfo.getCode());

        // 再查询数据库是否有该 openid 的用户
        User user;

        try {
            user = userDao.getUserByOpenid(openid);
        } catch (Exception e) {
            user = createNewUser(wxUserInfo, openid);
        }

        return user;
    }

    private User createNewUser(WxUserInfo wxUserInfo, String openid) {
        User user = new User();

        user.setOpenid(openid);
        user.setNickName(wxUserInfo.getNickName());
        user.setAvatar(wxUserInfo.getAvatar());
        user.setAccount(10000);
        user.setUpdatedAt(new Date());
        user.setCreatedAt(new Date());

        userDao.insertUser(user);

        return user;
    }

    private String getOpenidFromCode(String code) {
        WxMaJscode2SessionResult sessionResult;

        try {
            sessionResult = wxMaService.getUserService().getSessionInfo(code);
        } catch (WxErrorException e) {
            throw new RuntimeException("login handler error");
        }

        return sessionResult.getOpenid();
    }

    private WxMaService getWxMaService() {
        WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();

        config.setAppid("wx4140bbc940d41af3");
        config.setSecret("857f83c14ecc5f959ec34e0b7ffe77bc");
        config.setMsgDataFormat("JSON");
        WxMaService wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(config);

        return wxMaService;
    }

    public String getOpenidById(String id) {
        return userDao.getOpenidById(id);
    }

    /**
     * 根据id 返回用户，如果不存在，返回null
     *
     * @param id 用户id
     * @return 返回用户
     */
    public Optional<User> getUserById(String id) {
        return Optional.ofNullable(userDao.getUserById(id));
    }

    public User toRecharge(Account account) {
        return changeAccount(account, "充值");
    }

    private User changeAccount(Account account, String string) {
        User user = UserContext.getCurrentUser();

        int updateAccount;

        if (string.equals("充值")) {
            updateAccount = user.getAccount() + account.getRechargeAccount() * 100;
        } else {
            updateAccount = user.getAccount() - account.getRechargeAccount() * 100;
        }

        user.setAccount(updateAccount);

        int affectedRows = userDao.updateUser(user);

        if (affectedRows == 0) {
            throw HttpException.notFound("更新用户金额失败");
        }

        return user;
    }

    public User toWithdraw(Account account) {
        return changeAccount(account, "提现");
    }
}
