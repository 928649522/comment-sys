package cn.comment.dao;

import java.util.List;

import cn.comment.bean.Dic;

public interface DicDao {
    List<Dic> select(String type);
	
}
