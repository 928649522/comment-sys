package cn.comment.task;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.comment.dao.BusinessesDao;


@Component("BusinessTask")
public class BusinessTask {
    @Resource  
	private BusinessesDao dao;
    
     private static final Logger log=LoggerFactory.getLogger(BusinessTask.class);
     
     
    public void updateNumber(){
    	try{
    	dao.updateNumber();
        log.info("同步成功");
    	}catch(Exception exception){
    		log.info("同步失败");
    	}
    }
    
}
