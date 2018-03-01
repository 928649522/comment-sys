package cn.comment.dto;

import java.util.List;


public class BusinessListDto {
	private List<BusinessDto> data;
    private boolean hasMore;
	public List<BusinessDto> getData() {
		return data;
	}
	public void setData(List<BusinessDto> data) {
		this.data = data;
	}
	public boolean isHasMore() {
		return hasMore;
	}
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
    
    
}
