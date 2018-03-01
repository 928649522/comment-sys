package cn.comment.service;

import cn.comment.bean.Page;
import cn.comment.dto.CommentForSubmitDto;
import cn.comment.dto.CommentListDto;

public interface CommentService {
   boolean add(CommentForSubmitDto submitDto);
   CommentListDto searchByPage(Long id, Page page);
}
