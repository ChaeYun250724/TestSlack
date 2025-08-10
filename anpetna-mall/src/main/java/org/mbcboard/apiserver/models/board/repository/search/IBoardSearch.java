package org.mbcboard.apiserver.models.board.repository.search;

import org.mbcboard.apiserver.models.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBoardSearch {

    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);
}
