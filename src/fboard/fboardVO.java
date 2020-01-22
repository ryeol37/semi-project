package fboard;

import java.util.Date;

public class fboardVO {
   private int fb_no; // 글번호
   private String m_id;// 작성자
   private String fb_subject; // 글제목
   private String fb_content; // 글내용
   private Date fb_regdate; // 작성일
   private int fb_readhit; // 조회수
   private int fb_like; //추천수
   private int listNo;
   private int c_no;
   
public int getC_no() {
	return c_no;
}
public void setC_no(int c_no) {
	this.c_no = c_no;
}
public int getFb_no() {
	return fb_no;
}
public void setFb_no(int fb_no) {
	this.fb_no = fb_no;
}
public String getM_id() {
	return m_id;
}
public void setM_id(String m_id) {
	this.m_id = m_id;
}
public String getFb_subject() {
	return fb_subject;
}
public void setFb_subject(String fb_subject) {
	this.fb_subject = fb_subject;
}
public String getFb_content() {
	return fb_content;
}
public void setFb_content(String fb_content) {
	this.fb_content = fb_content;
}
public Date getFb_regdate() {
	return fb_regdate;
}
public void setFb_regdate(Date fb_regdate) {
	this.fb_regdate = fb_regdate;
}
public int getFb_readhit() {
	return fb_readhit;
}
public void setFb_readhit(int fb_readhit) {
	this.fb_readhit = fb_readhit;
}
public int getFb_like() {
	return fb_like;
}
public void setFb_like(int fb_like) {
	this.fb_like = fb_like;
}
public int getListNo() {
	return listNo;
}
public void setListNo(int listNo) {
	this.listNo = listNo;
}
   

}



  