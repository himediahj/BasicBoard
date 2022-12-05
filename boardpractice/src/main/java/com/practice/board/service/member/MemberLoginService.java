package com.practice.board.service.member;

import com.practice.board.domain.MemberDTO;
import com.practice.board.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginService {
    @Autowired(required = false)
    private MemberMapper memberMapper;

    public MemberDTO login(String uid, String pw){
        return memberMapper.selectByIdPw(uid, pw);
    }

    public int insertUUID(String uuid, int idx){
        return memberMapper.updateUUID(uuid, idx);
    }

    public MemberDTO autoLogin(String uuid){
        return memberMapper.selectByUUID(uuid);
    }
}
