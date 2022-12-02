package com.practice.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReplyDTO {
    private int rno;
    private int bno;
    private String reply;
    private String replyer;
    private String replyDate, updateDate;
}
