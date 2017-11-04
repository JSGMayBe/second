package cn.tedu.ttms.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.product.entity.Project;

public interface ProDao {
	/**
     * @param name ��ѯʱ�û��������Ŀ��
     * @param valid ��ѯʱ�û������״̬
     * @param startIndex ��ҳλ�õ���ʼλ��
     * @param pageSize   ��ҳ�����ʾ��������¼
     * @return   ��ǰҳ����
     */
	
	List<Project> findObjects(
		@Param("name")String name,
		@Param("valid")Integer valid,
		@Param("startIndex")int startIndex,
		@Param("pageSize") int pageSize
			);
	
	
	int  getRowCount(
	    @Param("name")String name,
	    @Param("valid")Integer valid
			);
	
	int validById(
			@Param("valid")Integer id,
			@Param("ids")String[] ids
			);
	
	int insertProject(
			Project project
			);
	
	int updateProject(
			Project project
			);
	
	Project findById(
			Integer id
			);
	
} 
