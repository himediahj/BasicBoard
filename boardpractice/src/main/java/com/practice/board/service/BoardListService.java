package com.practice.board.service;

import com.practice.board.domain.BoardDTO;
import com.practice.board.domain.BoardListDTO;
import com.practice.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardListService {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    private final int countPerPage = 10;

    public BoardListDTO getBoardList(int pageNum){
        // 현재 요청 페이지
        int requestPageNum = pageNum;

        // 요청 페이지의 리스트
        List<BoardDTO> list = boardMapper.selectList((requestPageNum-1)*10, countPerPage);

        // 전체 게시물 개수
        int totalCountOfArticle = boardMapper.selectTotalCount();

        // 전체 페이지 개수
        int totalCountOfPage = totalCountOfArticle/countPerPage + (totalCountOfArticle%countPerPage>0? 1 : 0);

        return BoardListDTO.builder()
                .pageNum(requestPageNum)
                .list(list)
                .totalCountOfArticle(totalCountOfArticle)
                .totalCountOfPage(totalCountOfPage)
                .build();
    }
}
