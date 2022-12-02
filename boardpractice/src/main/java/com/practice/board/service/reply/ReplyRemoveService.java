package com.practice.board.service.reply;

import com.practice.board.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyRemoveService {
    @Autowired(required = false)
    private ReplyMapper replyMapper;

    public int remove(int rno){
        return replyMapper.deleteReply(rno);
    }
}
