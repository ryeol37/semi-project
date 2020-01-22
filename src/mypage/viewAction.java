package mypage;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Context;

import book.loanVO;
import book.bookVO;

public class viewAction extends ActionSupport implements SessionAware{

	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ�? ���� sqlMapper ��ü.

	private loanVO paramClass = new loanVO(); //�Ķ���͸�? ������ ��ü
	private List resultList = new ArrayList(); //���� ���? ���� ������ ��ü
	
	private  bookVO cResult = new bookVO();
	
	private Map session;
/*	private int currentPage;	//���� ������
*/
	
	private int b_no;
	private int m_no;
	
	
	public viewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	
	public String execute() throws Exception {

		paramClass = new loanVO();
		
		paramClass.setM_no(getM_no());
		System.out.println("getM_no(viewAction) : " + getM_no());
		
	resultList = (List)sqlMapper.queryForObject("book.loanSelectOne", paramClass);
	/*cResult = (bookVO) sqlMapper.queryForObject("book.bookSelectOne", getB_no());*/
	
	
//	commentlist = sqlMapper.queryForList("admin.commentSelectAll", getBook_no());
	
		
		
	return SUCCESS;
	}
	

	public loanVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(loanVO paramClass) {
		this.paramClass = paramClass;
	}

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	public bookVO getcResult() {
		return cResult;
	}

	public void setcResult(bookVO cResult) {
		this.cResult = cResult;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public Map getSession() {
		return session;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	
	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}