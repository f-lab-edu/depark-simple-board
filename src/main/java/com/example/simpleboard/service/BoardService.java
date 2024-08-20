package com.example.simpleboard.service;

import com.example.simpleboard.dto.request.BoardWriteRequest;
import com.example.simpleboard.entity.Board;
import com.example.simpleboard.entity.Member;
import com.example.simpleboard.exception.CustomException;
import com.example.simpleboard.exception.ErrorCode;
import com.example.simpleboard.repository.BoardRepository;
import com.example.simpleboard.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
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

    @Transactional
    public Board getBoardDetail(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
        board.increaseViewCnt();
        return board;
    }

    @Transactional
    public Page<Board> getBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
