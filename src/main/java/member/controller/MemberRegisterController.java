package member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import admin.model.TeacherDao;
import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberRegisterController {
	private final String command = "register.mem";
	private final String getPage = "memberRegisterForm";
	private String gotoPage="redirect:/loginForm.mem";//�씠遺�遺� 怨좎퀜�빞�븷�벏..?.
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction() { //GET諛⑹떇

		
		return getPage;
	}

	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("membean") @Valid MemberBean membean,BindingResult result) {
								//POST諛⑹떇
		
		membean.setAddr(membean.getAddr_num()+"|"+membean.getAddr_first()+"|"+membean.getAddr_last());
		
		ModelAndView mav = new ModelAndView();
		
		int cnt = memberDao.insertMember(membean);
		
		mav.setViewName(gotoPage);
		return mav;

	}
}