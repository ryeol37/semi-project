package main;

import java.io.IOException;   
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import book.bookVO;
import notice.noticeVO;
import notice.noticePagingAction;
import book.bookVO;

public class MainAction extends ActionSupport {

	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private List<noticeVO> list = new ArrayList<noticeVO>();
    private List<bookVO> list2 = new ArrayList<bookVO>();
    private List<bookVO> list3 = new ArrayList<bookVO>();
	
	//����¡ �׼�	
	private int currentPage = 1;	//���� ������
	private int totalCount; 		// �� �Խù��� ��
	private int blockCount = 3;	// �� ��������  �Խù��� ��
	private int blockCount2 = 3;
	private int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; 	//����¡�� ������ HTML
	private noticePagingAction page; 	// ����¡ Ŭ����
	private int searchNum;	
	private String searchKeyword;
	private int num = 0; //???
	
	
	private Map session;
	public MainAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}
	

	public String execute() throws Exception {
		
        //���� ��������
		list = sqlMapper.queryForList("notice.selectAll"); //��� ���� ������ ����Ʈ�� �ִ´�.
		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		// pagingAction ��ü ����.
		page = new noticePagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, searchKeyword, num); 
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;

		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ 
		//lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount) lastCount = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		list = list.subList(page.getStartCount(), lastCount); 
		
		//���� ��õ����
		list2 = sqlMapper.queryForList("book.bookRank"); 
		totalCount = list2.size();

		page = new noticePagingAction(currentPage, totalCount, blockCount2, blockPage, searchNum, searchKeyword, num); 
		pagingHtml = page.getPagingHtml().toString(); 
		
		int lastCount2 = totalCount;
		
		if (page.getEndCount() < totalCount)
			lastCount2 = page.getEndCount() + 1;
		
		list2 = list2.subList(page.getStartCount(), lastCount2);
		
		//���� �Ű�����
		list3 = sqlMapper.queryForList("book.newBook");
		totalCount = list3.size();
		page = new noticePagingAction(currentPage, totalCount, blockCount2, blockPage, searchNum, searchKeyword, num); 
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount3 = totalCount;
		
		if (page.getEndCount() < totalCount)
			lastCount3 = page.getEndCount() + 1;
		
		list3 = list3.subList(page.getStartCount(), lastCount3);
		
		return SUCCESS;
	}

	public List<noticeVO> getList() {
		return list;
	}

	public void setList(List<noticeVO> list) {
		this.list = list;
	}

	public List<bookVO> getList2() {
		return list2;
	}

	public void setList2(List<bookVO> list2) {
		this.list2 = list2;
	}

	public List<bookVO> getList3() {
		return list3;
	}

	public void setList3(List<bookVO> list3) {
		this.list3 = list3;
		
	}
}
