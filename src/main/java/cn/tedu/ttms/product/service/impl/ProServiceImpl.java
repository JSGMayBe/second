package cn.tedu.ttms.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.tedu.ttms.common.exception.ServiceException;
import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.product.dao.ProDao;
import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProService;
@Service
public class ProServiceImpl implements ProService{
    @Autowired
	private ProDao proDao;
	@Override
	public Map<String, Object> findPageObjects(String name, Integer valid, int pageCurrent) {
        int pageSize=2;
        int startIndex = (pageCurrent-1)*pageSize;
        List<Project> list = proDao.findObjects(name, valid, startIndex, pageSize);
        System.out.println("1:"+name);
        int rowCount = proDao.getRowCount(name, valid);
        System.out.println("gg:"+rowCount);
        PageObject pageObject = new PageObject();
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRowCount(rowCount);
        pageObject.setStartIndex(startIndex);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list", list);
        map.put("pageObject", pageObject);
		return map;
	}
	@Override
	public void validById(Integer valid, String ids) {
		if(valid!=0&&valid!=1){
			throw new ServiceException("validֵ���Ϸ�");
		}
		if(StringUtils.isEmpty(ids)){
			throw new ServiceException("ids֮����Ϊ��");
		}
		String[] id = ids.split(",");
        int row=proDao.validById(valid, id);
	    if(row==0){
	    	throw new ServiceException("�޸�ʧ��");
	    }
	}
	@Override
	public void addProject(Project project) {
       if(project==null){		
    	   throw new ServiceException("���������Ϊ��");
       }
       int row = proDao.insertProject(project);
       if(row<=0){
    	   throw new ServiceException("����ʧ��");
       }
	}
	@Override
	public void updateProject(Project project) {
		if(project==null){
			throw new ServiceException("�޸Ķ�����Ϊ��");
		}
		int rows = proDao.updateProject(project);
		if(rows<=0){
			throw new ServiceException("�޸�ʧ��");
		}
	}
	@Override
	public Project findByid(Integer id) {
		if(id==null){
			throw new ServiceException("��ѡ��һ������");
		}
			Project project = proDao.findById(id);
		if(project==null){
			throw new ServiceException("���󲻴���");
		}
		return project;
	}
	

}
