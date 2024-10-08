package com.example.simpleboard.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(NOT_FOUND, "해당 유저의 정보를 찾을 수 없습니다."),
    BOARD_NOT_FOUND(NOT_FOUND, "게시글을 찾을 수 없습니다.");

    private HttpStatus httpStatus;
    private String message;
}
