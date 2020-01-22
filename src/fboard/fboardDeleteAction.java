package fboard;

import java.io.Reader;
import java.io.IOException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class fboardDeleteAction extends ActionSupport{

	public static Reader reader;	//파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private fboardVO paramClass; //파라미터를 저장할 객체
	private fboardVO resultClass; //쿼리 결과 값을 저장할 객체
	
	//페이징 액션	
	private int currentPage;
	
	private int fb_no;			//글번호
	
	public fboardDeleteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	public String execute() throws Exception {
		paramClass = new fboardVO();
		resultClass = new fboardVO();
		
		resultClass = (fboardVO) sqlMapper.queryForObject("fboard.selectOne", getFb_no());

		paramClass.setFb_no(getFb_no());
		
		
		
		sqlMapper.delete("fboard.deleteBoard",paramClass);
		
		return SUCCESS;
	}

	public fboardVO getParamClass() {
		return paramClass;
	}

	public fboardVO getResultClass() {
		return resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getFb_no() {
		return fb_no;
	}

	public void setParamClass(fboardVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(fboardVO resultClass) {
		this.resultClass = resultClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setFb_no(int fb_no) {
		this.fb_no = fb_no;
	}
	
}
