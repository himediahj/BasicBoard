package com.practice.board.service.reply;

import com.practice.board.domain.ReplyDTO;
import com.practice.board.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyInsertService {
    @Autowired(required = false)
    private ReplyMapper replyMapper;

    public int register(ReplyDTO replyDTO){
        return replyMapper.insertReply(replyDTO);
    }
}
