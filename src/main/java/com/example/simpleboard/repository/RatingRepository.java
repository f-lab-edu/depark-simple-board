package com.example.simpleboard.repository;

import com.example.simpleboard.entity.Board;
import com.example.simpleboard.entity.Member;
import com.example.simpleboard.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    Optional<Rating> findByBoardAndMember(Board board, Member member);

    @Query(value = "SELECT AVG(r.score) FROM Rating r WHERE r.board = :board GROUP BY r.board")
    Float findAvgScoreGroupByBoard(Board board);
}
