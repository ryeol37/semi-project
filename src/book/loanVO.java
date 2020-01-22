package book;

import java.util.Date;

public class loanVO {

	private int l_no;
	private int m_no;
	private int b_no;
	private Date l_outdate;
	private Date l_indate;
	private String b_name;
	
	
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public int getL_no() {
		return l_no;
	}
	public void setL_no(int l_no) {
		this.l_no = l_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public Date getl_outdate() {
		return l_outdate;
	}
	public void setl_outdate(Date l_outdate) {
		this.l_outdate = l_outdate;
	}
	public Date getl_indate() {
		return l_indate;
	}
	public void setl_indate(Date l_indate) {
		this.l_indate = l_indate;
	}
	
	
}
