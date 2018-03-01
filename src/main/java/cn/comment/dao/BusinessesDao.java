package cn.comment.dao;

import java.util.List;

import cn.comment.bean.Business;
import cn.comment.bean.Dic;

public interface BusinessesDao {
   List<Business> selectByPage(Business business);
   
   int insert(Business business);
   
   List<Dic>getListByType(String type);
   
   Business findInfoById(Long id);

   int update(Business business);
   
   List<Business> selectLikeByPage(Business business);
   
   int delete(Long id);
   
   int updateNumber();
   
}
