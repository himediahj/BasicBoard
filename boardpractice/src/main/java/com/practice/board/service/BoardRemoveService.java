package com.practice.board.service;

import com.practice.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardRemoveService {
    @Autowired(required = false)
    private BoardMapper boardMapper;

    public int deleteBoard(int bno){
        return boardMapper.deleteBoard(bno);
    }
}
