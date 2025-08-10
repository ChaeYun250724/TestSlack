package org.mbcboard.apiserver.models.board.dto.postBoard;

import lombok.*;
import lombok.extern.log4j.Log4j2;


@Getter
@Setter
@ToString
@Builder @AllArgsConstructor @NoArgsConstructor
public class PostBoardReq {
    private String title;
    private String content;
    private String writerId;
}
