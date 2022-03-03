package kr.inflearn.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.inflearn.model.MemberVO;
import kr.inflearn.service.MemberService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value={"/list.do", "/"})
	public String memberList(Model model) {
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list", list);
		return "/member/memberList";
	}
	
	@RequestMapping("/register.do")
	public String memberRegister(Model model) {
		return "/member/memberRegister";
	}
	@RequestMapping("/login.do")
	public String memberLogin(HttpServletRequest request,@RequestParam("user_id") String id, @RequestParam("password") String pass) {
		log.info("id : {}, password : {}", id, pass);
		String user_name = memberService.memberLogin(id, pass);
		HttpSession session = request.getSession();
		if(user_name!=null&&!"".equals(user_name)) {
			session.setAttribute("userId", id);
			session.setAttribute("userName", user_name);
		}else {
			session.setAttribute("userId", "");
			session.setAttribute("userName", "");
			session.setAttribute("msg", "사용자 정보가 올바르지 않습니다.");
		}
		return "redirect:/member/list.do";
	}
	@RequestMapping("/logout.do")
	public String memberLogout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/member/list.do";
	}
	@RequestMapping("/delete.do")
	public String memberDelete(int num, HttpServletRequest request, String filename) {
		log.info("num : {}, filename : {}", num, filename);
		try {
			String UPLOAD_DIR = "file_repo";
			String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR; // 물리적인 파일의 경로
			memberService.memberDelete(num, filename, uploadPath);
			request.getSession().invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/member/list.do";
	}
	@RequestMapping("/insert.do")
	public String memberInsert(MemberVO member, String mode) {
		log.info("MemberVO : {}, Mode : {}", member, mode);
		memberService.memberInsert(member, mode);
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("/memberDbcheck.do")
	@ResponseBody
	public String memberDbcheck(String id, HttpServletResponse response) throws IOException {
		log.info("ID : {}", id);
		String dbDouble = memberService.memberDbcheck(id);
		log.info("dbDouble : {}", dbDouble);
		if (dbDouble!=null) {
			dbDouble = "YES";
		}else {
			dbDouble = "NO";
		}
		return dbDouble;
	}
	@RequestMapping("/memberContent.do")
	public String memberContent(Model model, int num) {
		MemberVO vo = memberService.memberContent(num);
		model.addAttribute("vo", vo);
		return "/member/memberContent";
	}
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO member, String mode) {
		memberService.memberUpdate(member, mode);
		log.info("MemberVO : {}, Mode : {}", member, mode);
		return "redirect:/member/list.do";
	}
}
