package book;
import java.io.IOException; 
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import book.BookPagingAction;

public class BookAction extends ActionSupport 
{
	public static Reader reader;		//�뙆�씪 �뒪�듃由쇱쓣 �쐞�븳 reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API瑜� �궗�슜�븯湲� �쐞�븳 sqlMapper 媛앹껜.
	
	private List<bookVO> list = new ArrayList<bookVO>();
	
	private String searchKeyword; // �궎�썙�뱶濡� 寃��깋
	private int searchNum;	// 湲�踰덊샇濡� 寃��깋

	private int currentPage = 1;	//�쁽�옱 �럹�씠吏�
	private int totalCount; 		// 珥� 寃뚯떆臾쇱쓽 �닔
	private int blockCount = 5;	// �븳 �럹�씠吏��쓽  寃뚯떆臾쇱쓽 �닔
	private int blockPage = 5; 	// �븳 �솕硫댁뿉 蹂댁뿬以� �럹�씠吏� �닔
	private String pagingHtml; 	//�럹�씠吏뺤쓣 援ы쁽�븳 HTML
	private BookPagingAction page; // �럹�씠吏� �겢�옒�뒪
	private int num = 0;
	
	//�깮�꽦�옄
	public BookAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml �뙆�씪�쓽 �꽕�젙�궡�슜�쓣 媛��졇�삩�떎.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);  // sqlMapConfig.xml�쓽 �궡�슜�쓣 �쟻�슜�븳 sqlMapper 媛앹껜 �깮�꽦.
		reader.close();
	}
	
	// 寃뚯떆�뙋 LIST �븸�뀡
	public String search() throws Exception {
		// 紐⑤뱺 湲��쓣 媛��졇�� list�뿉 �꽔�뒗�떎.
		
		System.out.println(searchKeyword);
		if(searchNum == 0){
			list = sqlMapper.queryForList("book.searchAll", "%"+getSearchKeyword()+"%");
		}
		if(searchNum == 1){
			list = sqlMapper.queryForList("book.selectSearchB", "%"+getSearchKeyword()+"%");
		}
		if(searchNum == 2){
			list = sqlMapper.queryForList("book.selectSearchW", "%"+getSearchKeyword()+"%");	
		}
		if(searchNum == 3){
			list = sqlMapper.queryForList("book.selectSearchP", "%"+getSearchKeyword()+"%");	
		}
		if(searchNum == 4){
			list = sqlMapper.queryForList("book.selectSearch1", "%"+getSearchKeyword()+"%");	
			}
		if(searchNum == 5){
			list = sqlMapper.queryForList("book.selectSearch2", "%"+getSearchKeyword()+"%");	
		}
		
		totalCount = list.size(); // �쟾泥� 湲� 媛��닔瑜� 援ы븳�떎.
		// BookPagingAction 媛앹껜 �깮�꽦.
		page = new BookPagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, searchKeyword, num);
		pagingHtml = page.getPagingHtml().toString(); // �럹�씠吏� HTML �깮�꽦.
		
		// �쁽�옱 �럹�씠吏��뿉�꽌 蹂댁뿬以� 留덉�留� 湲��쓽 踰덊샇 �꽕�젙.
		int lastCount = totalCount;
		// �쁽�옱 �럹�씠吏��쓽 留덉�留� 湲��쓽 踰덊샇媛� �쟾泥댁쓽 留덉�留� 湲� 踰덊샇蹂대떎 �옉�쑝硫� 
		//lastCount瑜� +1 踰덊샇濡� �꽕�젙.
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		// �쟾泥� 由ъ뒪�듃�뿉�꽌 �쁽�옱 �럹�씠吏�留뚰겮�쓽 由ъ뒪�듃留� 媛��졇�삩�떎.
		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
		
	}
	
	public String form() throws Exception
	{
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		BookAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		BookAction.sqlMapper = sqlMapper;
	}

	public List<bookVO> getList() {
		return list;
	}

	public void setList(List<bookVO> list) {
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

	public BookPagingAction getPage() {
		return page;
	}

	public void setPage(BookPagingAction page) {
		this.page = page;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}

