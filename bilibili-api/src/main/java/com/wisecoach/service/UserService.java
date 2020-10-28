package com.wisecoach.service;

import com.wisecoach.exception.PassportErrorException;
import com.wisecoach.pojo.Member;
import com.wisecoach.pojo.User;

import java.util.Map;

public interface UserService {
    User findForAuth(Long mid);

    Map<String,Object> login(User user) throws PassportErrorException;
}
