package cn.comment.service;

import java.util.List;

import cn.comment.dto.OrdersDto;

public interface OrdersService {
	public Long getIdByPhone(Long phone);
   public Long getMemberIdById(Long id);
	public boolean add(OrdersDto ordersDto);
	/**
	 * @param id  手机号
	 * @return 所有该id的订单
	 * */
	public List<OrdersDto> getListById(Long id);
}
