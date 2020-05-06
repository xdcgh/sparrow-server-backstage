package com.xdc.sparrowShop.dao;

import com.xdc.sparrowShop.generate.User;
import com.xdc.sparrowShop.generate.UserExample;
import com.xdc.sparrowShop.generate.UserMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
@SuppressFBWarnings("RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE")
public class UserDao {
    private final UserMapper userMapper;

    @Autowired
    public UserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public void insertUser(User user) {
        userMapper.insert(user);
    }

    public User getUserByOpenid(String openid) {
        UserExample example = new UserExample();
        example.createCriteria().andOpenidEqualTo(openid);

        return userMapper.selectByExample(example).get(0);
    }

    public String getOpenidById(String id) {
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(Integer.parseInt(id));

        return userMapper.selectByExample(example).get(0).getOpenid();
    }

    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    public int updateUser(User user) {
        UserExample byId = new UserExample();
        byId.createCriteria().andIdEqualTo(user.getId());

        return userMapper.updateByExample(user, byId);
    }
}
