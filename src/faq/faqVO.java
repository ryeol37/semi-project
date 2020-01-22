package faq;

import java.util.Date;

public class faqVO {
   private int f_no; // 글번호
   private String f_subject; // 글제목
   private String f_content; // 글내용
   private Date f_regdate; // 작성일
   private int f_readhit; // 조회수
   private int listNo;
   
public int getF_no() {
	return f_no;
}
public void setF_no(int f_no) {
	this.f_no = f_no;
}
public String getF_subject() {
	return f_subject;
}
public void setF_subject(String f_subject) {
	this.f_subject = f_subject;
}
public String getF_content() {
	return f_content;
}
public void setF_content(String f_content) {
	this.f_content = f_content;
}
public int getListNo() {
	return listNo;
}
public void setListNo(int listNo) {
	this.listNo = listNo;
}
public Date getF_regdate() {
	return f_regdate;
}
public void setF_regdate(Date f_regdate) {
	this.f_regdate = f_regdate;
}
public int getF_readhit() {
	return f_readhit;
}
public void setF_readhit(int f_readhit) {
	this.f_readhit = f_readhit;
}
   

}