package cn.comment.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/comments")
@Controller
public class CommentsController {
	@RequestMapping
	public String init() {
		return "/content/commentList";
	} 
}
