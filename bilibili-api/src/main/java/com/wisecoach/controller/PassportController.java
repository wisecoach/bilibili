package com.wisecoach.controller;

import com.wisecoach.annotation.PassToken;
import com.wisecoach.exception.PassportErrorException;
import com.wisecoach.pojo.Member;
import com.wisecoach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/passport")
public class PassportController {
    @Autowired
    private UserService userService;

    @PassToken
    @PostMapping("/login")
    public String login(
        @RequestBody Member member,
        HttpServletResponse resp
    ) throws PassportErrorException {
        Map<String, Object> map = userService.login(member);
        Cookie tokenCookie = new Cookie("bilibili_token", map.get("bilibili_token").toString());
        Cookie idCookie = new Cookie("bilibili_id", map.get("bilibili_id").toString());
        resp.addCookie(tokenCookie);
        resp.addCookie(idCookie);
        return "0";
    }
}
