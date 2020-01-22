package notice;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class noticeModifyAction extends ActionSupport{

	public static Reader reader;	//파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private noticeVO paramClass = new noticeVO(); //파라미터를 저장할 객체
	private noticeVO resultClass = new noticeVO(); //쿼리 결과 값을 저장할 객체
	
	private int currentPage;	//현재 페이지
	
	private int n_no;			//글번호
	private String n_subject;			//글제목
	private String n_content;			//글내용
	private Date n_regdate;			//작성일
	
	
	public noticeModifyAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		paramClass = new noticeVO();
		resultClass = new noticeVO();
		
		paramClass.setN_no(getN_no());
		paramClass.setN_subject(getN_subject());
		paramClass.setN_content(getN_content());
		
		sqlMapper.update("notice.updateNotice", paramClass);
		
		
		// 수정이 끝나면 view 페이지로 이동.
		resultClass = (noticeVO) sqlMapper.queryForObject("notice.selectOne", getN_no());
		
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

	public void setParamClass(noticeVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(noticeVO resultClass) {
		this.resultClass = resultClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}

	public String getN_subject() {
		return n_subject;
	}

	public void setN_subject(String n_subject) {
		this.n_subject = n_subject;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public Date getN_regdate() {
		return n_regdate;
	}

	public void setN_regdate(Date n_regdate) {
		this.n_regdate = n_regdate;
	}

	
}
