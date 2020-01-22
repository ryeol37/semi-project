package needbook;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class needbookWriteAction extends ActionSupport implements SessionAware {

	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private needbookVO paramClass = new needbookVO(); //�Ķ���͸� ������ ��ü
	private needbookVO resultClass = new needbookVO(); 
	
	private int nb_no;			//�۹�ȣ
	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	private String m_id;		//�ۼ���
	private String nb_subject;			//������
	private int nb_readhit;			//��ȸ��
	private String nb_content;			//�۳���
	private Date nb_regdate;			//�ۼ���
	
	private Map session;
	
	//����¡ �׼�	
	private int currentPage;	//���� ������
	
	public needbookWriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String form() throws Exception{
		return SUCCESS;
	}
	
	public String execute() throws Exception{
		paramClass = new needbookVO();
		resultClass = new needbookVO();
		
		paramClass.setNb_subject(getNb_subject());
		paramClass.setM_id(getM_id());
		paramClass.setNb_content(getNb_content());
		
		sqlMapper.insert("needbook.insertBoard", paramClass);
		
		return SUCCESS;
	}

	public needbookVO getParamClass() {
		return paramClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
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

	public int getNb_readhit() {
		return nb_readhit;
	}

	public void setNb_readhit(int nb_readhit) {
		this.nb_readhit = nb_readhit;
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


	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
