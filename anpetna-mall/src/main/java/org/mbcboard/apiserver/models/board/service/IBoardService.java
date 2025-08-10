package org.mbcboard.apiserver.models.board.service;

import org.mbcboard.apiserver.models.board.dto.deleteBoard.DeleteBoardReq;
import org.mbcboard.apiserver.models.board.dto.deleteBoard.DeleteBoardRes;
import org.mbcboard.apiserver.models.board.dto.getBoardDetail.GetBoardDetailReq;
import org.mbcboard.apiserver.models.board.dto.modifyBoard.ModifyBoardReq;
import org.mbcboard.apiserver.models.board.dto.modifyBoard.ModifyBoardRes;
import org.mbcboard.apiserver.models.board.dto.postBoard.PostBoardReq;
import org.mbcboard.apiserver.models.board.dto.postBoard.PostBoardRes;
import org.mbcboard.apiserver.models.board.dto.getBoardDetail.GetBoardDetailRes;
import org.mbcboard.apiserver.models.board.dto.getBoardList.GetBoardListReq;
import org.mbcboard.apiserver.models.board.dto.getBoardList.GetBoardListRes;

public interface IBoardService {

    // 1. 게시글 등록
    PostBoardRes postBoard(PostBoardReq request);

    // 2. 게시글 목록 조회
    GetBoardListRes getBoardList(GetBoardListReq request);

    // 3. 게시글 상세 조회
    GetBoardDetailRes getBoardDetail(GetBoardDetailReq request);

    // 3+. 조회수 증가
    void increaseViewCount(Long id);

    // 4. 게시글 수정
    ModifyBoardRes modifyBoard(ModifyBoardReq request);

    // 5. 게시글 삭제
    DeleteBoardRes deleteBoard(DeleteBoardReq request);
}
