package user.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.model.SubBean;
import admin.model.SubDao;

@Controller
public class USTopTab {

	
	/*
	 * <<<<�̰� �Ⱦ��µ� ���� ����>>>>
	 * 
	 * //@Autowired //private SubDao subdao;
	 * 
	 * //ushome -> ��� ���� �� ������ �� subject.us ��û -> ussubject-main.jsp�� �̵� private
	 * final String command1 = "subject-main.us"; ����� ȭ�� - ���� - ���� private String
	 * getPage1 = "ussubject-main";
	 * 
	 * @RequestMapping(value=command1,method=RequestMethod.GET) public String
	 * doAction1(HttpServletRequest request) { //List<SubBean> sublist =
	 * subdao.subjectAll(); //request.setAttribute("sublist", sublist); return
	 * getPage1; }
	 * 
	 * private final String command2 = "teacher.us"; private String getPage2 =
	 * "usteacher";
	 * 
	 * @RequestMapping(value=command2,method=RequestMethod.GET) public String
	 * doAction2(HttpServletRequest request) {
	 * 
	 * return getPage2; }
	 * 
	 * private final String command3 = "subject-main-java.us"; ����� ȭ�� - ���� - JAVA
	 * private String getPage3 = "ussubject-java";
	 * 
	 * @RequestMapping(value=command3,method=RequestMethod.GET) public String
	 * doAction3(HttpServletRequest request) { //List<SubBean> sublist =
	 * subdao.subjectAll(); //request.setAttribute("sublist", sublist); return
	 * getPage3; }
	 * 
	 * private final String command4 = "subject-main-mypage.us"; ����� ȭ�� - ����������
	 * private String getPage4 = "usmypage";
	 * 
	 * @RequestMapping(value=command4,method=RequestMethod.GET) public String
	 * doAction4(HttpServletRequest request) { //List<SubBean> sublist =
	 * subdao.subjectAll(); //request.setAttribute("sublist", sublist); return
	 * getPage4;
	 * 
	 * 
	 * 
	 * }
	 */
}
