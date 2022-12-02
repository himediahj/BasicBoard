package com.practice.board.controller;

import com.practice.board.domain.MemberDTO;
import com.practice.board.service.member.MemberLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private MemberLoginService loginService;

    @GetMapping
    public String loginForm(){return "loginForm";}

    @PostMapping
    public String login(@RequestParam("uid") String uid, @RequestParam("pw") String pw, HttpServletRequest request, HttpServletResponse response){
        String idremember = request.getParameter("idremember");

        // idremember null 아니면 userid를 쿠키에 저장
        if(idremember != null){
            Cookie c = new Cookie("reId", uid);
            c.setMaxAge(60*60*24*180);  // 6개월
            response.addCookie(c);
        } else {
            Cookie c = new Cookie("reId", uid);
            c.setMaxAge(0);
            response.addCookie(c);
        }

        MemberDTO memberDTO = loginService.login(uid, pw);

        if(memberDTO != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginInfo", memberDTO.getUid());
        }
        return "redirect:/index";
    }
}
