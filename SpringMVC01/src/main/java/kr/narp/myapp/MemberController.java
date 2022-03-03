package kr.narp.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;
@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) { //HttpServletRequest == Model
		List<MemberVO>list=dao.memberList();
		// 객체 바인딩
		model.addAttribute("list", list);
		return "memberList";
	}
	@RequestMapping("/memberRegister.do")
	public String memberRegister() {
		return "memberRegister";
	}
	@RequestMapping("/memberContent.do")
	public String memberContent(Model model, int num) {
		MemberVO vo = dao.memberContent(num);
		model.addAttribute("vo", vo);
		return "memberContent";
	}
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) {
		// 파라메터 수집(VO)
		// 인코딩(한글 깨지는 부분)
		int cnt = dao.memberInsert(vo);
		return "redirect:/memberList.do";
	}
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo) {
		int cnt = dao.memberUpdate(vo);
		return "redirect:/memberList.do";
	}
	@RequestMapping("/memberDelete.do")
	public String memberDelete(@RequestParam ("num") int num) {
		int cnt = dao.memberDelete(num);
		return "redirect:/memberList.do";
	}
}
