package com.practice.board.controller;

import com.practice.board.domain.MemberDTO;
import com.practice.board.service.member.MemberRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/member/register")
public class MemberRegController {
    @Autowired
    private MemberRegisterService memberRegisterService;

    @GetMapping
    public String getRegForm(){
        return "member/regForm";
    }

    @PostMapping
    public String reg(HttpServletRequest request, @Valid MemberDTO memberDTO, Errors errors, Model model){

        if(errors.hasErrors()){
            // 회원가입 실패시 입력 데이터 값 유지
            model.addAttribute("regData", memberDTO);

            // 유효성 통과 못한 필드와 메세지 핸들링
            Map<String, String> validatorResult = memberRegisterService.validateHandling(errors);
            for(String key : validatorResult.keySet()){
                model.addAttribute(key, validatorResult.get(key));
            }

            return "member/regForm";
        }
        
        memberRegisterService.insertMem(memberDTO);
        return "redirect:/index";
    }
}
