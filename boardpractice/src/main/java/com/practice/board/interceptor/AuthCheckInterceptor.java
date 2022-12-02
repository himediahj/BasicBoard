package com.practice.board.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class AuthCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("회원 로그인 여부 체크...");

        // 세션 확인
        HttpSession session = request.getSession();

        // 세션에 로그인 정보가 있으면 정상 처리
        if(session != null && session.getAttribute("loginInfo") != null){
            log.info("로그인 상태...");
            return true;
        }

        // 로그인 정보 없으면
        log.info("비로그인 상태");
        response.sendRedirect("/login");
        return false;
    }
}
