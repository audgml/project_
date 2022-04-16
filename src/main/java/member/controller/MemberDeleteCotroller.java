package member.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import admin.model.TeacherBean;
import board.Csmodel.boardCsBean;
import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberDeleteCotroller {
	private final String command = "delete.mem";
	private String getPage = "memberDelete";
	private String gotoPage = "redirect:/home.us";

	@Autowired
	private MemberDao mdao;
	
	@RequestMapping(value =command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		
		MemberBean mbean = (MemberBean)session.getAttribute("loginInfo");
		
		return getPage;
	}

	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doAction( MemberBean mb,
							HttpSession session,
							RedirectAttributes rttr) {

		MemberBean mbean = (MemberBean)session.getAttribute("loginInfo");

		String loginpw = mbean.getPw();
		String dbpw = mb.getPw();

		if(!(loginpw.equals(dbpw))) {
			rttr.addFlashAttribute("msg", false);

			return getPage;
		}

		mdao.deleteMember(mb);
		session.invalidate();

		return gotoPage;
	}
}
