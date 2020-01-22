package adminBook;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class adminBookLikeAction extends ActionSupport {
	
	public static Reader reader;   //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;   //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private adminBookVO paramClass;
	private adminBookVO resultClass;
	
	private int currentPage;
	
	private int b_like;
	private int b_no;
	
	private Map session;
	
	public adminBookLikeAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String execute() throws Exception {
		
		paramClass = new adminBookVO();
		resultClass =new adminBookVO();
		paramClass.setB_no(getB_no());
	
		sqlMapper.update("adminBook.updateBookLike", paramClass);
		System.out.println(b_no);
	
	return SUCCESS;
	
	}
	

	public adminBookVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(adminBookVO paramClass) {
		this.paramClass = paramClass;
	}

	public adminBookVO getresultClass() {
		return resultClass;
	}

	public void setresultClass(adminBookVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getB_like() {
		return b_like;
	}

	public void setB_like(int fb_like) {
		this.b_like = fb_like;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int fb_no) {
		this.b_no = fb_no;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	
}
