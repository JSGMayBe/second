package cn.tedu.ttms.product.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.web.JsonResult;
import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProService;

@Controller
@RequestMapping("/project/")
public class controller {
     @Resource(name="proServiceImpl")
     private ProService proService;
     
     @RequestMapping("listUI")
     public String listUI(){
    	 return "product/project_list";
     }
     
     @RequestMapping("editUI")
     public String eidtUI(){
    	 return "product/project_edit";
     }
     
     @RequestMapping("doGetObjects.do")
     @ResponseBody
     public JsonResult doGetObjects(String name,
    		 Integer valid,Integer pageCurrent){
    	 System.out.println(name+",::::"+valid);
    	 Map<String,Object> map = proService.findPageObjects(name, valid, pageCurrent);
    	 System.out.println(map);
    	 return new JsonResult(map);
     }
     
     @RequestMapping("daoValidById.do")
     @ResponseBody
     public JsonResult  daoValidById(Integer valid,String ids){
    	 proService.validById(valid, ids);
         return new JsonResult(valid==1?"∆Ù”√OK":"Ω˚”√OK");
     }
     
     @RequestMapping("doSave.do")
     @ResponseBody
     public JsonResult doSave(Project project){
    	 proService.addProject(project);
    	 return new JsonResult("insert ok");
     }
     
     @RequestMapping("doFindById")
     @ResponseBody
     public JsonResult doFindById(Integer id){
    	 Project p = proService.findByid(id);
    	 return new JsonResult(p);
     }
     
     @RequestMapping("doUpdate")
     @ResponseBody
     public JsonResult doUpdate(Project project){
    	 proService.updateProject(project);
    	 return new JsonResult("update ok");
     }
     
}

