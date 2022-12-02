package com.practice.board.service.member;

import com.practice.board.domain.MemberDTO;
import com.practice.board.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberRegisterService {
    @Autowired(required = false)
    private MemberMapper memberMapper;

    public int insertMem(MemberDTO memberDTO){
        return memberMapper.insertMem(memberDTO);
    }

    public Map<String, String> validateHandling(Errors errors){
        Map<String, String> validatorResult = new HashMap<>();

        // 유효성 검사에 실패한 필드 목록 받음
        for(FieldError error : errors.getFieldErrors()){
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }
}
