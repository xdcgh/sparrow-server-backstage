package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.PageResponse;
import com.xdc.sparrowShop.generate.User;
import com.xdc.sparrowShop.generate.UserExample;
import com.xdc.sparrowShop.generate.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 更新用户余额，金额
     *
     * @param userId     用户编号
     * @param totalMoney 订单总价
     */
    public void updateAccount(Integer userId, Integer totalMoney) {
        User user = userMapper.selectByPrimaryKey(userId);

        user.setAccount(user.getAccount() + totalMoney);
        user.setUpdatedAt(new Date());

        userMapper.updateByPrimaryKeySelective(user);
    }

    public PageResponse<User> getUserList(Integer pageNum, Integer pageSize, String nickName) {
        if (nickName == null) {
            nickName = "";
        }

        int totalNumber = countUser(nickName);

        UserExample userExample = new UserExample();

        userExample.createCriteria()
                .andNickNameLike("%" + nickName + "%");

        userExample.setOrderByClause("ID DESC");

        userExample.setLimit(pageSize);
        userExample.setOffset((pageNum - 1) * pageSize);

        List<User> pageUser = userMapper.selectByExample(userExample);

        return PageResponse.pagedData(totalNumber, pageUser);
    }

    private int countUser(String nickName) {
        UserExample userExample = new UserExample();

        userExample.createCriteria()
                .andNickNameLike("%" + nickName + "%");

        return (int) userMapper.countByExample(userExample);
    }

    public void updateUser(User user, String adminName) {
        if (!adminName.equals("admin")) {
            throw HttpException.forbidden("权限错误");
        }

        user.setUpdatedAt(new Date());

        userMapper.updateByPrimaryKeySelective(user);
    }
}
