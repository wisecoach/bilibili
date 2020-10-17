package com.wisecoach.service;

import com.wisecoach.exception.PassportErrorException;
import com.wisecoach.pojo.Member;

import java.util.Map;

public interface UserService {
    Member findForAuth(Long mid);

    Map<String,Object> login(Member user) throws PassportErrorException;
}
