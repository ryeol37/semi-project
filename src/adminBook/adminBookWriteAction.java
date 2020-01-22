package adminBook;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import init.initPath;

public class adminBookWriteAction extends ActionSupport{

	public static Reader reader;	//占쏙옙占쏙옙 占쏙옙트占쏙옙占쏙옙 占쏙옙占쏙옙 reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API占쏙옙 占쏙옙占쏙옙歐占� 占쏙옙占쏙옙 sqlMapper 占쏙옙체.

	
	private int b_no;
	private String b_name;
	private String b_writer;
	private String b_pub;
	private String b_pubdate;
	private String b_category;
	private int b_count;
	private String b_intro;
	private String b_writerintro;
	private String b_list;
	private String b_img;
	private String b_imgcopy;
	
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	
	private String fileUploadPath = initPath.getPath();

	
	private adminBookVO paramClass; //占식띰옙占쏙옙拷占� 占쏙옙占쏙옙占쏙옙 占쏙옙체
	private adminBookVO resultClass;
	//占쏙옙占쏙옙징 占쌓쇽옙	
	private int currentPage;	//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
	
	public adminBookWriteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占승댐옙.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 sqlMapper 占쏙옙체 占쏙옙占쏙옙.
		reader.close();
	}
	
	public String form() throws Exception {

		return SUCCESS;
	}
	
	public String execute() throws Exception {
		System.out.println("1111111");
		
		paramClass = new adminBookVO();
		
		paramClass.setB_no(getB_no());
		paramClass.setB_name(getB_name());
		paramClass.setB_writer(getB_writer());
		paramClass.setB_pub(getB_pub());
		paramClass.setB_pubdate(getB_pubdate());
		paramClass.setB_category(getB_category());
		paramClass.setB_intro(getB_intro());
		paramClass.setB_writerintro(getB_writerintro());
		paramClass.setB_list(getB_list());
		
		//System.out.println("22222222");
		
		
			
			resultClass = new adminBookVO();			
			resultClass = (adminBookVO) sqlMapper.queryForObject("adminBook.selectbook");
			
			String file_name = "file_" + resultClass.getB_no();
			String file_ext = getUploadFileName().substring(
					getUploadFileName().lastIndexOf('.') + 1,
					getUploadFileName().length()
					);
			
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			
			paramClass.setB_no(resultClass.getB_no());
			paramClass.setB_img(getUploadFileName());
			paramClass.setB_imgcopy(file_name + "." +file_ext);
	         
	         FileUtils.copyFile(upload, destFile); 
	         System.out.println("44444444");   
	      
		 
		paramClass.setB_img(getUploadFileName());
		
		sqlMapper.insert("adminBook.insertBook", paramClass);
		 
		return SUCCESS;
	}

	
	
	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public String getB_pub() {
		return b_pub;
	}

	public void setB_pub(String b_pub) {
		this.b_pub = b_pub;
	}

	public String getB_pubdate() {
		return b_pubdate;
	}

	public void setB_pubdate(String b_pubdate) {
		this.b_pubdate = b_pubdate;
	}

	public String getB_category() {
		return b_category;
	}

	public void setB_category(String b_category) {
		this.b_category = b_category;
	}

	public String getB_intro() {
		return b_intro;
	}

	public void setB_intro(String b_intro) {
		this.b_intro = b_intro;
	}

	public String getB_writerintro() {
		return b_writerintro;
	}

	public void setB_writerintro(String b_writerintro) {
		this.b_writerintro = b_writerintro;
	}

	public String getB_list() {
		return b_list;
	}

	public void setB_list(String b_list) {
		this.b_list = b_list;
	}

	public String getB_img() {
		return b_img;
	}

	public void setB_img(String b_img) {
		this.b_img = b_img;
	}

	public String getB_imgcopy() {
		return b_imgcopy;
	}

	public void setB_imgcopy(String b_imgcopy) {
		this.b_imgcopy = b_imgcopy;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
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

	public adminBookVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(adminBookVO paramClass) {
		this.paramClass = paramClass;
	}

	public adminBookVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(adminBookVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	
}