package com.wisecoach.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wisecoach.pojo.User;

public class JwtUtil {
    public static String formToken(User user) {
        String token = "";
        token = JWT.create().withAudience(new Long(user.getMid()).toString()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}