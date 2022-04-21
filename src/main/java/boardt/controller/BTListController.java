package boardt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boardt.model.BTBean;
import boardt.model.BTDao;
import utility.COSListPaging;

@Controller
public class BTListController {

	@Autowired
	private BTDao btdao;
	
	//.bd��û
	private final String command="/list.bt";
	private String getPage="btlist";
	
	@RequestMapping(value=command)
	public ModelAndView doAction(
			@RequestParam(value="pageNumber",required=false) String pageNumber,
			@RequestParam(value="subject",required=false) String subject,
			HttpServletRequest request,
			BTBean btbean,BindingResult result){
			System.out.println("���~~>>" + subject);
			
			//���� �������� �����ؼ� ������ ,�� ����Ǿ��ִٸ� btbean.getSubject().split(",") �� ���� String[] (�������� �̸�) ���� �迭�� �޾Ƽ� �� ���� �־�
			//contains �Լ��� ���� �߰��� ,�� �����־ ã�Ƴ��� ���ԵǾ��ִٰ� �� �� �־�
			//null �Ǵ� "" ������ �Ѿ���� ���� ��ü��ȸ�� ���� �ʿ�
			Map<String, String> map = new HashMap<String, String>();
			map.put("subject",btbean.getSubject());
			
			String url;
	         if(subject != null) {
	            String[] subArr = subject.split(","); //split�Լ��� �������� ���ڿ��� �ش� ���ڰ� ������ �׳� �迭 1��¥�� ���� ��
	            //subArr ��ü�� subject �״�� ��
	   
	            url = request.getContextPath() + command + "?subject=" + subArr[0];
	            for(int i=0; i<subArr.length-1; i++) {
	               url += "&subject=" + subArr[i+1];
	            }
	         }
	         else {            
	            url = request.getContextPath() + command; // ex//list.bd
	         }
	         
			
			COSListPaging pageInfo = new COSListPaging(pageNumber,null,totalCount,url,null,null);//üũ�ڽ��� �õ�
			List<BTBean> BTList = btdao.getBoardList(pageInfo,map);
			
		
			ModelAndView mav = new ModelAndView();
//�ڡ�		List<BTBean> BTList = btdao.getBoardList(pageInfo);
			//List<BTBean> BTList = btdao.getBoardList(pageInfo,map);//Ű���� �˻��� �� �õ� - ���� ã������ �˻� �ܾ map�� �� �����ϱ� map�� ���..
			List<String> sub = btdao.getSubList();//���� ��ȸ
			List<BTBean> answer = btdao.getAnswer();
			mav.addObject("BTList", BTList);
			mav.addObject("totalCount", totalCount);
			mav.addObject("pageInfo", pageInfo);
			mav.addObject("Subjects", sub);
			mav.addObject("Answer", answer);
			mav.addObject("subject", subject);
			
			mav.setViewName(getPage); 
			
			return mav; // /WEB-INF/board/list.jsp
	}
	
	
}
