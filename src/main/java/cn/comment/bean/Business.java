package cn.comment.bean;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Business extends BaseBean{//商户实体
	private long id;
    private String imgFileName;
	private String title;
	private String subtitle;
	private Double price;
	private int distance;//距离
	private int number;
	private String desc;  //排序
	private String category;//种类
	private String city;//
	private Long starTotalNum;//星级
	private Long commentTotalNum;
	
    private Dic cityDic;
    private Dic categoryDic;

	
	public Dic getCityDic() {
		return cityDic;
	}
	public void setCityDic(Dic cityDic) {
		this.cityDic = cityDic;
	}
	public Dic getCategoryDic() {
		return categoryDic;
	}
	public void setCategoryDic(Dic categoryDic) {
		this.categoryDic = categoryDic;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	public Long getStarTotalNum() {
		return starTotalNum;
	}
	public void setStarTotalNum(Long starTotalNum) {
		this.starTotalNum = starTotalNum;
	}
	public Long getCommentTotalNum() {
		return commentTotalNum;
	}
	public void setCommentTotalNum(Long commentTotalNum) {
		this.commentTotalNum = commentTotalNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


	
}
