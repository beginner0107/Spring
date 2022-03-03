package kr.inflearn.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.mapper.BoardMapper;
import kr.inflearn.model.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper; // DI(의존성 주입)

	@Override
	public List<BoardVO> getList() {
		List<BoardVO> boardList = mapper.getList();
		return boardList;
	}

	@Override
	public void register(BoardVO board) {
		mapper.insert(board);
	}

	@Override
	public BoardVO get(int bno) {
		BoardVO board = null;
		board = mapper.read(bno);
		return board;
	}

	@Override
	public void remove(int bno) {
		mapper.delete(bno);
	}

	@Override
	public void modify(BoardVO board) {
		mapper.update(board);
	}

	@Override
	public void count(int bno) {
		mapper.count(bno);
	}

}
