package co.kgggy.board.service;

import java.util.List;

import co.kgggy.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList();
	BoardVO boardSelect(BoardVO vo);
	int boardWrite(BoardVO vo);
	int boardDelete(BoardVO vo);
	
	
}
