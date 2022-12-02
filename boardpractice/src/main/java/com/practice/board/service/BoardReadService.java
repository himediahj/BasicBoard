package com.practice.board.service;

import com.practice.board.domain.BoardDTO;
import com.practice.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardReadService {
    @Autowired(required = false)
    private BoardMapper boardMapper;

    public BoardDTO getBoard(int bno){
        return boardMapper.selectByBno(bno);
    }
}
