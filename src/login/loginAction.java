package login;

import java.io.Reader;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport implements SessionAware {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private String m_id;
	private String m_pw;
	private Map session;
	private loginVO paramClass;
	private loginVO resultClass;

	public loginAction() throws Exception {
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String loginRequest() throws Exception {
		return SUCCESS;
	}
	
	public String checkId() throws Exception {
		paramClass=new loginVO();
		paramClass.setM_id(m_id);
		paramClass.setM_pw(m_pw);
		
		loginVO result = (loginVO)
				
		sqlMapper.queryForObject("login.checkmember", m_id);
		
		if(result != null && m_pw.equals(result.getM_pw())){
		
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		loginAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		loginAction.sqlMapper = sqlMapper;
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