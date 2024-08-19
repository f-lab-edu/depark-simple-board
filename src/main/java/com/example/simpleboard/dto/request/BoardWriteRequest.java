package com.example.simpleboard.dto.request;

import lombok.Getter;

@Getter
public class BoardWriteRequest {

    private Long userId;

    private String title;

    private String contents;
}
