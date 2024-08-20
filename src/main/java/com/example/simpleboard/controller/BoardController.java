package com.example.simpleboard.controller;

import com.example.simpleboard.dto.BoardListDto;
import com.example.simpleboard.dto.request.BoardRatingSaveRequest;
import com.example.simpleboard.service.BoardService;
import com.example.simpleboard.dto.request.BoardWriteRequest;
import com.example.simpleboard.dto.response.BaseResponseBody;
import com.example.simpleboard.dto.BoardDetailDto;
import com.example.simpleboard.dto.response.DataResponse;
import com.example.simpleboard.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity<DataResponse> getBoardList(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("boardId").descending());
        Page<Board> boardList = boardService.getBoardList(pageable);
        return ResponseEntity.ok(DataResponse.of(200, "Success", boardList.map(BoardListDto::of)));
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<DataResponse> getBoardDetail(@PathVariable Long boardId) {
        Board boardDetail = boardService.getBoardDetail(boardId);

        return ResponseEntity.ok(DataResponse.of(200, "Success", BoardDetailDto.of(boardDetail)));
    }

    @PostMapping
    public ResponseEntity<BaseResponseBody> saveBoard(@RequestBody BoardWriteRequest boardWriteRequest) {
        boardService.saveBoard(boardWriteRequest);

        return ResponseEntity.ok(BaseResponseBody.of(200, "Success"));
    }

    @PostMapping("/rating")
    public ResponseEntity<BaseResponseBody> saveBoardRating(@RequestBody BoardRatingSaveRequest boardRatingSaveRequest) {
        boardService.saveBoardRating(boardRatingSaveRequest);

        return ResponseEntity.ok(BaseResponseBody.of(200, "Success"));
    }
}

