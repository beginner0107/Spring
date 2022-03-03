package kr.inflearn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.inflearn.model.BoardVO;
import kr.inflearn.service.BoardService;
import lombok.Getter;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list.do")
	public String boardList(Model model) {
		List<BoardVO>list = service.getList();
		model.addAttribute("list", list);
		return "boardList";
	}
	@RequestMapping(value="/register.do", method=RequestMethod.GET)
//	@GetMapping(); 4.3version 이상
	public String registerGET() {
		return "register"; //register.jsp(게시물 등록화면)
	}	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
//	@PostMapping(); 4.3version 이상
	public String registerPOST(BoardVO board) { //게시물 등록
		service.register(board);
		return "redirect:/list.do"; //register.jsp(게시물 등록화면)
	}	
	@RequestMapping("/get.do")
	public String get(@RequestParam("bno") int bno, Model model) {
		BoardVO board = service.get(bno, "get");
		model.addAttribute("board", board);
		return "get";
	}
	
	@RequestMapping("/remove.do")
	public String remove(int bno) {
		service.remove(bno);
		return "redirect:/list.do";
	}
	@RequestMapping(value="/modify.do", method=RequestMethod.GET)
	public String modifyGET(@RequestParam("bno") int bno, Model model) {
		BoardVO board = service.get(bno, "modify");
		model.addAttribute("board", board);
		return "modify";
	}
	@RequestMapping(value="/modify.do", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board) {
		service.modify(board);
		return "redirect:/list.do";
	}
}
/*
 /list.do ---> GET ----->list();
 /register.do ---> GET ----> register();
 /read.do ---> GET ---> read();
 /remove.do ---> GET ---> remove();
 /modify.do ---> POST ---> modify();
*/