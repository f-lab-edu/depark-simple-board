package com.example.simpleboard.entity;

import com.example.simpleboard.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BOARD")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long boardId;

    @Column(name = "TITLE")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name = "CONTENTS", columnDefinition = "TEXT")
    private String contents;

    @Column(name = "VIEW_CNT")
    private Integer viewCnt;

    @Builder
    public Board(Long boardId, String title, Member member, String contents, Integer viewCnt) {
        this.boardId = boardId;
        this.title = title;
        this.member = member;
        this.contents = contents;
        this.viewCnt = viewCnt;
    }

    public void increaseViewCnt() {
        this.viewCnt++;
    }
}
