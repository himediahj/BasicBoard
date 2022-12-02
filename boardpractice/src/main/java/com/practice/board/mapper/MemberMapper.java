package com.practice.board.mapper;

import com.practice.board.domain.MemberDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    @Insert("insert into tbl_member (uid, pw, uname) values (#{uid}, #{pw}, #{uname})")
    int insertMem(MemberDTO memberDTO);

    @Select("select * from tbl_member where uid=#{uid} and pw=#{pw}")
    MemberDTO selectByIdPw(@Param("uid") String uid, @Param("pw") String pw);
}
