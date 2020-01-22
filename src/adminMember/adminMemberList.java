package adminMember;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

/*import board.BoardVO;*/

public class adminMemberList extends ActionSupport {
	public static Reader reader; 
	public static SqlMapClient sqlMapper; 

	private List<adminMemberVO> list = new ArrayList<adminMemberVO>();
	private String searchKeyword;
	private int searchNum;
	
	private String m_id;
	private String m_name;
	private String m_phone;

	private int currentPage = 1; 
	private int totalCount; 
	private int blockCount = 5; 
	private int blockPage = 5; 
	private String pagingHtml; 
	private adminMemberPaging page; 
	private int num = 0;
	
	private adminMemberVO paramClass;
	private adminMemberVO resultClass;
	
	public adminMemberList() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
		reader.close();
	}
	
	public String form() throws Exception {
		list = sqlMapper.queryForList("adminMem.selectAll"); 
		totalCount = list.size(); 
		page = new adminMemberPaging(currentPage, totalCount, blockCount, blockPage, num, "");
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		list = list.subList(page.getStartCount(), lastCount);
			
		return SUCCESS;
		
		
	}
	
	public String detail() throws Exception {
		resultClass = new adminMemberVO(); 
		resultClass = (adminMemberVO) sqlMapper.queryForObject("adminMem.selectOne", m_id);
		
		return SUCCESS;
	}
	
	public String execute() throws Exception {	

		list = sqlMapper.queryForList("adminMem.selectAll"); 
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		paramClass = new adminMemberVO();
		resultClass = new adminMemberVO();
		
		resultClass = (adminMemberVO) sqlMapper.queryForObject("adminMem.selectOne", m_id);

		paramClass.setM_id(m_id);
		
		sqlMapper.delete("adminMem.deleteMember",paramClass);
		
		return SUCCESS;
	}
	
	
	/*public String search() throws Exception {

		if (searchNum == 0) {
			list = sqlMapper.queryForList("adminMem.searchId", "%" + getSearchKeyword() + "%");
		}
		if (searchNum == 1) {
			list = sqlMapper.queryForList("adminMem.searchName", "%" + getSearchKeyword() + "%");
		}
		if (searchNum == 2) {
			list = sqlMapper.queryForList("adminMem.searchDate", "%" + getSearchKeyword() + "%");
		}

		totalCount = list.size();
		page = new adminMemberPaging(currentPage, totalCount, blockCount, blockPage, searchNum, getSearchKeyword());
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;

	}
	
	*/

	
	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		adminMemberList.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		adminMemberList.sqlMapper = sqlMapper;
	}

	public List<adminMemberVO> getList() {
		return list;
	}

	public void setList(List<adminMemberVO> list) {
		this.list = list;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getSearchNum() {
		return searchNum;
	}

	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public adminMemberPaging getPage() {
		return page;
	}

	public void setPage(adminMemberPaging page) {
		this.page = page;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_id() {
		return m_id;
	}

	public adminMemberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(adminMemberVO paramClass) {
		this.paramClass = paramClass;
	}

	public adminMemberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(adminMemberVO resultClass) {
		this.resultClass = resultClass;
	}

}
