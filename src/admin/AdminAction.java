package admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements SessionAware {

	public Map session;
	String str;

	public String execute() throws Exception {

		str = session.get("session_isadmin").toString();

		return SUCCESS;
	}

	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
