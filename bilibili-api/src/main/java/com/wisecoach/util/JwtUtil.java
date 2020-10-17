package com.wisecoach.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wisecoach.pojo.Member;

public class JwtUtil {
    public static String formToken(Member member) {
        String token = "";
        token = JWT.create().withAudience(new Long(member.getMid()).toString()).sign(Algorithm.HMAC256(member.getPassword()));
        return token;
    }
}