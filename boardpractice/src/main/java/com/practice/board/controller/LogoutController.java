package com.practice.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        session.invalidate();

        Cookie c1 = WebUtils.getCookie(request, "uuid");
        if(c1 != null){
            c1.setPath("/");
            c1.setMaxAge(0);
            response.addCookie(c1);
        }
        return "redirect:/index";
    }
}
