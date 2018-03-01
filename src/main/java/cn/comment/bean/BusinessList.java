package cn.comment.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)//  作用是实体类的参数查询到的为null的不显示
public class BusinessList {
   private List<Business> data;
   private boolean hasMore;

public List<Business> getData() {
	return data;
}
public void setData(List<Business> data) {
	this.data = data;
}
public boolean isHasMore() {
	return hasMore;
}
public void setHasMore(boolean hasMore) {
	this.hasMore = hasMore;
}

   
}
