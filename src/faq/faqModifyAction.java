package faq;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class faqModifyAction extends ActionSupport{

	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private faqVO paramClass = new faqVO(); //�Ķ���͸� ������ ��ü
	private faqVO resultClass = new faqVO(); //���� ��� ���� ������ ��ü
	
	private int currentPage;	//���� ������
	
	private int f_no;			//�۹�ȣ
	private String f_subject;			//������
	private String f_content;			//�۳���
	private Date f_regdate;			//�ۼ���
	
	
	public faqModifyAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		paramClass = new faqVO();
		resultClass = new faqVO();
		
		paramClass.setF_no(getF_no());
		paramClass.setF_subject(getF_subject());
		paramClass.setF_content(getF_content());
		
		sqlMapper.update("faq.updateFaq", paramClass);
		
		
		// ������ ������ view �������� �̵�.
		resultClass = (faqVO) sqlMapper.queryForObject("faq.selectOne", getF_no());
		
		return SUCCESS;
	}

	public faqVO getParamClass() {
		return paramClass;
	}

	public faqVO getResultClass() {
		return resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getF_no() {
		return f_no;
	}

	public String getF_subject() {
		return f_subject;
	}

	public String getF_content() {
		return f_content;
	}

	public Date getF_regdate() {
		return f_regdate;
	}

	public void setParamClass(faqVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(faqVO resultClass) {
		this.resultClass = resultClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public void setF_subject(String f_subject) {
		this.f_subject = f_subject;
	}

	public void setF_content(String f_content) {
		this.f_content = f_content;
	}

	public void setF_regdate(Date f_regdate) {
		this.f_regdate = f_regdate;
	}
}
