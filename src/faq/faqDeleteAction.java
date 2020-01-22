package faq;

import java.io.Reader;
import java.io.IOException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class faqDeleteAction extends ActionSupport{

	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private faqVO paramClass; //�Ķ���͸� ������ ��ü
	private faqVO resultClass; //���� ��� ���� ������ ��ü
	
	//����¡ �׼�	
	private int currentPage;
	
	private int f_no;			//�۹�ȣ
	
	public faqDeleteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String execute() throws Exception {
		paramClass = new faqVO();
		resultClass = new faqVO();
		
		resultClass = (faqVO) sqlMapper.queryForObject("faq.selectOne", getF_no());

		paramClass.setF_no(getF_no());
		
		
		
		sqlMapper.delete("faq.deleteFaq",paramClass);
		
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
	
}
