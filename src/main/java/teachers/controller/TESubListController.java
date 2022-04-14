package teachers.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import course.model.COSBean;
import course.model.COSDao;
import teachers.model.TEBean;
import teachers.model.TEDao;
import utility.Paging;


@Controller
public class TESubListController {//4/14 JH - teacherlist.jsp ���� �������� ��ư -> sublist.te ��û -> teachersublist.jsp �̵�

/*
 	@Autowired
	private TEDao tedao;
	
	private final String command = "/sublist.te";
	private String getPage = "teachersublist";

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(
			@RequestParam(value = "tnum", required = true) String tnum,
			@RequestParam(value = "tname", required = true) String tname,
			Model model) {
	
			TEBean bean = tedao.getTEList(tnum);
			model.addAttribute("bean", bean);

			return getPage;
	}
*/

	private final String command = "/sublist.te";
	private String getPage = "teachersublist";
	
	@Autowired
	private COSDao cosdao;

	@RequestMapping(value=command)
	public ModelAndView doAction( /* ��� ������ ��(teacherlist.jsp)���� ��ư ������ tname �ѱ� */
			@RequestParam(value = "tname", required = true) String tname,
			HttpServletRequest request) {
		
		List<COSBean> list = cosdao.getTESubList(tname); /* TEDao -> teachers.xml */
	 
		ModelAndView mav=new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName(getPage);
		return mav;
	
	}
}
