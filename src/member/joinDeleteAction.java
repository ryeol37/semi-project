package member;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.io.IOException;

	public class joinDeleteAction extends ActionSupport {
		public static Reader reader;
		public static SqlMapClient sqlMapper;

		private memberVO paramClass; //�Ķ���͸� ������ ��ü
		private memberVO resultClass; //���� ��� ���� ������ ��ü

			
		private String m_id;
		
		
		// ������
		public joinDeleteAction() throws IOException {
			
			reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
			reader.close();
		}

		// �Խñ� �� ����
		public String execute() throws Exception {
			
			//�Ķ���Ϳ� ����Ʈ ��ü ����.
			paramClass = new memberVO();
			resultClass = new memberVO();
			
			// �ش� ��ȣ�� ���� �����´�.
			resultClass = (memberVO) sqlMapper.queryForObject("join.selectMemberOne", getM_id());


			paramClass.setM_id(getM_id());
					
			// ���� ���� ����.
			sqlMapper.update("join.deleteJoin", paramClass);

			return SUCCESS;
		}

		public memberVO getParamClass() {
			return paramClass;
		}

		public void setParamClass(memberVO paramClass) {
			this.paramClass = paramClass;
		}

		public memberVO getResultClass() {
			return resultClass;
		}

		public void setResultClass(memberVO resultClass) {
			this.resultClass = resultClass;
		}

		public String getM_id() {
			return m_id;
		}

		public void setM_id(String m_id) {
			this.m_id = m_id;
		}

	}
		