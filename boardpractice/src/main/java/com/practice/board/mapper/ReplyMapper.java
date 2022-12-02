package com.practice.board.mapper;

import com.practice.board.domain.ReplyDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReplyMapper {
    @Select("select * from tbl_reply")
    List<ReplyDTO> selectAll();
    @Select("select * from tbl_reply where bno=#{bno}")
    List<ReplyDTO> selectByBno(int bno);

    @Insert("insert into tbl_reply (bno, reply, replyer) values (#{bno}, #{reply}, #{replyer})")
    int insertReply(ReplyDTO replyDTO);

    @Delete("delete from tbl_reply where rno=#{rno}")
    int deleteReply(int rno);
}
