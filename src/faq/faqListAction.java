package faq;

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

public class faqListAction extends ActionSupport implements SessionAware{

   public static Reader reader;   //���� ��Ʈ���� ���� reader.
   public static SqlMapClient sqlMapper;   //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
   
   private List<faqVO> list = new ArrayList<faqVO>();
   int count;
   
   //����¡ �׼�   
   private int currentPage = 1;   //���� ������
   private int totalCount;       // �� �Խù��� ��
   private int blockCount = 5;   // �� ��������  �Խù��� ��
   private int blockPage = 5;    // �� ȭ�鿡 ������ ������ ��
   private String pagingHtml;    //����¡�� ������ HTML
   private faqPagingAction page;    // ����¡ Ŭ����
   private int searchNum;   
   private String searchKeyword;
   private int num = 0; //???

   private Map session;
   public faqListAction() throws IOException {
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
      list = sqlMapper.queryForList("faq.selectAll"); //��� ���� ������ ����Ʈ�� �ִ´�.
      
      totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
      // pagingAction ��ü ����.
      page = new faqPagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, searchKeyword, num); 
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
        
        for(faqVO no : list){
         
         no.setListNo(count--);
        }
        
      return SUCCESS;
   }
   
   
   //�˻�
   public String search() throws Exception {
      
      if(searchNum == 0){
         list = sqlMapper.queryForList("faq.selectSearchT", "%"+getSearchKeyword()+"%");
      }
      if(searchNum == 1){
         list = sqlMapper.queryForList("faq.selectSearchC", "%"+getSearchKeyword()+"%");
      }
      
      
      totalCount = list.size();
      page = new faqPagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, searchKeyword, num); 
      pagingHtml = page.getPagingHtml().toString();
      
      int lastCount = totalCount;
      
      if(page.getEndCount() < totalCount)
         lastCount = page.getEndCount() + 1;
      
      list = list.subList(page.getStartCount(), lastCount);
      return SUCCESS;
      
   }


   public List<faqVO> getList() {
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

   public faqPagingAction getPage() {
      return page;
   }

   public int getNum() {
      return num;
   }

   public void setList(List<faqVO> list) {
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

   public void setPage(faqPagingAction page) {
      this.page = page;
   }

   public void setNum(int num) {
      this.num = num;
   }

   @Override
   public void setSession(Map session) {
      // TODO Auto-generated method stub
      this.session = session;
   }


}