package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.generate.User;
import com.xdc.sparrowShop.generate.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 更新用户余额，金额
     * @param userId 用户编号
     * @param totalMoney 订单总价
     */
    public void updateAccount(Integer userId, Integer totalMoney) {
        User user = userMapper.selectByPrimaryKey(userId);

        user.setAccount(user.getAccount() + totalMoney);
        user.setUpdatedAt(new Date());

        userMapper.updateByPrimaryKeySelective(user);
    }
}
