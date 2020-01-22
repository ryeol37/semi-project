package adminBook;

import java.io.Reader;
import java.io.IOException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class adminBookDeleteAction extends ActionSupport{

	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private adminBookVO paramClass; //�Ķ���͸� ������ ��ü
	private adminBookVO resultClass; //���� ��� ���� ������ ��ü
	
	//����¡ �׼�	
	/*private int currentPage;*/
	
	private int b_no;			//�۹�ȣ
	
	public adminBookDeleteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String execute() throws Exception {
		paramClass = new adminBookVO();
		resultClass = new adminBookVO();
		
		resultClass = (adminBookVO) sqlMapper.queryForObject("adminBook.selectOne", getB_no());

		paramClass.setB_no(getB_no());
		
		sqlMapper.delete("adminBook.deleteBook",paramClass);
		
		return SUCCESS;
	}

	public adminBookVO getParamClass() {
		return paramClass;
	}

	public adminBookVO getResultClass() {
		return resultClass;
	}

	public int getB_no() {
		return b_no;
	}

	public void setParamClass(adminBookVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(adminBookVO resultClass) {
		this.resultClass = resultClass;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
}
