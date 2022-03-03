package kr.narp.myapp1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.bit.mapper.MemberMapper;
import kr.bit.model.MemberVO;
@Controller
public class MemberController {
	@Autowired
//	private MemberDAO dao; // DI
	private MemberMapper memberMapper;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) { //HttpServletRequest == Model
		List<MemberVO>list=memberMapper.memberList();
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
		MemberVO vo = memberMapper.memberContent(num);
		model.addAttribute("vo", vo);
		return "memberContent";
	}
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) {
		// 파라메터 수집(VO)
		// 인코딩(한글 깨지는 부분)
		int cnt = memberMapper.memberInsert(vo);
		return "redirect:/memberList.do";
	}
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo) {
		int cnt = memberMapper.memberUpdate(vo);
		return "redirect:/memberList.do";
	}
	@RequestMapping("/memberDelete.do")
	public String memberDelete(@RequestParam ("num") int num) {
		int cnt = memberMapper.memberDelete(num);
		return "redirect:/memberList.do";
	}
	// 바로 클라이언트에게 응답을 하겠다는 뜻 
	@RequestMapping("/memberAjaxList.do")
	public @ResponseBody List<MemberVO> memberAjaxList() {
		// 원래는 JSP로 가지만 여기서 응답을 $.ajax()로 callback함수로 Json으로
		List<MemberVO>list=memberMapper.memberList();
		return list; // Object -> JSON : @ResponseBody -> API - (jackson-databind, jackson-mapper-asl) API
	}
	
	@RequestMapping("/form.do")
	public String form() {
		return "uploadForm";
	}
}
