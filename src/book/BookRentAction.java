package book;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class BookRentAction extends ActionSupport implements SessionAware{

	private int b_no;
	private Date b_indate;
	private String b_rentid;
	private bookVO paramClass;
	private bookVO resultClass;
	
	private Map session;

	
	public static Reader reader;	
	public static SqlMapClient sqlMapper;	
	
	public BookRentAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception {
		
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		paramClass = new bookVO();
		resultClass = new bookVO();
		
		paramClass.setB_rentid((String) session.get("session_id"));
		paramClass.setB_no(b_no);
		
		System.out.println("b_no >> " + b_no);
		sqlMapper.insert("book.bookRent", paramClass);
		return SUCCESS;
	}
	
	public String returnBook() throws Exception {
		return SUCCESS;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	public Date getB_indate() {
		return b_indate;
	}

	public void setB_indate(Date b_indate) {
		this.b_indate = b_indate;
	}

	public String getB_rentid() {
		return b_rentid;
	}

	public void setB_rentid(String b_rentid) {
		this.b_rentid = b_rentid;
	}
	
}
