package member.controller;
	

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.LoginBean;
import member.model.MemberBean;
import member.model.MemberDao;
	
@Controller
public class MemberFindIdController {
	
	private final String command = "findid.mem";
	private String getPage = "memberFindIdForm2";
	
	@Autowired
	private MemberDao mdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public void doAction(LoginBean logbean, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		
		MemberBean ck = mdao.searchIdByBean(logbean);
		PrintWriter out = response.getWriter();
		// ���Ե� ���̵� ������
		if(ck == null) {
			out.print("<script>alert('��ϵ��� ���� �����Դϴ�.'); history.back(-1);</script>");
			out.close();
		
		}
		else {
			sendEmail(ck, "findpw");
			
			out.print("<script>alert('�̸��Ϸ� ���̵� �߼��Ͽ����ϴ�.'); location.href='loginForm.mem'</script>");
			out.close();
			
		}
		
	}
	
	
	
	public void sendEmail(MemberBean mbean, String div ) {
		// Mail Server ����
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; //���̹� �̿�� smtp.naver.com
		String hostSMTPid = "kwonjun2063";
		String hostSMTPpwd = "kj20632063!!";
		
		// ������ ��� EMail, ����, ����
		String fromEmail = "kwonjun2063@gmail.com";
		String fromName = "Jun Kwon";
		String subject = "";
		String msg = "";
		
		if(div.equals("findpw")) {
			subject = "On_���ͳݰ��� ���̵� �Դϴ�.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += mbean.getAname() + "���� ���̵� �Դϴ�.</h3>";
			msg += "<p> ���̵� : ";
			msg += mbean.getId() + "</p></div>";
		}
		
		// �޴� ��� E-Mail �ּ�
		String mail = mbean.getEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSLOnConnect(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); //���̹� �̿�� 587
			
			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("���Ϲ߼� ���� : " + e);
		}
	}
	 
	
}
