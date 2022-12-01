package com.practice.board.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BoardListDTO {
    private int pageNum;
    private List<BoardDTO> list;
    private int totalCountOfArticle;
    private int totalCountOfPage;
}
