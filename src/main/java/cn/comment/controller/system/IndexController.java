package cn.comment.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	/**
	 * 登陆成功后回到主页面
	 * */
	@RequestMapping
   public String init(){
		System.out.println("-----------------");
	   return "/system/index";
   }
}
