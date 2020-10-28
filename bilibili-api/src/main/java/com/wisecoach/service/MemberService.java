package com.wisecoach.service;

import com.wisecoach.pojo.Member;

import java.util.Map;

public interface MemberService {
    Member findOne(Long mid);

    Map<String, Object> findState(Long mid);
}
