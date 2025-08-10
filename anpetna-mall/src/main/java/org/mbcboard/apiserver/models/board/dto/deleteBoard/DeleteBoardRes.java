package org.mbcboard.apiserver.models.board.dto.deleteBoard;

import lombok.*;
import org.mbcboard.apiserver.models.board.domain.Board;

@Getter
@ToString
@Builder @AllArgsConstructor @NoArgsConstructor
public class DeleteBoardRes {

    private Board deleted;
}
