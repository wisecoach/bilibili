package com.wisecoach.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wisecoach.exception.PassportErrorException;
import com.wisecoach.exception.ResponseException;
import com.wisecoach.mapper.UserMapper;
import com.wisecoach.pojo.Member;
import com.wisecoach.pojo.User;
import com.wisecoach.service.UserService;
import com.wisecoach.util.JwtUtil;
import com.wisecoach.util.SaltUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 搜索user，返回id，password用于检测token
     * @param mid mid
     * @return user
     */
    @Override
    public User findForAuth(Long mid){
        QueryWrapper<User> qw = new QueryWrapper();
        qw.select("mid","password").eq("mid", mid);
        User user = userMapper.selectOne(qw);
        return user;
    }

    /**
     * 登录
     * @param userToLogin 登录信息，登录信息记录在password和name中，name可以是mid，tel，email
     * @return 登录验证后返回token
     */
    @Override
    public Map<String,Object> login(User userToLogin) throws PassportErrorException {
        HashMap<String, Object> map = new HashMap<>();
        String name = userToLogin.getTel();
        String password = userToLogin.getPassword();
        String token = null;
        ArrayList<String> loginColumns = new ArrayList<>();
        loginColumns.add("mid");
        loginColumns.add("tel");
        loginColumns.add("email");
        for (String loginColumn : loginColumns) {
            QueryWrapper<User> qw = new QueryWrapper<>();
            qw.select("mid","password").eq(loginColumn, name);
            User user = userMapper.selectOne(qw);
            if(user == null)
                continue;
            userToLogin.setMid(user.getMid());
            password = SaltUtil.salty(userToLogin);
            if(user.getPassword().equals(password)){
                token = JwtUtil.formToken(user);
                User newUser = new User();
                newUser.setMid(user.getMid());
                newUser.setIsLogin(true);
                userMapper.updateById(newUser);
                map.put("bilibili_token", token);
                map.put("bilibili_id", user.getMid());
                return map;
            }
        }
        throw new PassportErrorException();
    }

}
