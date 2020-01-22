package adminBook;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import init.initPath;

public class FileUploadAction extends ActionSupport {

   public static Reader reader; // 파일 스트림을 위한 reader.
   public static SqlMapClient sqlMapper; // SqlMapClient API를 사용하기 위한 sqlMapper
                                 // 객체.

   private adminBookVO paramClass;
   private adminBookVO resultClass;

   private int b_no;
   private String b_img;

   private File upload;
   private String uploadContentType;
   private String uploadFileName;
   private String fileUploadPath = initPath.getPath();

   public FileUploadAction() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }

   public String upload() throws Exception {

      File destFile = new File(fileUploadPath + getUploadFileName());
      FileUtils.copyFile(getUpload(), destFile);

      paramClass = new adminBookVO();
      resultClass = new adminBookVO();

      paramClass.setB_no(getB_no());
      paramClass.setB_img(getUploadFileName());

      sqlMapper.update("adminBook.updateImage", paramClass);

      resultClass = (adminBookVO) sqlMapper.queryForObject("adminBook.selectOne", getB_no());

      return SUCCESS;
   }

   public String execute() throws Exception {

      return SUCCESS;
   }

   public File getUpload() {
      return upload;
   }

   public void setUpload(File upload) {
      this.upload = upload;
   }

   public String getUploadContentType() {
      return uploadContentType;
   }

   public void setUploadContentType(String uploadContentType) {
      this.uploadContentType = uploadContentType;
   }

   public String getUploadFileName() {
      return uploadFileName;
   }

   public void setUploadFileName(String uploadFileName) {
      this.uploadFileName = uploadFileName;
   }

   public String getFileUploadPath() {
      return fileUploadPath;
   }

   public void setFileUploadPath(String fileUploadPath) {
      this.fileUploadPath = fileUploadPath;
   }

   public int getB_no() {
      return b_no;
   }

   public void setB_no(int b_no) {
      this.b_no = b_no;
   }

   public String getB_img() {
      return b_img;
   }

   public void setB_img(String b_img) {
      this.b_img = b_img;
   }

}