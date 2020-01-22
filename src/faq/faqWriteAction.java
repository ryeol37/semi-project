package faq;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class faqWriteAction extends ActionSupport implements SessionAware {

	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private faqVO paramClass = new faqVO(); //�Ķ���͸� ������ ��ü
	private faqVO resultClass = new faqVO(); 
	
	private int f_no;			//�۹�ȣ
	private String f_subject;			//������
	private String f_content;			//�۳���
	
	private Map session;
	
	//����¡ �׼�	
	private int currentPage;	//���� ������
	
	public faqWriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String form() throws Exception{
		return SUCCESS;
	}
	
	public String execute() throws Exception{
		paramClass = new faqVO();
		setResultClass(new faqVO());
		
		
		paramClass.setF_subject(getF_subject());
		paramClass.setF_content(getF_content());
		
		System.out.println("param.subject >> " + paramClass.getF_subject());
		System.out.println("param.content >> " + paramClass.getF_content());
		
		sqlMapper.insert("faq.insertFaq", paramClass);
		
		return SUCCESS;
	}

	public faqVO getParamClass() {
		return paramClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
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

	public faqVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(faqVO resultClass) {
		this.resultClass = resultClass;
	}


	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}



}
