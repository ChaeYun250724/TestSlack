package org.mbcboard.apiserver.models.board.dto.getBoardDetail;

import lombok.*;
import org.mbcboard.apiserver.models.board.domain.Board;

@Getter
@ToString
@Builder @AllArgsConstructor @NoArgsConstructor
public class GetBoardDetailRes {
    private Board detail;
}
