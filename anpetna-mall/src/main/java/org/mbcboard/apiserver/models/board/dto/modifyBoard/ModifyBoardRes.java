package org.mbcboard.apiserver.models.board.dto.modifyBoard;

import lombok.*;
import org.mbcboard.apiserver.models.board.domain.Board;

@Getter
@ToString
@Builder @AllArgsConstructor @NoArgsConstructor
public class ModifyBoardRes {

    private Board modified;
}
