package needbook;

import java.util.Date;

public class needbookVO {
   private int nb_no; // �۹�ȣ
   private String nb_subject; // ������
   private String nb_content; // �۳���
   private Date nb_regdate; // �ۼ���
   private int nb_readhit; // ��ȸ��
   private String m_id;// �ۼ���
   private int listNo;
   
public int getNb_no() {
	return nb_no;
}
public void setNb_no(int nb_no) {
	this.nb_no = nb_no;
}
public String getNb_subject() {
	return nb_subject;
}
public void setNb_subject(String nb_subject) {
	this.nb_subject = nb_subject;
}
public String getNb_content() {
	return nb_content;
}
public void setNb_content(String nb_content) {
	this.nb_content = nb_content;
}
public Date getNb_regdate() {
	return nb_regdate;
}
public void setNb_regdate(Date nb_regdate) {
	this.nb_regdate = nb_regdate;
}
public int getNb_readhit() {
	return nb_readhit;
}
public void setNb_readhit(int nb_readhit) {
	this.nb_readhit = nb_readhit;
}

public String getM_id() {
	return m_id;
}
public void setM_id(String m_id) {
	this.m_id = m_id;
}
public int getListNo() {
	return listNo;
}
public void setListNo(int listNo) {
	this.listNo = listNo;
}
   
   
}