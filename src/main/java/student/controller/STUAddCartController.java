package student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin.model.CoBean;

@Controller
public class STUAddCartController {
	
	private final String command = "addcart.stu";
	private String gotoPage = "redirect:/cartlist.stu";
	private String page = "cartlist.stu" ;
	private String getPage = "redirect:/loginForm.mem";
	
	@RequestMapping(command)
	public String doAction(HttpSession session,
							@RequestParam(value="conum", required=false) String conum) {
		
	
		if(session.getAttribute("loginInfo") == null) {// �α��� ��������
			//session.setAttribute("destination", "�α��� �ϰ� ���ƿ� ��ġ�� url"); => ? ���� �̵��Ұ���?
			//return "�α��� �� ��ġ�� ���� url";
			return getPage;
		}
		else {
			
			ArrayList<Integer> mycart = (ArrayList<Integer>)session.getAttribute("mycart");
			
			if(mycart == null) {
				mycart = new ArrayList<Integer>();
			}
			
			if(conum != null) {
				if(!mycart.contains(Integer.parseInt(conum))) {//īƮ�� ��ٱ��Ͽ� ��⸦ �������� ���� ��ٱ��Ͽ� �ش� ���ǰ� ���ٸ� ���� num�� ����
					mycart.add(Integer.parseInt(conum)); 	
				}
			}
			session.setAttribute("mycart", mycart);

			return gotoPage;
		}
		
	}
	
	
}
