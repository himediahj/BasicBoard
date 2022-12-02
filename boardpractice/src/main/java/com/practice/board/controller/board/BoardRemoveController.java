package com.practice.board.controller.board;

import com.practice.board.service.BoardRemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardRemoveController {
    @Autowired
    private BoardRemoveService boardRemoveService;

    @GetMapping("/board/remove")
    public String remove(@RequestParam("bno") int bno){
        boardRemoveService.deleteBoard(bno);
        return "redirect:/board/list";
    }
}
