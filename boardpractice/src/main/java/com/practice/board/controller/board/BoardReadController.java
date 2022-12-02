package com.practice.board.controller.board;

import com.practice.board.service.BoardReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardReadController {
    @Autowired
    private BoardReadService boardReadService;

    @GetMapping("/board/read")
    public void readBoard(Model model, @RequestParam("bno") int bno){
        model.addAttribute("board", boardReadService.getBoard(bno));
    }
}
