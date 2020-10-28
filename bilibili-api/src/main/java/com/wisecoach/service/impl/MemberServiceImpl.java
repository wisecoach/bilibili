package com.wisecoach.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wisecoach.mapper.MemberMapper;
import com.wisecoach.pojo.Member;
import com.wisecoach.service.MemberService;
import com.wisecoach.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Member findOne(Long mid){
        Member member = memberMapper.selectById(mid);
        return member;
    }

    @Override
    public Map<String, Object> findState(Long mid){
        HashMap<String, Object> map = new HashMap<>();
        List<String> columns = Arrays.asList("like", "view", "followers");
        for (String column : columns) {
            Object value = redisUtil.get("member", mid.toString(), "state", column);
            if(value != null){
                map.put(column, value);
            }else {
                QueryWrapper<Member> wrapper = new QueryWrapper<>();
                wrapper.select(column).eq("mid", mid);
                Member member = memberMapper.selectOne(wrapper);

            }
        }
        return map;
    }
}
