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

   public static Reader reader;   //���� ��Ʈ���� ���� reader.
   public static SqlMapClient sqlMapper;   //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
   
   private List<fboardVO> list = new ArrayList<fboardVO>();
   private List<fboardVO> slist = new ArrayList<fboardVO>();
   int count;
   
   //����¡ �׼�   
   private int currentPage = 1;   //���� ������
   private int totalCount;       // �� �Խù��� ��
   private int blockCount = 5;   // �� ��������  �Խù��� ��
   private int blockPage = 5;    // �� ȭ�鿡 ������ ������ ��
   private String pagingHtml;    //����¡�� ������ HTML
   private fboardPagingAction page;    // ����¡ Ŭ����
   private int searchNum;   
   private String searchKeyword;
   private int num = 0; //???

   private Map session;
   public fboardListAction() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);   // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
      reader.close();
   }
   
   public boolean isTrue() {
	      
	      if(session.get("session_id").equals(list.get(2)))
	         return true;
	      return false;
	   }
   
   public String execute() throws Exception {
      list = sqlMapper.queryForList("fboard.selectAll"); //��� ���� ������ ����Ʈ�� �ִ´�.
      
      totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
      // pagingAction ��ü ����.
      page = new fboardPagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, searchKeyword, num); 
      pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

      // ���� ���������� ������ ������ ���� ��ȣ ����.
      int lastCount = totalCount;

      // ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ 
      //lastCount�� +1 ��ȣ�� ����.
      if (page.getEndCount() < totalCount)
         lastCount = page.getEndCount() + 1;

      // ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
      list = list.subList(page.getStartCount(), lastCount);
       int count = list.size();
        
        for(fboardVO no : list){
         
         no.setListNo(count--);
        }
        
      return SUCCESS;
   }
   
   
   //�˻�
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