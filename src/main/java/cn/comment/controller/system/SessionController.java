package cn.comment.controller.system;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.comment.constant.SessionKeyConst;
import cn.comment.dto.MenuDto;

/**
 * session相关，从session中获取存放的资源
 */
@Controller
@RequestMapping("/session")
public class SessionController {
	@Autowired
	private HttpSession session;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/menus",method = RequestMethod.GET)
	@ResponseBody
	public List<MenuDto> getUserMenuList(MenuDto menuDto) {
		return (List<MenuDto>)session.getAttribute(SessionKeyConst.MENU_INFO);
	}

	/**
	 * 退出系统
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public String signOut() {
		session.invalidate();
		return "redirect:/login";
	}
}