package cn.comment.dao;

import java.util.List;

import cn.comment.bean.Orders;

public interface OrdersDao {
	
     Long getIdByPhone(Long phone);

	Integer insert(Orders orders);
	
	List<Orders> selectById(Long id);
	List<Orders> select(Orders orders);
	/**
	 * 修改评价状态
	 * */
    Integer	update(Orders orders);
}
