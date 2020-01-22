package fboard;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class fboardWriteAction extends ActionSupport implements SessionAware {

	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private fboardVO paramClass = new fboardVO(); //�Ķ���͸� ������ ��ü
	private fboardVO resultClass = new fboardVO(); 
	
	private int fb_no;			//�۹�ȣ
	private String m_id;		//�ۼ���
	private String fb_subject;			//������
	private int fb_readhit;			//��ȸ��
	private String fb_content;			//�۳���
	private Date fb_regdate;			//�ۼ���
	
	private Map session;
	
	//����¡ �׼�	
	private int currentPage;	//���� ������
	
	public fboardWriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String form() throws Exception{
		return SUCCESS;
	}
	
	public String execute() throws Exception{
		paramClass = new fboardVO();
		setResultClass(new fboardVO());
		
		paramClass.setM_id(getM_id());
		paramClass.setFb_subject(getFb_subject());
		paramClass.setFb_content(getFb_content());
		
		sqlMapper.insert("fboard.insertBoard", paramClass);
		
		return SUCCESS;
	}

	public fboardVO getParamClass() {
		return paramClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

	public int getFb_readhit() {
		return fb_readhit;
	}

	public void setFb_readhit(int fb_readhit) {
		this.fb_readhit = fb_readhit;
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
	public fboardVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(fboardVO resultClass) {
		this.resultClass = resultClass;
	}


	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}



}
