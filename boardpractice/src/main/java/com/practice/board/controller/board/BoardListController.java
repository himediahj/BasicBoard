package com.practice.board.controller.board;

import com.practice.board.service.BoardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardListController {
    @Autowired
    private BoardListService boardListService;

    @RequestMapping("/board/list")
    public void getBoardList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model){
        model.addAttribute("page", boardListService.getBoardList(pageNum));
    }
}
