package com.example.simpleboard.controller;

import com.example.simpleboard.service.BoardService;
import com.example.simpleboard.dto.request.BoardWriteRequest;
import com.example.simpleboard.dto.response.BaseResponseBody;
import com.example.simpleboard.dto.BoardDetailDto;
import com.example.simpleboard.dto.response.DataResponse;
import com.example.simpleboard.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardId}")
    public ResponseEntity<? extends BaseResponseBody> getBoardDetail(@PathVariable Long boardId) {
        Board boardDetail = boardService.getBoardDetail(boardId);

        return ResponseEntity.ok(DataResponse.of(200, "Success", BoardDetailDto.of(boardDetail)));
    }

    @PostMapping
    public ResponseEntity<BaseResponseBody> saveBoard(@RequestBody BoardWriteRequest boardWriteRequest) {
        boardService.saveBoard(boardWriteRequest);

        return ResponseEntity.ok(BaseResponseBody.of(200, "Success"));
    }
}

