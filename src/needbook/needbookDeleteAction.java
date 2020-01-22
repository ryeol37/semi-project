package needbook;

import java.io.Reader;
import java.io.IOException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class needbookDeleteAction extends ActionSupport{

	public static Reader reader;	//파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private needbookVO paramClass; //파라미터를 저장할 객체
	private needbookVO resultClass; //쿼리 결과 값을 저장할 객체
	
	//페이징 액션	
	private int currentPage;
	
	private int nb_no;			//글번호
	
	public needbookDeleteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	public String execute() throws Exception {
		paramClass = new needbookVO();
		resultClass = new needbookVO();
		
		resultClass = (needbookVO) sqlMapper.queryForObject("needbook.selectOne", getNb_no());

		paramClass.setNb_no(getNb_no());
		
		
		
		sqlMapper.delete("needbook.deleteBoard",paramClass);
		
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
	
}
