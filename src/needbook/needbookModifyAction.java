package needbook;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class needbookModifyAction extends ActionSupport{

	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private needbookVO paramClass = new needbookVO(); //�Ķ���͸� ������ ��ü
	private needbookVO resultClass = new needbookVO(); //���� ��� ���� ������ ��ü
	
	private int currentPage;	//���� ������
	
	private int nb_no;			//�۹�ȣ
	private String nb_subject;			//������
	private String nb_content;			//�۳���
	private Date nb_regdate;			//�ۼ���
	
	
	public needbookModifyAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		paramClass = new needbookVO();
		resultClass = new needbookVO();
		
		paramClass.setNb_no(getNb_no());
		paramClass.setNb_subject(getNb_subject());
		paramClass.setNb_content(getNb_content());
		
		sqlMapper.update("needbook.updateBoard", paramClass);
		
		
		// ������ ������ view �������� �̵�.
		resultClass = (needbookVO) sqlMapper.queryForObject("needbook.selectOne", getNb_no());
		
		return SUCCESS;
	}

	public needbookVO getParamClass() {
		return paramClass;
	}

	public needbookVO getResultClass() {
		return resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getNb_no() {
		return nb_no;
	}

	public String getNb_subject() {
		return nb_subject;
	}

	public String getNb_content() {
		return nb_content;
	}

	public Date getNb_regdate() {
		return nb_regdate;
	}

	public void setParamClass(needbookVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(needbookVO resultClass) {
		this.resultClass = resultClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setNb_no(int nb_no) {
		this.nb_no = nb_no;
	}

	public void setNb_subject(String nb_subject) {
		this.nb_subject = nb_subject;
	}

	public void setNb_content(String nb_content) {
		this.nb_content = nb_content;
	}

	public void setNb_regdate(Date nb_regdate) {
		this.nb_regdate = nb_regdate;
	}
}
