package mypage;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import book.bookVO;

public class myRentAction extends ActionSupport implements SessionAware{

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private bookVO paramClass;
	private bookVO resultClass;
	
	private int b_no;
//    private String reserve_id;
	private String b_rentid;
//	private String rent_count;
	
	private List<bookVO> list = new ArrayList<bookVO>();
	private Map session;

//	boolean checkReserve = true;
	
	public myRentAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	
	public String execute() throws Exception{
		paramClass = new bookVO();
		resultClass = new bookVO();
		
		/*paramClass.setRent_id((String) session.get("session_id"));*/
		
		String b_rentid = (String)session.get("session_id");
		
		paramClass.setB_no(b_no);
		
		list = sqlMapper.queryForList("book.myRentSearch", b_rentid);
				
		System.out.println("b_rentid>>" + b_rentid);
		return SUCCESS;
	}
	
//	public String rentExtend() throws Exception {		
//		paramClass = new bookVO();
//		resultClass = new bookVO();
//		
//		String rent_id = (String)session.get("session_id");
//		
//		paramClass.setB_no(b_no);
//		
//		System.out.println("b_no >> " + b_no);
//		
//		System.out.println("reserve_id >> " + reserve_id);
//		
//		System.out.println("rent_count >> " + rent_count);
//		/*		if(reserve_id !=null) {
//			checkReserve = false;
//			return ERROR;
//		}*/
//		
//		sqlMapper.update("book.rentExtend", paramClass);
//		
//		return SUCCESS;
//	}
	
	public String rentReturn() throws Exception {		//���� �ݳ�
		paramClass = new bookVO();
		resultClass = new bookVO();
		
		String b_rentid = (String)session.get("session_id");
		
		paramClass.setB_no(b_no);
		
		sqlMapper.update("book.returnBook", paramClass);
		
		return SUCCESS;
	}
	
	public void setSession(Map session) {
		this.session = session;
	}


	public List<bookVO> getList() {
		return list;
	}


	public void setList(List<bookVO> list) {
		this.list = list;
	}


	public bookVO getParamClass() {
		return paramClass;
	}


	public bookVO getResultClass() {
		return resultClass;
	}


	public int getB_no() {
		return b_no;
	}


	public void setParamClass(bookVO paramClass) {
		this.paramClass = paramClass;
	}


	public void setResultClass(bookVO resultClass) {
		this.resultClass = resultClass;
	}


	public void setB_no(int b_no) {
		this.b_no = b_no;
	}


	public String getB_rentid() {
		return b_rentid;
	}


	public void setB_rentid(String b_rentid) {
		this.b_rentid = b_rentid;
	}


//	public String getReserve_id() {
//		return reserve_id;
//	}
//
//
//	public void setReserve_id(String reserve_id) {
//		this.reserve_id = reserve_id;
//	}
//
//
//	public boolean isCheckReserve() {
//		return checkReserve;
//	}
//
//
//	public void setCheckReserve(boolean checkReserve) {
//		this.checkReserve = checkReserve;
//	}
//
//
//	public String getRent_count() {
//		return rent_count;
//	}
//
//
//	public void setRent_count(String rent_count) {
//		this.rent_count = rent_count;
//	}
	
	
	
}
