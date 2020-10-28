package com.wisecoach.controller;

import com.wisecoach.annotation.LoginToken;
import com.wisecoach.annotation.PassToken;
import com.wisecoach.pojo.Member;
import com.wisecoach.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/space")
public class SpaceController {
    @Autowired
    private MemberService memberService;

    @PassToken
    @GetMapping("/state")
    public Map<String, Object> getState(
        @RequestParam("mid") Long mid
    ){
        Map<String, Object> map = memberService.findState(mid);
        return map;
    }

    @LoginToken
    @GetMapping("/state/follow")
    public Integer follow(
        @RequestParam("mid") Long mid,
        @RequestAttribute("currentMember")Member member
    ){

        return 0;
    }

}

