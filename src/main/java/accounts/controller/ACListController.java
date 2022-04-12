package accounts.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import accounts.model.ACDao;

@Controller
public class ACListController {
	private final String command = "accounts.ac";
	private String getPage = "mypage";
	
	@Autowired
	private ACDao acdao;
	
	@Autowired
	ServletContext servletContext;
	
	// main > mypage.jsp ��ư, �α��� ����
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(HttpSession session) {
		
		System.out.println("loginInfo:"+session.getAttribute("loginInfo")); // null
		
		if(session.getAttribute("loginInfo") == null) { // �α��� �� �� ����
			session.setAttribute("destination", "redirect:/accounts.ac");
			return "redirect:/loginForm";
		}
		if(session.getAttribute("loginInfo") == "admin") { // ���� �α���
			session.setAttribute("destination", "redirect:/accounts.ac");
			return "redirect:/admin.ac"; // adminpage
		}
		else {// ȸ�� �α��� �� ����
			return getPage;// mypage.jsp
		}
	}
	
}
