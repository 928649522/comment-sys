package cn.comment.dao;


import java.util.List;

import cn.comment.bean.Ad;


public interface AdDao {
	
	/**
	 * 插入数据
	 * @param ad 所要插入的对象
	 * @return 影响行数
	 * */
   int insert(Ad ad);
   
   
   /**
    * 根据查询条件分页查询
    * @param ad 查询条件：包括广告表的查询字段和分页信息
    * @return 广告列表
    */
   List<Ad> selectByPage(Ad ad);
   
   
   /**
    * 根据主键查询id
    * @param id
    * @return 目标对象
    * */
   Ad selectById(Long id);
   
   
   /**
    * 删除广告
    * @param id 主键
    * @return 影响行数
    * */
   int deleteById(Long id);
   
   int update(Ad ad);
}
