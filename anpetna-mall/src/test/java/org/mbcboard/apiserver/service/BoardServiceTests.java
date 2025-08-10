package org.mbcboard.apiserver.service;

import lombok.extern.log4j.Log4j2;
import org.mbcboard.apiserver.models.board.service.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Log4j2
@ActiveProfiles("test")
public class BoardServiceTests {

    @Autowired
    IBoardService boardService;

}
