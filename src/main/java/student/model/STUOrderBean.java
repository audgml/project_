package student.model;

import java.sql.Timestamp;

public class STUOrderBean {

	private int onum; //�ֹ���ȣ(primary key)
	private String aid; //�ֹ���id
	private int totprice; //�ֹ���ü�ݾ�
	private Timestamp odate; //�ֹ���¥
	
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public int getTotprice() {
		return totprice;
	}
	public void setTotprice(int totprice) {
		this.totprice = totprice;
	}
	public Timestamp getOdate() {
		return odate;
	}
	public void setOdate(Timestamp odate) {
		this.odate = odate;
	}
}
