package com.wisecoach.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wisecoach.mapper.MemberMapper;
import com.wisecoach.pojo.Member;
import com.wisecoach.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member findOne(Long mid){
        Member member = memberMapper.selectById(mid);
        return member;
    }
}
