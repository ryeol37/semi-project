package fboard;

import com.opensymphony.xwork2.ActionSupport;

import fboard.fboardVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.io.IOException;

public class commentDeleteAction extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private cboardVO paramClass;
	private cboardVO resultClass;
	
	private fboardVO fClass;
	
	private int c_no;
	private int fb_no;
	private int currentPage;
	
	public fboardVO getfClass() {
		return fClass;
	}

	public void setfClass(fboardVO fClass) {
		this.fClass = fClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public commentDeleteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {
		paramClass = new cboardVO();
		resultClass = new cboardVO();
		
		fClass = new fboardVO();
		
		fClass.setFb_no(getFb_no());
		
		System.out.println(fb_no);
		resultClass = (cboardVO) sqlMapper.queryForObject("fboard.comSelectOne", getC_no());
		paramClass.setC_no(getC_no());
		
		sqlMapper.delete("fboard.deleteComment",paramClass);
		
		return SUCCESS;
		
		
	}

		
	
	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		commentDeleteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		commentDeleteAction.sqlMapper = sqlMapper;
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

	public int getFb_no() {
		return fb_no;
	}

	public void setFb_no(int fb_no) {
		this.fb_no = fb_no;
	}
	
	
	

	
}
