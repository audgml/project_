package course.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import course.model.COSBean;
import course.model.COSDao;
import teachers.model.TEBean;
import utility.COSListPaging;
import utility.Paging;

@Controller
public class COSListController {
	
	private final String command = "/list.cos";
	private String getPage = "coslist";
	
	@Autowired
	private COSDao cosdao;

	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			@RequestParam(value="cosubject", required=false) String cosubject,
			HttpServletRequest request) {
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		if(cosubject != null) {
	         if(cosubject.equals("")) {
	            map.put("cosubject", null);
	         }
	         else {
	            map.put("cosubject", cosubject);
	         }
	      }   
	      else {
	         map.put("cosubject", cosubject);
	      }
	
		int totalCount=cosdao.totalCount(map);
		System.out.println("totalCount:"+totalCount);
		
		String url ;
		if(cosubject != null) {
			url = request.getContextPath()+command+"?cosubject="+cosubject;
		}
		else {
			url = request.getContextPath()+command;
		}
		
		COSListPaging pageInfo=new COSListPaging(pageNumber, null, totalCount, url, whatColumn, keyword);
		  
		List<COSBean> list = cosdao.getCOSList(pageInfo, map);
		List<String> subArr = cosdao.getSubject();
		COSBean comp = list.get(0);//KJH : ����,���� �� ��ȣ �ϳ��� �Ѱܾ��ϴϱ� ����������

		
		ModelAndView mav=new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("comp",comp);
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("totalCount",totalCount);
		mav.addObject("subArr",subArr);
		mav.addObject("cosubject",cosubject);
		mav.setViewName(getPage);
		return mav;
	
	}

	
}
