package com.example.simpleboard.controller;

import com.example.simpleboard.board.BoardService;
import com.example.simpleboard.dto.request.BoardWriteRequest;
import com.example.simpleboard.dto.response.BaseResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BaseResponseBody> saveBoard(@RequestBody BoardWriteRequest boardWriteRequest) {
        boardService.saveBoard(boardWriteRequest);

        return ResponseEntity.ok(BaseResponseBody.of(200, "Success"));
    }
}

