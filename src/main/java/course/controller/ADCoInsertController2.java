package course.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import course.model.CoBean2;
import course.model.CoDao2;
import course.model.SubBean2;
import course.model.SubDao2;



@Controller
public class ADCoInsertController2 {
	private final String command = "coinsert.cos";
	private String getPage = "coinsertForm2";
	private String gotoPage = "redirect:/list.cos";
			
	@Inject
	private SubDao2 subdao;
	
	@Inject
	@Qualifier("myCoDao2")
	private CoDao2 codao;
	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(HttpServletRequest request) {
		
		List<SubBean2> sublist = subdao.subjectAll();
		request.setAttribute("sublist", sublist);
		
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(
			@Valid CoBean2 cobean, BindingResult result,
			HttpServletRequest request) {

		
		ModelAndView mav = new ModelAndView();
		
		//��¥
		Timestamp date =  new Timestamp(System.currentTimeMillis());
		cobean.setCoupload_date(date);
		
		//�̹���, ����
		String uploadPath = servletContext.getRealPath("/resources");
		
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
		
		} //cnt>0
		
		
		 else {
			 codao.insertCourses(cobean);
			 System.out.println("���� insert ����");
			 mav.setViewName(getPage);
		 }
		
		return mav;
	}
}
