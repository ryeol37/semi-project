package fboard;

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

public class fboardListAction extends ActionSupport implements SessionAware{

   public static Reader reader;   //파일 스트림을 위한 reader.
   public static SqlMapClient sqlMapper;   //SqlMapClient API를 사용하기 위한 sqlMapper 객체.
   
   private List<fboardVO> list = new ArrayList<fboardVO>();
   private List<fboardVO> slist = new ArrayList<fboardVO>();
   int count;
   
   //페이징 액션   
   private int currentPage = 1;   //현재 페이지
   private int totalCount;       // 총 게시물의 수
   private int blockCount = 5;   // 한 페이지의  게시물의 수
   private int blockPage = 5;    // 한 화면에 보여줄 페이지 수
   private String pagingHtml;    //페이징을 구현한 HTML
   private fboardPagingAction page;    // 페이징 클래스
   private int searchNum;   
   private String searchKeyword;
   private int num = 0; //???

   private Map session;
   public fboardListAction() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);   // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
      reader.close();
   }
   
   public boolean isTrue() {
	      
	      if(session.get("session_id").equals(list.get(2)))
	         return true;
	      return false;
	   }
   
   public String execute() throws Exception {
      list = sqlMapper.queryForList("fboard.selectAll"); //모든 글을 가져와 리스트에 넣는다.
      
      totalCount = list.size(); // 전체 글 갯수를 구한다.
      // pagingAction 객체 생성.
      page = new fboardPagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, searchKeyword, num); 
      pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.

      // 현재 페이지에서 보여줄 마지막 글의 번호 설정.
      int lastCount = totalCount;

      // 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 
      //lastCount를 +1 번호로 설정.
      if (page.getEndCount() < totalCount)
         lastCount = page.getEndCount() + 1;

      // 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
      list = list.subList(page.getStartCount(), lastCount);
       int count = list.size();
        
        for(fboardVO no : list){
         
         no.setListNo(count--);
        }
        
      return SUCCESS;
   }
   
   
   //검색
   public String search() throws Exception {
      
      if(searchNum == 0){
         list = sqlMapper.queryForList("fboard.selectSearchT", "%"+getSearchKeyword()+"%");
      }
      if(searchNum == 1){
         list = sqlMapper.queryForList("fboard.selectSearchM", "%"+getSearchKeyword()+"%");
      }
      if(searchNum == 2){
         list = sqlMapper.queryForList("fboard.selectSearchC", "%"+getSearchKeyword()+"%");   
      }
      
      totalCount = slist.size();
      page = new fboardPagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, searchKeyword, num); 
      pagingHtml = page.getPagingHtml().toString();
      
      int lastCount = totalCount;
      
      if(page.getEndCount() < totalCount)
         lastCount = page.getEndCount() + 1;
      
      slist = slist.subList(page.getStartCount(), lastCount);
      return SUCCESS;
      
   }


   public List<fboardVO> getList() {
      return list;
   }

   public String getSearchKeyword() {
      return searchKeyword;
   }

   public int getSearchNum() {
      return searchNum;
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

   public String getPagingHtml() {
      return pagingHtml;
   }

   public fboardPagingAction getPage() {
      return page;
   }

   public int getNum() {
      return num;
   }

   public void setList(List<fboardVO> list) {
      this.list = list;
   }

   public void setSearchKeyword(String searchKeyword) {
      this.searchKeyword = searchKeyword;
   }

   public void setSearchNum(int searchNum) {
      this.searchNum = searchNum;
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

   public void setPagingHtml(String pagingHtml) {
      this.pagingHtml = pagingHtml;
   }

   public void setPage(fboardPagingAction page) {
      this.page = page;
   }

   public void setNum(int num) {
      this.num = num;
   }
   
   public List<fboardVO> getSlist() {
		return slist;
	}

	public void setSlist(List<fboardVO> slist) {
		this.slist = slist;
	}

   @Override
   public void setSession(Map session) {
      // TODO Auto-generated method stub
      this.session = session;
   }


}