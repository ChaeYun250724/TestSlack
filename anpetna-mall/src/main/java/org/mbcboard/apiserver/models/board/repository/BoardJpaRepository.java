package org.mbcboard.apiserver.models.board.repository;

import org.mbcboard.apiserver.models.board.domain.Board;
import org.mbcboard.apiserver.models.board.repository.search.IBoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<Board, Long>, IBoardSearch {

    // Jpa Repository 에서 CRUD 제공
    
    // 커스텀 Query 추가시 Interface 구현후 상속받으면 됨
}
