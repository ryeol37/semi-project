package needbook;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class needbookDetailAction extends ActionSupport implements SessionAware {

	public static Reader reader; // ���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API�� ����ϱ� ���� sqlMapper
											// ��ü.

	private needbookVO paramClass = new needbookVO(); // �Ķ���͸� ������ ��ü
	private needbookVO resultClass = new needbookVO(); // ���� ��� ���� ������ ��ü

	private int currentPage; // ���� ������

	private int nb_no; // �۹�ȣ

	private Map session;
	private boolean isTrue;
	private boolean boo = false;

	public needbookDetailAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}

	public String execute() throws Exception {

		paramClass = new needbookVO();
		resultClass = new needbookVO();

		paramClass.setNb_no(getNb_no());
		sqlMapper.update("needbook.updateReadhit", paramClass);

		resultClass = (needbookVO) sqlMapper.queryForObject("needbook.selectOne", getNb_no());
		
		if(session.get("session_id") == null)
			boo = false;
		else if(session.get("session_id").equals(resultClass.getM_id())) {
			boo = true;
		}
	
	System.out.println("boo = " + boo);
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
