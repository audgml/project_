package admin.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import admin.model.CoBean;
import admin.model.CoDao;
import admin.model.SubBean;
import admin.model.SubDao;
import admin.model.TeacherBean;
import admin.model.TeacherDao;

@Controller
public class ADCoInsertController {
	private final String command = "coinsert.ad";
	private String getPage = "coinsertForm";
	private String gotoPage = "redirect:/colist.ad";
	//private String gotoPage2 = "redirect:/list.cos";
			
	@Inject
	private SubDao subdao;
	
	@Inject
	@Qualifier("myCoDao")
	private CoDao codao;
	
	@Inject
	private TeacherDao tdao;
	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(HttpServletRequest request) {
		
		//������ ���� ��������
		List<TeacherBean> telist = new ArrayList<TeacherBean>();
		telist = tdao.selectTeacher();
		request.setAttribute("telist", telist);
		
		List<SubBean> sublist = subdao.subjectAll();
		request.setAttribute("sublist", sublist);
		
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(@Valid CoBean cobean, BindingResult result,HttpServletRequest request) {

		
		ModelAndView mav = new ModelAndView();
		
		//��¥
		Timestamp date =  new Timestamp(System.currentTimeMillis());
		cobean.setCoupload_date(date);
		
		//�̹���, ����
		String uploadPath = servletContext.getRealPath("/resources/images");
		
		//��ȿ���˻� ����
		if(result.hasErrors()) {
			System.out.println("���� insert ��ȿ������");
			mav.setViewName(getPage);
			return mav;
		}
		
		MultipartFile upimage = cobean.getUpimage();
		MultipartFile upvideo = cobean.getUpvideo();
		
		UUID uuid = UUID.randomUUID();
		String imageName = uuid + "-" + upimage.getOriginalFilename();
		String videoName = uuid + "-" + upvideo.getOriginalFilename();
		
		cobean.setCoimage(imageName);
		cobean.setCovideo(videoName);
		
		int cnt = codao.insertCourses(cobean);
		if(cnt > 0) {
			 File imagef = new File(uploadPath,imageName);
			 File videof = new File(uploadPath,videoName);
			 
			 try {
				 upimage.transferTo(imagef);
				 upvideo.transferTo(videof);
				 
			} catch (IllegalStateException e) {
				System.out.println("Courses ���� ����1");
			} catch (IOException e) {
				System.out.println("Courses ���� ����2");
			}
			 System.out.println("���� insert ����");
			 mav.setViewName(gotoPage);
			 //mav.setViewName(gotoPage2);
		
		} //cnt>0
		
		
		 else {
			 codao.insertCourses(cobean);
			 System.out.println("���� insert ����");
			 mav.setViewName(getPage);
		 }
		
		return mav;
	}
	
}