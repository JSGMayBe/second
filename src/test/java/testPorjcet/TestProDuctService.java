package testPorjcet;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProService;

public class TestProDuctService {
	ClassPathXmlApplicationContext ctx;
   @Before
   public void init(){
	    ctx=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-mvc.xml","spring-mybatis.xml");
	    
   }
   
   @Test
   public void testFindObjects(){
	   ProService proService = ctx.getBean("proServiceImpl",ProService.class);
       System.out.println("1");
	   Map<String,Object> map = proService.findPageObjects("",null,1);
       System.out.println("2");
	   List<Project> list = (List<Project>)map.get("list");
       PageObject pageObject = (PageObject)map.get("pageObject");
       System.out.println(map.get("list"));
       System.out.println(map.get("pageObject"));
   }
	
   @Test
   public void test(){
	   ProService proService = ctx.getBean("proServiceImpl",ProService.class);
       proService.validById(1, "1,3,4");
   }
   
   @Test
   public void addProject(){
	   ProService proService = ctx.getBean("proServiceImpl",ProService.class);
	   Project p = new Project();
	   p.setName("日本游");
	   p.setCode("123123");
	   proService.addProject(p);
   }
   
   @Test
   public void updateProject(){
	   ProService pro = ctx.getBean("proServiceImpl",ProService.class);
	   Project p = pro.findByid(7);
	   p.setName("余杭游");
	   pro.updateProject(p);
	   
   }
   
   @After
   public void destroy(){
	   
   }
}
