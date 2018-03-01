package cn.comment.dao;

import java.util.List;

import cn.comment.bean.Member;

public interface MemberDao {
	
	/**
	 * @param member 查询条件
	 * 
	 * @return 会员列表
	 * */
    public List<Member> select(Member memberCondition);
    
    /**
     * 根据手机号获取用户id
     * 
     * */
    public List<Long> getIdByPhone(Long phone);
}
