package notice;

import java.util.Date;

public class noticeVO {
   private int n_no; // 글번호
   private String n_subject; // 글제목
   private String n_content; // 글내용
   private Date n_regdate; // 작성일
   private int n_readhit; // 조회수
   private int listNo;
   
public int getN_no() {
	return n_no;
}
public void setN_no(int n_no) {
	this.n_no = n_no;
}
public String getN_subject() {
	return n_subject;
}
public void setN_subject(String n_subject) {
	this.n_subject = n_subject;
}
public String getN_content() {
	return n_content;
}
public void setN_content(String n_content) {
	this.n_content = n_content;
}
public Date getN_regdate() {
	return n_regdate;
}
public void setN_regdate(Date n_regdate) {
	this.n_regdate = n_regdate;
}
public int getN_readhit() {
	return n_readhit;
}
public void setN_readhit(int n_readhit) {
	this.n_readhit = n_readhit;
}
public int getListNo() {
	return listNo;
}
public void setListNo(int listNo) {
	this.listNo = listNo;
}
   

}
