package faq;

import java.io.Reader;
import java.io.IOException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class faqDeleteAction extends ActionSupport{

	public static Reader reader;	//파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private faqVO paramClass; //파라미터를 저장할 객체
	private faqVO resultClass; //쿼리 결과 값을 저장할 객체
	
	//페이징 액션	
	private int currentPage;
	
	private int f_no;			//글번호
	
	public faqDeleteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
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
