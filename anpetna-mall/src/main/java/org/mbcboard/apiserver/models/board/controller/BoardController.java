package org.mbcboard.apiserver.models.board.controller;

import org.mbcboard.apiserver.core.ApiResult;
import org.mbcboard.apiserver.models.board.dto.deleteBoard.DeleteBoardReq;
import org.mbcboard.apiserver.models.board.dto.deleteBoard.DeleteBoardRes;
import org.mbcboard.apiserver.models.board.dto.getBoardDetail.GetBoardDetailReq;
import org.mbcboard.apiserver.models.board.dto.getBoardList.GetBoardListReq;
import org.mbcboard.apiserver.models.board.dto.getBoardList.GetBoardListRes;
import org.mbcboard.apiserver.models.board.dto.modifyBoard.ModifyBoardReq;
import org.mbcboard.apiserver.models.board.dto.modifyBoard.ModifyBoardRes;
import org.mbcboard.apiserver.models.board.dto.postBoard.PostBoardReq;
import org.mbcboard.apiserver.models.board.dto.getBoardDetail.GetBoardDetailRes;
import org.mbcboard.apiserver.models.board.dto.postBoard.PostBoardRes;
import org.mbcboard.apiserver.models.board.service.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    IBoardService boardService;

    /**
     * [POST]
     * 게시글 등록
     */
    @PostMapping()
    public ApiResult<PostBoardRes> postBoard(
            @RequestBody PostBoardReq reqBody) {

        var result = boardService.postBoard(reqBody);
        return new ApiResult<>(result);
    }

    /**
     * [GET]
     * 게시글 목록 조회
     */
    @GetMapping()
    @ResponseBody
    public ApiResult<GetBoardListRes> getBoardList(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "scope", required = false) String scope,
            @RequestParam(name = "search", required = false) String search) {

        if (page == null)
            page = 1;

        var reqBody = GetBoardListReq.builder()
                .page(page)
                .scope(scope)
                .search(search)
                .build();

        var result = boardService.getBoardList(reqBody);
        return new ApiResult<>(result);
    }

    /**
     * [GET]
     * 게시글 상세 조회
     * @param boardIndex
     * @return
     */
    @GetMapping("/{boardIndex}")
    @ResponseBody
    @Transactional
    public ApiResult<GetBoardDetailRes> getBoardDetail(
            @PathVariable("boardIndex") Long boardIndex) {

        var request = GetBoardDetailReq.builder()
                .boardIndex(boardIndex)
                .build();

        boardService.increaseViewCount(boardIndex);
        var result = boardService.getBoardDetail(request);

        return new ApiResult<>(result);
    }

    /**
     * [PUT]
     * 게시글 수정
     * 192.168.0.171:6805/api/board/boards
     * {
     *     ""
     * }
     * @param request
     * @return
     */
    @PutMapping()
    @ResponseBody
    @Transactional
    public ApiResult<ModifyBoardRes> modifyBoard(
            @RequestBody ModifyBoardReq request) {
        var result = boardService.modifyBoard(request);
        return new ApiResult<>(result);
    }

    /**
     * [DELETE]
     * 게시글 삭제
     * 192.168.0.171:6805/api/board/boards/{boardIndex}
     * @param boardIndex
     */
    @DeleteMapping("/{boardIndex}")
    @ResponseBody
    @Transactional
    public ApiResult<DeleteBoardRes> deleteBoard(
            @PathVariable("boardIndex")
            Long boardIndex) {

        var request = DeleteBoardReq.builder()
                .boardIndex(boardIndex)
                .build();

        var result = boardService.deleteBoard(request);

        return new ApiResult<>(result);
    }

}
