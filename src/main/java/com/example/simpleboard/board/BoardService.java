package com.example.simpleboard.board;

import com.example.simpleboard.dto.request.BoardWriteRequest;
import com.example.simpleboard.entity.Board;
import com.example.simpleboard.entity.Member;
import com.example.simpleboard.exception.CustomException;
import com.example.simpleboard.exception.ErrorCode;
import com.example.simpleboard.repository.BoardRepository;
import com.example.simpleboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void saveBoard(BoardWriteRequest boardWriteRequest) {
        Member member = memberRepository.findById(boardWriteRequest.getUserId())
                                        .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Board board = Board.builder()
                        .title(boardWriteRequest.getTitle())
                        .contents(boardWriteRequest.getContents())
                        .viewCnt(0)
                        .member(member)
                        .build();

        boardRepository.save(board);
    }
}
