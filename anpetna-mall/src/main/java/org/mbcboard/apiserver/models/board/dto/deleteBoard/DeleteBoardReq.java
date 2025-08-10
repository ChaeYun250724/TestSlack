package org.mbcboard.apiserver.models.board.dto.deleteBoard;

import lombok.*;

@Getter
@Setter
@ToString
@Builder @AllArgsConstructor @NoArgsConstructor
public class DeleteBoardReq {

    private Long boardIndex;
}
