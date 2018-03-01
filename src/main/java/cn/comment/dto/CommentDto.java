package cn.comment.dto;

import cn.comment.bean.Comment;

public class CommentDto extends Comment {
   private Long phone;

public Long getPhone() {
	return phone;
}

public void setPhone(Long phone) {
	this.phone = phone;
}
   
}
