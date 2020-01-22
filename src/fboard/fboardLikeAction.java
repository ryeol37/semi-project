package fboard;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class fboardLikeAction extends ActionSupport {
	
	public static Reader reader;   //파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;   //SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	
	private fboardVO paramClass;
	private fboardVO resultClass;
	
	private int currentPage;
	
	private int fb_like;
	private int fb_no;
	
	private Map session;
	
	public fboardLikeAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	public String execute() throws Exception {
		
		paramClass = new fboardVO();
		resultClass =new fboardVO();
		paramClass.setFb_no(getFb_no());
	
		sqlMapper.update("fboard.updateLike", paramClass);
		System.out.println(fb_no);
		//resultClass = (fboardVO) sqlMapper.queryForObject("fboard.selectOne", getFb_no());
	
	return SUCCESS;
	
	}
	

	public fboardVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(fboardVO paramClass) {
		this.paramClass = paramClass;
	}

	public fboardVO getresultClass() {
		return resultClass;
	}

	public void setresultClass(fboardVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getFb_like() {
		return fb_like;
	}

	public void setFb_like(int fb_like) {
		this.fb_like = fb_like;
	}

	public int getFb_no() {
		return fb_no;
	}

	public void setFb_no(int fb_no) {
		this.fb_no = fb_no;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	
}
