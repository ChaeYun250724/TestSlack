package org.mbcboard.apiserver.models.board.dto.getBoardDetail;

import lombok.*;

@Getter
@Setter
@ToString
@Builder @AllArgsConstructor @NoArgsConstructor
public class GetBoardDetailReq {

    private Long boardIndex;
}
