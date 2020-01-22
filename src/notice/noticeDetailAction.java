package notice;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class noticeDetailAction extends ActionSupport implements SessionAware {

	public static Reader reader; // ���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API�� ����ϱ� ���� sqlMapper
											// ��ü.

	private noticeVO paramClass = new noticeVO(); // �Ķ���͸� ������ ��ü
	private noticeVO resultClass = new noticeVO(); // ���� ��� ���� ������ ��ü

	private int currentPage; // ���� ������

	private int n_no; // �۹�ȣ

	private Map session;
	private boolean isTrue;
	private boolean boo = false;

	public noticeDetailAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}

	public String execute() throws Exception {

		paramClass = new noticeVO();
		resultClass = new noticeVO();

		paramClass.setN_no(getN_no());
		sqlMapper.update("notice.updateReadhit", paramClass);

		resultClass = (noticeVO) sqlMapper.queryForObject("notice.selectOne", getN_no());
		

	System.out.println("boo = " + boo);
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

	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	public boolean isBoo() {
		return boo;
	}

	public void setBoo(boolean boo) {
		this.boo = boo;
	}

	
}
