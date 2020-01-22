package login;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class findAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private String m_id;
	private String m_pw;
	private String m_email;
	private loginVO paramClass;
	private loginVO resultClass;
	private loginVO result;
	public findAction() throws IOException {
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String findId() throws Exception {
		paramClass=new loginVO();
		paramClass.setM_email(m_email);
		result = new loginVO();
	
		result = (loginVO)sqlMapper.queryForObject("login.findId", paramClass);
		//System.out.println("result : " + result.getM_id());
		if(result==null){
			return ERROR;
		}
		return SUCCESS;	
	}
	
	public String findPw() throws Exception {
		paramClass=new loginVO();
		result = new loginVO();
		paramClass.setM_id(m_id);
		paramClass.setM_email(m_email);
		
		result = (loginVO)sqlMapper.queryForObject("login.findPw", paramClass);
//		System.out.println("param.id >> " + paramClass.getM_id());
//		System.out.println("param.email >> " + paramClass.getM_email());
//		System.out.println("result >> " + result.getM_pw());
//		System.out.println("m_email >> " + m_email);

		if(result==null){
			return ERROR;
		}
		return SUCCESS;
		
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public loginVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(loginVO paramClass) {
		this.paramClass = paramClass;
	}

	public loginVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(loginVO resultClass) {
		this.resultClass = resultClass;
	}

	public loginVO getResult() {
		return result;
	}

	public void setResult(loginVO result) {
		this.result = result;
	}
	
}