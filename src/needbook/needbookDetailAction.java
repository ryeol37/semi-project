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

	public static Reader reader; // 파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API를 사용하기 위한 sqlMapper
											// 객체.

	private needbookVO paramClass = new needbookVO(); // 파라미터를 저장할 객체
	private needbookVO resultClass = new needbookVO(); // 쿼리 결과 값을 저장할 객체

	private int currentPage; // 현재 페이지

	private int nb_no; // 글번호

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
