package kr.inflearn.mapper;


import java.util.List;

import kr.inflearn.model.BoardVO;
//영속계층
public interface BoardMapper {
	public List<BoardVO>getList(); 		// 게시물 리스트 가져오기
	public void insert(BoardVO board);  // 게시물 등록
	public BoardVO read(int bno); 		// 게시물 상세보기
	public void delete(int bno); 		// 게시물 삭제
	public void update(BoardVO board);  // 게시물 수정하기
	public void count(int bno);         // 조회수 누적
	public int selectSeq();
}
