package com.practice.board.service.reply;

import com.practice.board.domain.ReplyDTO;
import com.practice.board.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyListService {
    @Autowired(required = false)
    private ReplyMapper replyMapper;

    public List<ReplyDTO> selectAll(){
        return replyMapper.selectAll();
    }

    public List<ReplyDTO> selectByBno(int bno){return replyMapper.selectByBno(bno);}
}
