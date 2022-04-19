package course.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

//conum,coname,coteacher,cosubject,coimage,covideo,cocontent,coprice,coupload_date
@Component("myCoBean2")
public class CoBean2 {
	
	private int conum;
	
	@NotEmpty(message="���Ǹ��� �Է����ּ���")
	private String coname;
	
	@NotEmpty(message="�������� �Է����ּ���")
	private String coteacher;
	
	@NotEmpty(message="���ǰ����� �������ּ���")
	private String cosubject;
	
	@NotEmpty(message="���� �̹����� �������ּ���")
	private String coimage;
	
	@NotEmpty(message="���Ǹ� �־��ּ���")
	private String covideo;
	
	@NotEmpty(message="���ǼҰ����� �Է����ּ���")
	private String cocontent;
	
	//��ȿ���˻� NotEmpty���ϸ� ������(Integer �δ� @NotBlank�� �˻��ؼ� ���� �߻���.)
	@NotNull(message="���ǰ����� �Է����ּ���")
	private int coprice;
	private Timestamp coupload_date;
	
	private MultipartFile upimage; //coimage
	private MultipartFile upvideo; //covideo
	
	public MultipartFile getUpimage() { //coimage
		return upimage;
	}
	
	public void setUpimage(MultipartFile upimage) {
		this.upimage = upimage;
		coimage = upimage.getOriginalFilename();
	}
	
	public MultipartFile getUpvideo() { //covideo
		return upvideo;
	}
	public void setUpvideo(MultipartFile upvideo) {
		this.upvideo = upvideo;
		covideo = upvideo.getOriginalFilename();
	}
	
	
	public int getConum() {
		return conum;
	}
	public void setConum(int conum) {
		this.conum = conum;
	}
	public String getConame() {
		return coname;
	}
	public void setConame(String coname) {
		this.coname = coname;
	}
	public String getCoteacher() {
		return coteacher;
	}
	public void setCoteacher(String coteacher) {
		this.coteacher = coteacher;
	}
	public String getCosubject() {
		return cosubject;
	}
	public void setCosubject(String cosubject) {
		this.cosubject = cosubject;
	}
	public String getCoimage() {
		return coimage;
	}
	public void setCoimage(String coimage) {
		this.coimage = coimage;
	}
	public String getCovideo() {
		return covideo;
	}
	public void setCovideo(String covideo) {
		this.covideo = covideo;
	}
	public String getCocontent() {
		return cocontent;
	}
	public void setCocontent(String cocontent) {
		this.cocontent = cocontent;
	}
	public int getCoprice() {
		return coprice;
	}
	public void setCoprice(int coprice) {
		this.coprice = coprice;
	}
	public Timestamp getCoupload_date() {
		return coupload_date;
	}
	public void setCoupload_date(Timestamp coupload_date) {
		this.coupload_date = coupload_date;
	}
}

/*
--���� ���̺�
drop sequence cos_seq;
create sequence cos_seq
start with 1
increment by 1
nocache;
drop table courses cascade constraints;
create table courses(
	conum number not null primary key, --���ǹ�ȣ
	coname varchar2(50) not null, --���Ǹ�
	coteacher varchar2(15) not null, --���Ǵ�缱����
	cosubject varchar2(30) not null, --���ǰ���
	coimage varchar(100), --�����̹���
	covideo varchar2(100) not null, --���ǿ���
	cocontent varchar2(50) not null, --���ǼҰ�����
	coprice number not null, --���ǰ���
	coupload_date date default sysdate --���Ǿ��ε峯¥
);
*/