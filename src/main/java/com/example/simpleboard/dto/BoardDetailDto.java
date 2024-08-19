package com.example.simpleboard.dto;

import com.example.simpleboard.dto.response.BaseResponseBody;
import com.example.simpleboard.entity.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDetailDto {

    private Long boardId;

    private String title;

    private Long memberId;

    private String contents;

    private Integer viewCnt;

    public static BoardDetailDto of(Board board) {
        BoardDetailDto boardDetailDto = new BoardDetailDto();
        boardDetailDto.setBoardId(board.getBoardId());
        boardDetailDto.setTitle(board.getTitle());
        boardDetailDto.setMemberId(board.getMember().getMemberId());
        boardDetailDto.setContents(board.getContents());
        boardDetailDto.setViewCnt(board.getViewCnt());
        return boardDetailDto;
    }
}
