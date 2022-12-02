package com.practice.board.controller.board;

import com.practice.board.domain.BoardDTO;
import com.practice.board.service.BoardEditService;
import com.practice.board.service.BoardReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board/modify")
public class BoardEditController {
    @Autowired
    private BoardReadService boardReadService;

    @Autowired
    private BoardEditService boardEditService;

    @GetMapping
    public void getModifyForm(Model model, @RequestParam("bno") int bno){
        model.addAttribute("board", boardReadService.getBoard(bno));
    }

    @PostMapping
    public String modifyPost(BoardDTO boardDTO){
        boardEditService.editBoard(boardDTO);
        return "redirect:/board/list";
    }
}
