package com.example.simpleboard.repository;

import com.example.simpleboard.entity.Board;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Board> findById(Long id);
}
