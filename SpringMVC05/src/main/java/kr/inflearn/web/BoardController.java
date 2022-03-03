package kr.inflearn.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mysql.jdbc.StringUtils;

import kr.inflearn.model.BoardVO;
import kr.inflearn.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board")
@Slf4j
@Controller
public class BoardController {
	@Autowired
	private BoardService service;

	@RequestMapping("/list.do")
	public String boardList(Model model) {
		List<BoardVO> list = service.getList();
		model.addAttribute("list", list);
		return "board/boardList";
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
//	@GetMapping(); 4.3version 이상
	public String registerGET() {
		return "board/register"; // register.jsp(게시물 등록화면)
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
//	@PostMapping(); 4.3version 이상
	public String registerPOST(BoardVO board) { // 게시물 등록
		service.register(board);
		return "redirect:/board/list.do"; // register.jsp(게시물 등록화면)
	}

	@RequestMapping("/get.do")
	public String get(@RequestParam("bno") int bno, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		// 저장된 쿠키 불러오기
	     Cookie cookies[] = request.getCookies();
	     Map<String, String> mapCookie = new HashMap<>();
	    if(request.getCookies() != null){
	      for (int i = 0; i < cookies.length; i++) {
	        Cookie obj = cookies[i];
	        mapCookie.put(obj.getName(),obj.getValue());
	      }
	    }

	    // 저장된 쿠키중에 read_count 만 불러오기
	     String cookie_read_count = (String) mapCookie.get("read_count");
	     // 저장될 새로운 쿠키값 생성
	    String new_cookie_read_count = "|" + bno;

	    // 저장된 쿠키에 새로운 쿠키값이 존재하는 지 검사
	     if ( StringUtils.indexOfIgnoreCase(cookie_read_count, new_cookie_read_count) == -1 ) {
	          // 없을 경우 쿠키 생성
	          Cookie cookie = new Cookie("read_count", cookie_read_count + new_cookie_read_count);
	          //cookie.setMaxAge(1000); // 초단위
	          response.addCookie(cookie);

	          // 조회수 업데이트
	          service.count(bno);
	     }

		
		BoardVO board = service.get(bno);
		log.info("boardVO : {}", board);
		model.addAttribute("board", board);
		return "board/get";
	}

	@RequestMapping("/remove.do")
	public String remove(int bno) {
		service.remove(bno);
		return "redirect:/board/list.do";
	}

	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("bno") int bno, Model model) {
		BoardVO board = service.get(bno);
		model.addAttribute("board", board);
		return "board/modify";
	}

	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board) {
		service.modify(board);
		return "redirect:/board/list.do";
	}
}
/*
 * /list.do ---> GET ----->list(); /register.do ---> GET ----> register();
 * /read.do ---> GET ---> read(); /remove.do ---> GET ---> remove(); /modify.do
 * ---> POST ---> modify();
 */