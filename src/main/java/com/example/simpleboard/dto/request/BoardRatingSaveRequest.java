package com.example.simpleboard.dto.request;

import lombok.Getter;

@Getter
public class BoardRatingSaveRequest {

    private Long boardId;

    private Long userId;

    private Integer score;
}
