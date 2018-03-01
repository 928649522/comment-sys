package cn.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.comment.bean.Dic;
import cn.comment.dao.DicDao;
import cn.comment.service.DicService;

@Service
public class DicServiceImpl implements DicService {

	@Autowired
	private DicDao  dicDao; 
	@Override
	public List<Dic> getListByType(String type) {
		
		return dicDao.select(type);
	}
     
}
