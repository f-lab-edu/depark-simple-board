package com.example.simpleboard;

import com.example.simpleboard.entity.Board;
import com.example.simpleboard.entity.Member;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.initDb();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void initDb() {
            int cnt = 0;
            for (int i = 1; i <= 5; i++) {
                Member member = Member.builder()
                        .name("user" + i)
                        .email("user" + i + "@gmail.com")
                        .password("1234")
                        .build();
                em.persist(member);

                for (int j = 1; j <= 5; j++) {
                    Board board = Board.builder()
                            .title("글 제목입니다. " + ++cnt)
                            .contents("게시글 내용입니다." + cnt)
                            .member(member)
                            .viewCnt(0)
                            .build();
                    em.persist(board);
                }
            }
        }
    }
}
