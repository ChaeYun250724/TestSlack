package org.mbcboard.apiserver;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Log4j2
@ActiveProfiles("test")
class ApiserverApplicationTests {

    @Test
    void contextLoads() {
    }

}
