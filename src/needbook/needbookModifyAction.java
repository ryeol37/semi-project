package needbook;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class needbookModifyAction extends ActionSupport{

	public static Reader reader;	//파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private needbookVO paramClass = new needbookVO(); //파라미터를 저장할 객체
	private needbookVO resultClass = new needbookVO(); //쿼리 결과 값을 저장할 객체
	
	private int currentPage;	//현재 페이지
	
	private int nb_no;			//글번호
	private String nb_subject;			//글제목
	private String nb_content;			//글내용
	private Date nb_regdate;			//작성일
	
	
	public needbookModifyAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		paramClass = new needbookVO();
		resultClass = new needbookVO();
		
		paramClass.setNb_no(getNb_no());
		paramClass.setNb_subject(getNb_subject());
		paramClass.setNb_content(getNb_content());
		
		sqlMapper.update("needbook.updateBoard", paramClass);
		
		
		// 수정이 끝나면 view 페이지로 이동.
		resultClass = (needbookVO) sqlMapper.queryForObject("needbook.selectOne", getNb_no());
		
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

	public String getNb_subject() {
		return nb_subject;
	}

	public String getNb_content() {
		return nb_content;
	}

	public Date getNb_regdate() {
		return nb_regdate;
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

	public void setNb_subject(String nb_subject) {
		this.nb_subject = nb_subject;
	}

	public void setNb_content(String nb_content) {
		this.nb_content = nb_content;
	}

	public void setNb_regdate(Date nb_regdate) {
		this.nb_regdate = nb_regdate;
	}
}
