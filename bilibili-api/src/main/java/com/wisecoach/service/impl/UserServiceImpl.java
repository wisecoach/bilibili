package com.wisecoach.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wisecoach.exception.PassportErrorException;
import com.wisecoach.exception.ResponseException;
import com.wisecoach.mapper.UserMapper;
import com.wisecoach.pojo.Member;
import com.wisecoach.service.UserService;
import com.wisecoach.util.JwtUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Member findForAuth(Long mid){
        QueryWrapper<Member> qw = new QueryWrapper();
        qw.select("mid","password").eq("mid", mid);
        Member member = userMapper.selectOne(qw);
        return member;
    }

    /**
     * 登录
     * @param user 登录信息，登录信息记录在password和mid中，mid可以是mid，tel，email
     * @return 登录验证后返回token
     */
    @Override
    public Map<String,Object> login(Member user) throws PassportErrorException {
        HashMap<String, Object> map = new HashMap<>();
        Long mid = user.getMid();
        String password = user.getPassword();
        String token = null;
        ArrayList<String> loginColumns = new ArrayList<>();
        for (String loginColumn : loginColumns) {
            QueryWrapper<Member> qw = new QueryWrapper<>();
            qw.select("mid","password").eq(loginColumn, mid);
            Member member = userMapper.selectOne(qw);
            if(member.getPassword().equals(password)){
                token = JwtUtil.formToken(member);
                Member newUser = new Member();
                newUser.setMid(member.getMid());
                newUser.setIsLogin(true);
                userMapper.updateById(newUser);
                map.put("bilibili_token", token);
                map.put("bilibili_id", member.getMid());
                return map;
            }
        }
        throw new PassportErrorException();
    }

    public void register(Member member){

    }
}
