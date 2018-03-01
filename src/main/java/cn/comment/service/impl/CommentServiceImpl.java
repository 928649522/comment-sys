package cn.comment.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.comment.bean.Comment;
import cn.comment.bean.Orders;
import cn.comment.bean.Page;
import cn.comment.constant.CommentStateConst;
import cn.comment.dao.CommentDao;
import cn.comment.dao.OrdersDao;
import cn.comment.dto.CommentForSubmitDto;
import cn.comment.dto.CommentListDto;
import cn.comment.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Override
	@Transactional
	public boolean add(CommentForSubmitDto submitDto) {
		Comment comment=new Comment();
		BeanUtils.copyProperties(submitDto, comment);
		comment.setId(null);
		comment.setCreateTime(new Date());
		comment.setOrdersId(submitDto.getId());
		//如果插入和跟新评论状态有影响且唯一，说明插入成功
	    
	    Orders orders=new Orders();
	    orders.setId(submitDto.getId());
	    orders.setCommentState(CommentStateConst.HAS_COMMENT);
	   if(commentDao.insert(comment)==1&& 
			   ordersDao.update(orders)==1){
		  	return true; 
	   }else{
		   return false;
	   }
	  
	}

	@Override
	public CommentListDto searchByPage(Long id, Page page) {
		
		return null;
	}
    
}
