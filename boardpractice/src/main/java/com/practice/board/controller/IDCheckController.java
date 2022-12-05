package com.practice.board.controller;

import com.practice.board.service.member.MemberLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IDCheckController {
    @Autowired
    private MemberLoginService memberLoginService;

    @PostMapping("/member/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam(value = "uid", required = false) String uid){
        int cnt = memberLoginService.idCheck(uid);
        return cnt;
    }
}
