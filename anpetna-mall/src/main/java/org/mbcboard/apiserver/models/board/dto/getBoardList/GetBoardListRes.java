package org.mbcboard.apiserver.models.board.dto.getBoardList;

import lombok.*;
import org.mbcboard.apiserver.models.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@ToString
@Builder @AllArgsConstructor @NoArgsConstructor
public class GetBoardListRes {

    private Long totalElementCnt ;      // 전체 게시물
    private int totalPageCnt ;          // 전체 페이지수
    private int pageNum ;               // 현재 페이지
    private int pageSize ;              // 페이지당 item 개수

    private boolean pageHasPrevious ;   // 이전 페이지 존재 여부
    private boolean pageHasNext ;       // 다음 페이지 존재 여부
    private boolean pageIsFirst ;       // 첫 페이지 여부
    private boolean pageIsLast ;        // 마지막 페이지 여부

    private List<Board> contents;

}
