package com.example.simpleboard;

import com.example.simpleboard.entity.Board;
import com.example.simpleboard.repository.BoardRepository;
import com.example.simpleboard.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void 조회수_증가() throws InterruptedException {
        int threadCount = 500;

        // 비동기를 단순하게 처리할 수 있도록 해주는 Java API
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        // 다른 스레드에서 수행 완료될 때까지 대기할 수 있도록 도와주는 API
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    boardService.getBoardDetail(1L);
                } finally {
                    latch.countDown();
                }
            });
        }

        // 다른 스레드에서 수행 작업이 완료될 떄까지 기다린다
        latch.await();

        Board board = boardRepository.findById(1L).orElseThrow();
        assertThat(board.getViewCnt()).isEqualTo(500);
    }
}
