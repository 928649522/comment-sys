package cn.comment.service;

import java.util.List;

import cn.comment.bean.Dic;


public interface DicService {
	   /**
     * 根据类型获取字典表列表
     * @param type 类型
     * @return 字典表列表
     */
    public List<Dic> getListByType(String type);
}
