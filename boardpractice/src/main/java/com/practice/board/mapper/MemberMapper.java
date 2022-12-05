package com.practice.board.mapper;

import com.practice.board.domain.MemberDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberMapper {
    @Insert("insert into tbl_member (uid, pw, uname) values (#{uid}, #{pw}, #{uname})")
    int insertMem(MemberDTO memberDTO);

    @Select("select * from tbl_member where uid=#{uid} and pw=#{pw}")
    MemberDTO selectByIdPw(@Param("uid") String uid, @Param("pw") String pw);

    @Update("update tbl_member set uuid=#{uuid} where idx=#{idx}")
    int updateUUID(@Param("uuid") String uuid, @Param("idx") int idx);

    @Select("select * from tbl_member where uuid=#{uuid}")
    MemberDTO selectByUUID(@Param("uuid") String uuid);
}
