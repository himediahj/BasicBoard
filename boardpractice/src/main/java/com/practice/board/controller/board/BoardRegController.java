package com.practice.board.controller.board;

import com.practice.board.domain.BoardDTO;
import com.practice.board.service.BoardRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/register")
public class BoardRegController {

    @Autowired
    private BoardRegService boardRegService;

    @GetMapping
    public void getInsertForm(){}

    @PostMapping
    public String insert(BoardDTO boardDTO){
        boardRegService.insertBoard(boardDTO);
        return "redirect:/board/list";
    }
}
