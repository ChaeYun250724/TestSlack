package org.mbcboard.apiserver.models.board.service;

import org.mbcboard.apiserver.models.board.domain.Board;
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
import org.mbcboard.apiserver.models.board.repository.BoardJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IBoardServiceImpl implements IBoardService {

    @Autowired
    BoardJpaRepository boardJpaRepository;

    @Override
    public PostBoardRes postBoard(PostBoardReq request) {

        ModelMapper modelMapper = new ModelMapper();
        var postBoard = modelMapper.map(request, Board.class);

        var board = boardJpaRepository.save(postBoard);

        return PostBoardRes.builder()
                .boardDetail(board)
                .build();
    }

    /*@Override
    public GetBoardListRes getBoardList(GetBoardListReq request) {

        var boards = new ArrayList<Board>();

        var result = boardJpaRepository.findAll();

        result.forEach(board -> {
            boards.add(board);
        });

        return GetBoardListRes.builder()
                .boards(boards)
                .build();
    }*/

    @Override
    public GetBoardListRes getBoardList(GetBoardListReq req) {
        var boards = new ArrayList<Board>();

        var pageable = req.getPageable("boardIndex");

        Page<Board> pageResult = boardJpaRepository.searchAll(
                req.getScopes(),
                req.getSearch(),
                pageable
        );

        Long totalElementCnt = pageResult.getTotalElements(); // 전체 게시물
        int totalPageCnt = pageResult.getTotalPages();        // 전체 페이지수
        int pageNum = pageResult.getNumber();                 // 현재 페이지
        int pageSize = pageResult.getSize();                  // 페이지당 item 개수

        boolean pageHasPrevious = pageResult.hasPrevious();       // 이전 페이지 존재 여부
        boolean pageHasNext = pageResult.hasNext();               // 다음 페이지 존재 여부
        boolean pageIsFirst = pageResult.isFirst();               // 첫 페이지 여부
        boolean pageIsLast = pageResult.isLast();                 // 마지막 페이지 여부

        pageResult.forEach(board -> {
            boards.add(board);
        });

        return GetBoardListRes.builder()
                .contents(boards)
                .totalElementCnt(totalElementCnt)
                .totalPageCnt(totalPageCnt)
                .pageNum(pageNum)
                .pageSize(pageSize)
                .pageHasPrevious(pageHasPrevious)
                .pageHasNext(pageHasNext)
                .pageIsFirst(pageIsFirst)
                .pageIsLast(pageIsLast)
                .build();
    }

    @Override
    public GetBoardDetailRes getBoardDetail(GetBoardDetailReq request) {

        var board = boardJpaRepository.findById(request.getBoardIndex())
                .orElseThrow(() -> {
                    throw new RuntimeException();
                });

        return GetBoardDetailRes.builder()
                .detail(board)
                .build();
    }

    @Override
    public void increaseViewCount(Long id) {

        var board = boardJpaRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException();
                });

        board.setViewCount(board.getViewCount() + 1);
    }

    @Override
    public ModifyBoardRes modifyBoard(ModifyBoardReq request) {

        var board = boardJpaRepository.findById(request.getBoardIndex())
                .orElseThrow(() -> {
                    throw new RuntimeException();
                });

        if (request.getTitle() != null)
            board.setTitle(request.getTitle());

        if (request.getContent() != null)
            board.setContent(request.getContent());

        return ModifyBoardRes.builder()
                .modified(board)
                .build();
    }

    @Override
    public DeleteBoardRes deleteBoard(DeleteBoardReq request) {

        var board = boardJpaRepository.findById(request.getBoardIndex())
                .orElseThrow(() -> {
                    throw new RuntimeException();
                });

        board.setDeletedYn("Y");

        return DeleteBoardRes.builder()
                .deleted(board)
                .build();
    }
}
