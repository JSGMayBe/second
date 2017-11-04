package cn.tedu.ttms.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.product.entity.Project;

public interface ProDao {
	/**
     * @param name 查询时用户输入的项目名
     * @param valid 查询时用户输入的状态
     * @param startIndex 分页位置的起始位置
     * @param pageSize   分页最多显示多少条记录
     * @return   当前页数据
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
