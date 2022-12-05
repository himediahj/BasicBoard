package com.practice.board.interceptor;

import com.practice.board.domain.MemberDTO;
import com.practice.board.service.member.MemberLoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Log4j2
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private MemberLoginService memberLoginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("자동로그인 여부 체크... ");

        // 현재 세션 구하기
        HttpSession session = request.getSession();

        if(session.getAttribute("loginInfo") == null){  // 로그인 세션이 없는 경우
            Cookie c1 = WebUtils.getCookie(request, "uuid");   // 쿠키 체크
            if(c1 != null){
                log.info("uuid 쿠키 존재 ... ");
                String uuid = c1.getValue();

                MemberDTO memberDTO = memberLoginService.autoLogin(uuid);   // DB에서 uuid 값 가지는 회원 데이터 찾는다

                if(memberDTO != null){
                    log.info("uuid 값을 가지고 있는 회원 정보로 로그인 처리");
                    session.setAttribute("loginInfo", memberDTO.getUid());
                    return true;
                }
            }
            log.info("비로그인 상태 -> 로그인 페이지 이동");
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
