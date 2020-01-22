package fboard;


import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import org.apache.struts2.interceptor.SessionAware;

import java.util.*;
import java.io.Reader;
import java.io.IOException;



public class commentWriteAction extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private cboardVO paramClass;
	private cboardVO resultClass;

	private int c_no;
	private int currentPage;

	private String m_id;
	private String c_content;
	private int fb_no;
	
	private Map session;

	Calendar today = Calendar.getInstance();

	public commentWriteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();

	}

	public String execute() throws Exception {
		
		paramClass = new cboardVO();
		resultClass = new cboardVO();
		
		paramClass.setFb_no(getFb_no());
		paramClass.setM_id(getM_id());	
		
		paramClass.setC_content(getC_content());
		paramClass.setC_regdate(today.getTime());
		
		sqlMapper.insert("fboard.insertComment", paramClass);
		

		return SUCCESS;
	}

	public cboardVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(cboardVO paramClass) {
		this.paramClass = paramClass;
	}

	public cboardVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(cboardVO resultClass) {
		this.resultClass = resultClass;
	}



	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public int getFb_no() {
		return fb_no;
	}

	public void setFb_no(int fb_no) {
		this.fb_no = fb_no;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	
	
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	
	
	
	

}
