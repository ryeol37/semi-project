package notice;

import java.io.Reader;
import java.io.IOException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class noticeDeleteAction extends ActionSupport{

	public static Reader reader;	//파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private noticeVO paramClass; //파라미터를 저장할 객체
	private noticeVO resultClass; //쿼리 결과 값을 저장할 객체
	
	//페이징 액션	
	private int currentPage;
	
	private int n_no;			//글번호
	
	public noticeDeleteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
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
