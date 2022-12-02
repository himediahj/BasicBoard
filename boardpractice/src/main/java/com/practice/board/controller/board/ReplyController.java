package com.practice.board.controller.board;

import com.practice.board.domain.ReplyDTO;
import com.practice.board.service.reply.ReplyInsertService;
import com.practice.board.service.reply.ReplyListService;
import com.practice.board.service.reply.ReplyRemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/replies")
public class ReplyController {
    @Autowired
    private ReplyListService replyListService;

    @Autowired
    private ReplyInsertService replyInsertService;

    @Autowired
    private ReplyRemoveService replyRemoveService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)    // produces : 서버가 클라이언트에게 반환하는 데이터 타입 정의
    public ResponseEntity<List<ReplyDTO>> selectAll(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("content-Type", "application/json");

        return new ResponseEntity<>(replyListService.selectAll(), httpHeaders, HttpStatus.OK);
    }

    /*@GetMapping(value = "/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReplyDTO>> selectBy(@PathVariable("bno") int bno){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("content-Type", "application/json");

        return new ResponseEntity<>(replyListService.selectByBno(bno), httpHeaders, HttpStatus.OK);
    }*/



    @PostMapping
    public ResponseEntity<String> create(@RequestBody ReplyDTO replyDTO){
        replyInsertService.register(replyDTO);
        replyDTO.setReplyDate(LocalDate.now().toString());
        replyDTO.setUpdateDate(LocalDate.now().toString());
        return new ResponseEntity<>("insert OK", HttpStatus.OK);
    }

    @DeleteMapping("/{rno}")
    public ResponseEntity<String> remove(@PathVariable("rno") int rno){
        replyRemoveService.remove(rno);
        return new ResponseEntity<>("delete", HttpStatus.OK);
    }
}
