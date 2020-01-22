package login;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class checkIdAction extends ActionSupport implements SessionAware{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private String m_id;
	private String m_pw;
	private String m_isadmin;
	private int m_no;
	
	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	private loginVO paramClass;
	private loginVO resultClass;
	private Map session;
	
	public checkIdAction() throws IOException {
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String checkId() throws Exception {
		paramClass=new loginVO();
		paramClass.setM_id(m_id);
		paramClass.setM_pw(m_pw);
		
		loginVO result = (loginVO)
				
				sqlMapper.queryForObject("login.checkId", m_id);

		System.out.println("param.id >> " + paramClass.getM_id());
		System.out.println("param.pw >> " + paramClass.getM_pw());
		System.out.println("result >> " + result);
		System.out.println("m_pw >> " + m_pw);

		if(result != null && m_pw.equals(result.getM_pw())){
			session.put("session_id", result.getM_id());
			session.put("session_pw", result.getM_pw());
			session.put("session_no", result.getM_no());
			session.put("session_isadmin", result.getM_isadmin());
			
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	public String logout() throws Exception {
		if(session.get("session_id") != null) {
			session.remove("session_id");
		}
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
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

	public String getM_isadmin() {
		return m_isadmin;
	}

	public void setM_isadmin(String m_isadmin) {
		this.m_isadmin = m_isadmin;
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

	public Map getSession() {
		return session;
	}

}