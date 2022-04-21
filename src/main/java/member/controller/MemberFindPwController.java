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
public class MemberFindPwController {
	
	private final String command = "findpw.mem";
	private String getPage = "memberFindPwForm2";
	
	@Autowired
	private MemberDao mdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public void doAction(LoginBean logbean, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("logbean.getId() : " + logbean.getId());
		
		MemberBean ck = mdao.searchId(logbean.getId());
		PrintWriter out = response.getWriter();
		
		// ���Ե� ���̵� ������
		if(mdao.idCheck(logbean.getId()) == null) {
			out.print("<script>alert('��ϵ��� ���� ���̵��Դϴ�.'); history.back(-1);</script>");
			out.close();
		
		}
		
		// ���Ե� �̸����� �ƴϸ�
		else if(!logbean.getEmail().equals(ck.getEmail())) {
			out.print("<script>alert('��ϵ��� ���� �̸����Դϴ�.'); history.back(-1);</script>");
			out.close();
			
			
		} else {
			//��й�ȣ �������
			String pw = "";
			for (int i = 0; i < 12; i++) {
				pw += (char) ((Math.random() * 26) + 97);
			}
			logbean.setPw(pw);
			// ��й�ȣ ����
			mdao.updatePw(logbean);
			
			// ��й�ȣ ���� ���� �߼�
			sendEmail(logbean, "findpw");
			
			out.print("<script>alert('�̸��Ϸ� �ӽ� ��й�ȣ�� �߼��Ͽ����ϴ�.'); location.href='loginForm.mem'</script>");
			out.close();
			
		}
	}
	
	public void sendEmail(LoginBean logbean, String div ) {
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
			subject = "On_���ͳݰ��� �ӽ� ��й�ȣ �Դϴ�.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += logbean.getId() + "���� �ӽ� ��й�ȣ �Դϴ�.</h3>";
			msg += "<p> �ӽ� ��й�ȣ : ";
			msg += logbean.getPw() + "</p>";
			msg += "<p>�ذ������� ������ �� ��й�ȣ�� ������ �ּ���.</p></div>";
		}
		
		// �޴� ��� E-Mail �ּ�
		String mail = logbean.getEmail();
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
