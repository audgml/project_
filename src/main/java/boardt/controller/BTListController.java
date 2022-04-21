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
import utility.BTPaging;
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
			//@RequestParam(value="whatColumn",required=false) String whatColumn, 
			//@RequestParam(value="keyword",required=false) String keyword,
			//@RequestParam Map map, Model model,
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
			
			if(subject != null) {
				if(subject.equals("")) {
					map.put("subject", null);
				}
				else {
					map.put("subject", subject);
				}
			}
			else {
				map.put("subject", subject);
			}
			
			int totalCount = btdao.getTotalCount(map);
			
			String url;
			if(subject != null) {
				String[] subArr = subject.split(",");
	
				url = request.getContextPath() + command + "?subject=" + subArr[0];
				for(int i=0; i<subArr.length-1; i++) {
					url += "&subject=" + subArr[i+1];
				}
			}
			else {				
				url = request.getContextPath() + command; // ex//list.bd
			}
			//(pageNumber,null,totalCount,url,whatColumn,keyword);Ű���� �˻��� �� �õ�
			//pageNumber,pageSize,totalCount,url,whatColumn,keyword);Į��
			
			COSListPaging pageInfo = new COSListPaging(pageNumber,null,totalCount,url,null,null);//üũ�ڽ��� �õ�
			List<BTBean> BTList = btdao.getBoardList(pageInfo,map);
			
			//Map<String, String> map = new HashMap<String, String>(); //Ű���� �˻��� �� �õ� 
			//map.put("whatColumn", whatColumn); //Ű���� �˻��� �� �õ� 
			//map.put("keyword", "%"+keyword+"%"); //Ű���� �˻��� �� �õ�
//�ڡ�		int totalCount = btdao.getTotalCount(); // controller -> Dao -> xml -> Dao -> controller
			//int totalCount = btdao.getTotalCount(map); //Ű���� �˻��� �� �õ� ( controller -> Dao -> xml -> Dao -> controller )
			//�ּ�â�� ex ���̱�� ex�� ��������.. ������Ʈ��/com/spring/ex�ΰ���.
		
		
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
