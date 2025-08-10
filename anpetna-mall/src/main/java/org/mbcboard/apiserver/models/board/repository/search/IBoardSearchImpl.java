package org.mbcboard.apiserver.models.board.repository.search;

import com.querydsl.core.BooleanBuilder;
import org.mbcboard.apiserver.models.board.domain.Board;
import org.mbcboard.apiserver.models.board.domain.QBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class IBoardSearchImpl extends QuerydslRepositorySupport
        implements IBoardSearch {

    public IBoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {

        var board = QBoard.board;
        var query = from(board);

        // 검색어가 있을 경우에만 search query 추가
        if (keyword != null && keyword.isEmpty() == false) {

            // 타입 지정 안한경우 전체검색
            if (types == null || types.length == 0)
                types = new String[] { "t", "c", "w" }; // 전체 검색

            var booleanBuilder = new BooleanBuilder();
            for (String type : types) {

                switch (type) {
                    case "t" -> { // title 필터
                        booleanBuilder.or(board.title.contains(keyword));
                    }
                    case "c" -> { // content 필터
                        booleanBuilder.or(board.content.contains(keyword));
                    }
                    case "w" -> { // writer 필터
                        booleanBuilder.or(board.writerId.contains(keyword));
                    }
                }
            }
            query.where(booleanBuilder);
        }

        query.where(board.boardIndex.gt(0L));

        this.getQuerydsl().applyPagination(pageable, query);

        var boards = query.fetch();

        Long count = query.fetchCount();

        return new PageImpl<>(boards, pageable, count);
    }
}
