package cn.comment.dto;

import org.springframework.web.multipart.MultipartFile;

import cn.comment.bean.Business;

public class BusinessDto extends Business{
	private String img;
    private MultipartFile imgFile;
    private String keyword;
    private Integer mumber;
    private Integer star;
    
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public MultipartFile getImgFile() {
        return imgFile;
    }
    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public Integer getMumber() {
        return mumber;
    }
    public void setMumber(Integer mumber) {
        this.mumber = mumber;
    }
	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
	}
	@Override
	public String toString() {
		return "BusinessDto [img=" + img + ", imgFile=" + imgFile
				+ ", keyword=" + keyword + ", mumber=" + mumber + ", star="
				+ star + "]";
	}
	
}
