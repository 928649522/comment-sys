package cn.comment.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.comment.bean.Member;
import cn.comment.cache.CodeCache;
import cn.comment.cache.TokenCache;
import cn.comment.dao.MemberDao;
import cn.comment.service.MemberService;
import cn.comment.util.CommonUtil;
import cn.comment.util.MD5Util;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(MemberService.class);
	@Override
	public boolean exists(Long phone) {
		if(phone!=null){
			Member memberCondition=new Member();
			memberCondition.setPhone(phone);
			List<Member> list=memberDao.select(memberCondition);
			return list.size()==1;
		}
		return false;
		
	}
	@Override
	public boolean saveCode(Long username, String code) {
		CodeCache cache=CodeCache.getCodeCache();
		if(cache.save(username, MD5Util.getMD5(code))){
			return true;
		}
		return false;
	}
	@Override
	public boolean sendCode(Long username, String code) {
		LOGGER.info(username+"--------code----->"+code);
		return true;
	}
	@Override
	public String getCode(Long phone) {
		CodeCache codeCache=CodeCache.getCodeCache();
		return codeCache.getCode(phone);
	}
	@Override
	public void saveToken(String token, Long phone) {
		if(token==null){
			token=CommonUtil.getUUID();
		}
		TokenCache cache=TokenCache.getInstance();
		cache.saveToken(token, phone);
	}
	@Override
	public Long getIdByPhone(Long phone) {
		List<Long> list=memberDao.getIdByPhone(phone);
		if(list!=null&&list.size()==1){
			return list.get(0);
		}
		return null;
	}
	@Override
	public Long getPhone(String token) {
		// TODO Auto-generated method stub
		return TokenCache.getInstance().getPhoneByToken(token);
	}

}
