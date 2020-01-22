package fboard;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class fboardModifyAction extends ActionSupport{

	public static Reader reader;	//파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private fboardVO paramClass = new fboardVO(); //파라미터를 저장할 객체
	private fboardVO resultClass = new fboardVO(); //쿼리 결과 값을 저장할 객체
	
	private int currentPage;	//현재 페이지
	
	private int fb_no;			//글번호
	private String fb_subject;			//글제목
	private String fb_content;			//글내용
	private Date fb_regdate;			//작성일
	
	
	public fboardModifyAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		paramClass = new fboardVO();
		resultClass = new fboardVO();
		
		paramClass.setFb_no(getFb_no());
		paramClass.setFb_subject(getFb_subject());
		paramClass.setFb_content(getFb_content());
		
		sqlMapper.update("fboard.updateBoard", paramClass);
		
		
		// 수정이 끝나면 view 페이지로 이동.
		resultClass = (fboardVO) sqlMapper.queryForObject("fboard.selectOne", getFb_no());
		
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

	public String getFb_subject() {
		return fb_subject;
	}

	public String getFb_content() {
		return fb_content;
	}

	public Date getFb_regdate() {
		return fb_regdate;
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

	public void setFb_subject(String fb_subject) {
		this.fb_subject = fb_subject;
	}

	public void setFb_content(String fb_content) {
		this.fb_content = fb_content;
	}

	public void setFb_regdate(Date fb_regdate) {
		this.fb_regdate = fb_regdate;
	}
}
