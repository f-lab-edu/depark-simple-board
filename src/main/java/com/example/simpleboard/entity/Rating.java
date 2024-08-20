package com.example.simpleboard.entity;

import com.example.simpleboard.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RATING")
@NoArgsConstructor
public class Rating extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RATING_ID")
    private Long ratingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private Integer score;

    @Builder
    public Rating(Board board, Member member, Integer score) {
        this.board = board;
        this.member = member;
        this.score = score;
    }

    public void changeScore(Integer score) {
        this.score = score;
    }

}
