package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin.model.CoBean;
import member.model.MemberBean;
import student.model.STUOrderDeDao;

@Controller
public class STUAddCartController {
	
	private final String command = "addcart.stu";
	private String gotoPage = "redirect:/cartlist.stu";
	private String getPage = "redirect:/loginForm.mem";
	
	@Autowired
	private STUOrderDeDao stuoddDao;
	
	@RequestMapping(command)
	public String doAction(HttpSession session,
							HttpServletResponse response,
							@RequestParam(value="conum", required=false) String conum) {
		
		response.setContentType("text/html;charset=UTF-8");
		
		if(session.getAttribute("loginInfo") == null) {// �α��� ��������
			//session.setAttribute("destination", "�α��� �ϰ� ���ƿ� ��ġ�� url"); => ? ���� �̵��Ұ���?
			//return "�α��� �� ��ġ�� ���� url";
			session.setAttribute("destination", "redirect:/detail.cos?conum=" + conum);
			return getPage;
		}
		else {
			
			MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo"); 
			
			List<Integer> orderArr = stuoddDao.getOrderDetailConums(loginInfo.getId());
			if(orderArr.contains(Integer.parseInt(conum))) {
				
				try {
					PrintWriter out = response.getWriter();
					out.print("<script>alert('�̹� ������ �����Դϴ�'); history.back(-1);</script>");
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			
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
