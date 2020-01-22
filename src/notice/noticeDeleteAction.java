package notice;

import java.io.Reader;
import java.io.IOException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class noticeDeleteAction extends ActionSupport{

	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private noticeVO paramClass; //�Ķ���͸� ������ ��ü
	private noticeVO resultClass; //���� ��� ���� ������ ��ü
	
	//����¡ �׼�	
	private int currentPage;
	
	private int n_no;			//�۹�ȣ
	
	public noticeDeleteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String execute() throws Exception {
		paramClass = new noticeVO();
		resultClass = new noticeVO();
		
		resultClass = (noticeVO) sqlMapper.queryForObject("notice.selectOne", getN_no());

		paramClass.setN_no(getN_no());
		
		
		
		sqlMapper.delete("notice.deleteNotice",paramClass);
		
		return SUCCESS;
	}

	public noticeVO getParamClass() {
		return paramClass;
	}

	public noticeVO getResultClass() {
		return resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getN_no() {
		return n_no;
	}

	public void setParamClass(noticeVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(noticeVO resultClass) {
		this.resultClass = resultClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}
	
}
