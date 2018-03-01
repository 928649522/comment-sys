package cn.comment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.comment.bean.Business;
import cn.comment.bean.Orders;
import cn.comment.constant.CommentStateConst;
import cn.comment.dao.BusinessesDao;
import cn.comment.dao.MemberDao;
import cn.comment.dao.OrdersDao;
import cn.comment.dto.OrdersDto;
import cn.comment.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private  MemberDao memberDao;
	
	@Autowired
	private BusinessesDao businessesDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Value("${businessImage.url}")
	private String businessImageURL;
	
	@Override
	public Long getIdByPhone(Long phone) {
		List<Long> list=memberDao.getIdByPhone(phone);
		if(list!=null&&list.size()==1){
			return list.get(0);
		}
		return null;
	}
	@Override
	public boolean add(OrdersDto ordersDto) {
        Orders orders=new Orders();
        BeanUtils.copyProperties(ordersDto, orders);
        orders.setCommentState(CommentStateConst.NOT_COMMENT);
        return ordersDao.insert(orders)==1;
		
	}
	@Override
	public List<OrdersDto> getListById(Long id) {
		List <Orders> list=ordersDao.selectById(id);
		if(list!=null&&list.size()>0){
			List<OrdersDto> result=new ArrayList<OrdersDto>();
			for(Orders orders:list){
				OrdersDto dto=new OrdersDto();
				BeanUtils.copyProperties(orders, dto);
				Business business=businessesDao.findInfoById(dto.getBusinessId());
				dto.setImg(businessImageURL+business.getImgFileName());
				dto.setTitle(business.getTitle());
				dto.setCount(business.getNumber());
				result.add(dto);
			}
			return result;
		}
		return null;
	}
	@Override
	public Long getMemberIdById(Long id) {
		Orders orders=new Orders();
		orders.setId(id);
		System.out.println("orderId----+++++++++++++++------------->"+id);
		List<Orders> list=ordersDao.select(orders);
		if(list!=null&&list.size()>0){
			Orders result=list.get(0);
			return result.getMemberId();
		}
		return null;
	}

}
