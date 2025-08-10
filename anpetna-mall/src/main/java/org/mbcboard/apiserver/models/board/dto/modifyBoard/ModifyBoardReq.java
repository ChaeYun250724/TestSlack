package org.mbcboard.apiserver.models.board.dto.modifyBoard;

import lombok.*;

@Getter
@Setter
@ToString
@Builder @AllArgsConstructor @NoArgsConstructor
public class ModifyBoardReq {

    private Long boardIndex;

    private String title;

    private String content;
}
