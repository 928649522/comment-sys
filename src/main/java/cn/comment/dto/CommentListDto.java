package cn.comment.dto;

import java.util.List;

public class CommentListDto {
     private List<CommentDto> data;
     private String hasMore;
	public List<CommentDto> getData() {
		return data;
	}
	public void setData(List<CommentDto> data) {
		this.data = data;
	}
	public String getHasMore() {
		return hasMore;
	}
	public void setHasMore(String hasMore) {
		this.hasMore = hasMore;
	}
     
     
}
