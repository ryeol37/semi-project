package mypage;

import com.opensymphony.xwork2.ActionSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.IOException;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import member.memberVO;

public class memberDeleteAction extends ActionSupport implements SessionAware {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private memberVO paramClass; // 
	private memberVO resultClass;
	private memberVO resultClass2;// 

	private String m_id;
	private String m_pw;

	private Map session;

	public memberDeleteAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}

	public String form() throws Exception {

		return SUCCESS;
	}

	public String execute() throws Exception {

		paramClass = new memberVO();
		resultClass = new memberVO();
		
		paramClass.setM_pw(getM_pw());
		paramClass.setM_id((String)session.get("session_id"));
		resultClass = (memberVO) sqlMapper.queryForObject("join.deleteMemberOne", paramClass);

		paramClass.setM_pw(getM_pw());

		sqlMapper.delete("join.deleteJoin", paramClass);
		session.remove("session_id");
		return SUCCESS;
	}

	public memberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(memberVO paramClass) {
		this.paramClass = paramClass;
	}

	public memberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(memberVO resultClass) {
		this.resultClass = resultClass;
	}

	public memberVO getResultClass2() {
		return resultClass2;
	}

	public void setResultClass2(memberVO resultClass2) {
		this.resultClass2 = resultClass2;
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

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

}
	
