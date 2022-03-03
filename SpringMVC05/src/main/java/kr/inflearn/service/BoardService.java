package kr.inflearn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.inflearn.model.BoardVO;

public interface BoardService {
	public List<BoardVO>getList(); 		// 게시물 리스트 가져오기
	public void register(BoardVO board);  // 게시물 등록
	public BoardVO get(int bno); // 게시물 상세보기
	public void remove(int bno); 		// 게시물 삭제
	public void modify(BoardVO board);  // 게시물 수정하기
	public void count(int bno);         // 조회수 누적
}
