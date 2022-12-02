package com.practice.board.mapper;

import com.practice.board.domain.BoardDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("select * from tbl_board")
    List<BoardDTO> selectAll();

    @Select("select * from tbl_board order by bno desc limit #{start}, #{count}")   // limit 시작위치(0부터), 반환개수
    List<BoardDTO> selectList(@Param("start") int start, @Param("count") int count);

    @Select("select count(*) from tbl_board")
    int selectTotalCount();

    @Select("select * from tbl_board where bno=#{bno}")
    BoardDTO selectByBno(int bno);

    int insertBoard(BoardDTO boardDTO);

    int updateBoard(BoardDTO boardDTO);

    @Delete("delete from tbl_board where bno=#{bno}")
    int deleteBoard(int bno);


}
