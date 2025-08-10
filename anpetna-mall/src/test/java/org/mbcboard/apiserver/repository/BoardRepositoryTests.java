package org.mbcboard.apiserver.repository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.hibernate.cfg.Environment;
import org.junit.jupiter.api.Test;
import org.mbcboard.apiserver.models.board.domain.Board;
import org.mbcboard.apiserver.models.board.repository.BoardJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

@SpringBootTest(properties = {
        "spring.jpa.hibernate.ddl-auto=create"
})
@Log4j2
@ActiveProfiles("test")
public class BoardRepositoryTests {

    @Autowired
    BoardJpaRepository boardJpaRepository;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Test
    void printDdlAuto() {
        System.out.println("spring.jpa.hibernate.ddl-auto = " + ddlAuto);
    }


    @Test
    public void testInsertDummy() {

        // 더미 게시글 생성

        int dummyCount = 200;

        IntStream.rangeClosed(1, dummyCount).forEach(i -> {
            Board board = Board.builder()
                    .title("제목..." + i)
                    .content("내용..." + i)
                    .writerId("user" + (i % 10))
                    .build();

            Board result = boardJpaRepository.save(board);
        });
    }

    @Test
    @Transactional
    public void testInsert() {
        // 게시글 등록 API

        // Input
        // 1. 유저 ID
        // 2. 제목
        // 3. 내용
        // 4. 작성자
        Board board = Board.builder()
                .title("게시글 등록 테스트1")
                .content("게시글 등록 테스트 내용")
                .writerId("test")
                .build();

        Board result = boardJpaRepository.save(board);

        // Output
    }

    @Test
    @Transactional
    public void testSelectOne() {
        // 게시글 상세조회 API

        // Input
        // 1. 유저 ID
        // 2. 게시글 ID
        var boardIndex = 1L;

        var result = boardJpaRepository.findById(boardIndex);

        var board = result.orElseThrow(() -> {
            throw new NoSuchElementException();
        });

        // Output
    }

    @Test
    @Transactional
    public void testUpdate() {
        // 게시글 수정 API

        // Input
        // 1. 유저 ID
        // 2. 게시글 ID
        // 3. 타이틀
        // 4. 내용

        var boardIndex = 1L;
        var title = "게시글 수정 테스트1";
        var content = "게시글 수정 테스트 내용";
        var userId = "test";

        var result = boardJpaRepository.findById(boardIndex);

        var board = result.orElseThrow(() -> {
            throw new NoSuchElementException();
        });

        if (board.getWriterId().equals(userId)) {
            board.setTitle(title);
            board.setContent(content);
        } else {

        }

        // Output
    }

    @Test
    @Transactional
    public void testSelectAll() {

    }

    @Test
    @Transactional
    public void testSoftDelete() {
        // 게시글 삭제 API

        // Input
        // 1. 유저 ID
        // 2. 게시글 ID

        var boardIndex = 1L;
        var userId = "junotest";

        var result = boardJpaRepository.findById(boardIndex);

        var board = result.orElseThrow(() -> {
            throw new NoSuchElementException();
        });

        if (board.getWriterId().equals(userId)) {
            board.setDeletedYn("Y");
        } else {

        }

        // Output
    }
}
