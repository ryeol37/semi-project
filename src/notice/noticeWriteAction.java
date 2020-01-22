package notice;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class noticeWriteAction extends ActionSupport implements SessionAware {

	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private noticeVO paramClass = new noticeVO(); //�Ķ���͸� ������ ��ü
	private noticeVO resultClass = new noticeVO(); 
	
	private int n_no;			//�۹�ȣ
	private String n_subject;			//������
	private String n_content;			//�۳���
	
	private Map session;
	
	//����¡ �׼�	
	private int currentPage;	//���� ������
	
	public noticeWriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String form() throws Exception{
		return SUCCESS;
	}
	
	public String execute() throws Exception{
		paramClass = new noticeVO();
		setResultClass(new noticeVO());
		
		
		paramClass.setN_subject(getN_subject());
		paramClass.setN_content(getN_content());
		
		System.out.println("param.subject >> " + paramClass.getN_subject());
		System.out.println("param.content >> " + paramClass.getN_content());
		
		sqlMapper.insert("notice.insertNotice", paramClass);
		
		return SUCCESS;
	}

	public noticeVO getParamClass() {
		return paramClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
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

	public noticeVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(noticeVO resultClass) {
		this.resultClass = resultClass;
	}


	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}
