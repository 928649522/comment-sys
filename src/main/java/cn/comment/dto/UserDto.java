package cn.comment.dto;

import cn.comment.bean.User;

public class UserDto extends User{
    
	private Integer pId;

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	@Override
	public String toString() {
		return "UserDto [pId=" + pId + ", getpId()=" + getpId()
				+ ", getName()=" + getName() + ", getPassword()="
				+ getPassword() + ", getChName()=" + getChName() + ", getId()="
				+ getId() + ", getGroupId()=" + getGroupId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
