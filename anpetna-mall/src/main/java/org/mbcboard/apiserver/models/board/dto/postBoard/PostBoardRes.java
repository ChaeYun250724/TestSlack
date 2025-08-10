package org.mbcboard.apiserver.models.board.dto.postBoard;

import lombok.*;
import org.mbcboard.apiserver.models.board.domain.Board;

@Getter
@ToString
@Builder @AllArgsConstructor @NoArgsConstructor
public class PostBoardRes {

    private Board boardDetail;
}