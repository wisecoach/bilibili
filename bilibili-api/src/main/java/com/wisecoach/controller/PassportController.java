package com.wisecoach.controller;

import com.wisecoach.annotation.PassToken;
import com.wisecoach.exception.PassportErrorException;
import com.wisecoach.pojo.Member;
import com.wisecoach.pojo.User;
import com.wisecoach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/passport")
public class PassportController {
    @Autowired
    private UserService userService;

    @PassToken
    @PostMapping("/login")
    public Map<String, Object> login(
        @RequestBody User user,
        HttpServletRequest req,
        HttpServletResponse resp
    ) throws PassportErrorException {
        Map<String, Object> map = userService.login(user);
        return map;
    }

    @PassToken
    @PostMapping("/register")
    public void register(
        @RequestBody Map<String,Object> map
        ){
    }
}
