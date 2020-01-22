package adminBook;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class adminBookListAction extends ActionSupport {
	
	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private List<adminBookVO> list = new ArrayList<adminBookVO>();
	
	//����¡ �׼�	
	private int currentPage = 1;	//���� ������
	private int totalCount; 		// �� �Խù��� ��
	private int blockCount = 5;	// �� ��������  �Խù��� ��
	private int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��		
	private String pagingHtml; 	//����¡�� ������ HTML
	private adminBookPagingAction page; 	// ����¡ Ŭ����
	private int num = 0; //???
	private int searchNum;	
	private String searchKeyword;
	
	
	public adminBookListAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	
		reader.close();
	}

	public String execute() throws Exception {
		
		list = sqlMapper.queryForList("adminBook.selectAll"); //��� ���� ������ ����Ʈ�� �ִ´�.
		
		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		// pagingAction ��ü ����.
		page = new adminBookPagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, searchKeyword, num);
		pagingHtml = page.getPagingHtml().toString();

	
		int lastCount = totalCount;

		
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		
		list = list.subList(page.getStartCount(), lastCount);
		
		
		return SUCCESS;
	}

	public List<adminBookVO> getList() {
		return list;
	}

	public void setList(List<adminBookVO> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public adminBookPagingAction getPage() {
		return page;
	}

	public int getNum() {
		return num;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public void setPage(adminBookPagingAction page) {
		this.page = page;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public int getSearchNum() {
		return searchNum;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
}
