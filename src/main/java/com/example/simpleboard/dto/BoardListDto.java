package com.example.simpleboard.dto;

import com.example.simpleboard.entity.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListDto {

    private Long boardId;

    private String title;

    private Long memberId;

    private Integer viewCnt;

    public static BoardListDto of(Board board) {
        BoardListDto boardListDto = new BoardListDto();
        boardListDto.setBoardId(board.getBoardId());
        boardListDto.setTitle(board.getTitle());
        boardListDto.setMemberId(board.getMember().getMemberId());
        boardListDto.setViewCnt(board.getViewCnt());
        return boardListDto;
    }
}
