package student.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import student.model.StuCartBean;

@Controller
public class STUBuyController {
	
	private final String command = "buycos.stu";
	private String getPage = "stushlist";
	//private String gotoPage = "stushlistdetail";
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction(HttpServletRequest request,HttpSession session) {
		  session.removeAttribute("mycart");
	      session.removeAttribute("cartArr");
		
		return getPage;
	}

	
}


/*

	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction(HttpServletRequest request,HttpSession session) {
		
		ArrayList<StuCartBean> cartArr =  (ArrayList<StuCartBean>)session.getAttribute("cartArr");
		
		request.setAttribute("cartArr", cartArr);
		
		int totalprice = 0;
		int totalcount = 0;
		for(StuCartBean cart : cartArr) {
			totalcount += 1;
			totalprice += cart.getCoprice();
		}
		
		request.setAttribute("totalcount",totalcount);
		request.setAttribute("totalprice",totalprice);
		request.setAttribute("cartArr",	cartArr);
		
		return getPage;
	}
	
*/