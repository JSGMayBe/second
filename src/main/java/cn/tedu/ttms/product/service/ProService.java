package cn.tedu.ttms.product.service;

import java.util.Map;

import cn.tedu.ttms.product.entity.Project;

public interface ProService {
     
	Map<String,Object> findPageObjects(String name,Integer valid,int pageCurrent);

    void validById(Integer valid,String ids);
    
    void addProject(Project project);
    
    void updateProject(Project project);
    
    Project findByid(Integer id);
}
