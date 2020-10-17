package com.wisecoach.interceptor;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisecoach.annotation.LoginToken;
import com.wisecoach.annotation.PassToken;
import com.wisecoach.pojo.Member;
import com.wisecoach.response.CustomResponseEntity;
import com.wisecoach.service.MemberService;
import com.wisecoach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

import static com.wisecoach.config.ExceptionConfig.*;


public class GlobalAuthInterceptor implements HandlerInterceptor {
    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.getAnnotation(PassToken.class)!=null){
            return true;
        }
        LoginToken loginToken = method.getAnnotation(LoginToken.class);
        if(loginToken!=null){
            String cookie1 = request.getHeader("cookie");
            Cookie[] cookies = request.getCookies();
            String token = null;
            if(cookies != null){
                for (Cookie cookie : cookies) {
                    if(cookie.getName().equals("bilibili_token") && !cookie.getValue().equals("")){
                        token = cookie.getValue();
                    }
                }
            }
            if(token == null){
                if(loginToken.required()){
                    ObjectMapper mapper = new ObjectMapper();
                    String error = mapper.writeValueAsString(new CustomResponseEntity(MEMBER_MISSING_CODE, MEMBER_MISSING_MSG, null));
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().write(error);
                    return false;
                }else {
                    return true;
                }
            }
            Long mid = Long.valueOf(JWT.decode(token).getAudience().get(0));
            Member user = userService.findForAuth(mid);
            if (user == null) {
                ObjectMapper mapper = new ObjectMapper();
                String error = mapper.writeValueAsString(new CustomResponseEntity(MEMBER_MISSING_CODE, MEMBER_MISSING_MSG, null));
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write(error);
                return false;
            }
            if (!user.getIsLogin()){
                ObjectMapper mapper = new ObjectMapper();
                String error = mapper.writeValueAsString(new CustomResponseEntity(MEMBER_MISSING_CODE, MEMBER_MISSING_MSG, null));
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write(error);
                return false;
            }
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            try {
                jwtVerifier.verify(token);
            } catch (JWTVerificationException e){
                ObjectMapper mapper = new ObjectMapper();
                String error = mapper.writeValueAsString(new CustomResponseEntity(MEMBER_MISSING_CODE, MEMBER_MISSING_MSG, null));
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write(error);
                return false;
            }
            Member member = memberService.findOne(mid);
            request.setAttribute("currentMember", member);
        }
        return true;
    }
}
