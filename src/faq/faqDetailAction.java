package faq;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class faqDetailAction extends ActionSupport implements SessionAware {

	public static Reader reader; // 파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API를 사용하기 위한 sqlMapper
											// 객체.

	private faqVO paramClass = new faqVO(); // 파라미터를 저장할 객체
	private faqVO resultClass = new faqVO(); // 쿼리 결과 값을 저장할 객체

	private int currentPage; // 현재 페이지

	private int f_no; // 글번호

	private Map session;
	private boolean isTrue;
	private boolean boo = false;

	public faqDetailAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}

	public String execute() throws Exception {

		paramClass = new faqVO();
		resultClass = new faqVO();

		paramClass.setF_no(getF_no());
		sqlMapper.update("faq.updateReadhit", paramClass);

		resultClass = (faqVO) sqlMapper.queryForObject("faq.selectOne", getF_no());
		
	
	System.out.println("boo = " + boo);
		return SUCCESS;
	}

	public faqVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(faqVO paramClass) {
		this.paramClass = paramClass;
	}

	public faqVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(faqVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
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

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public boolean isTrue() {
		return isTrue;
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