package com.practice.board.controller;

import com.practice.board.domain.MemberDTO;
import com.practice.board.service.member.MemberLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private MemberLoginService loginService;

    @GetMapping
    public String loginForm(){return "loginForm";}

    @PostMapping
    public String login(@RequestParam("uid") String uid, @RequestParam("pw") String pw, HttpServletRequest request){
        MemberDTO memberDTO = loginService.login(uid, pw);

        if(memberDTO != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginInfo", memberDTO.getUid());
        }
        return "redirect:/index";
    }
}
