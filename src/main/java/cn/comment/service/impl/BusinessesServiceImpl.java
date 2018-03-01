package cn.comment.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.comment.bean.Business;
import cn.comment.bean.Dic;
import cn.comment.constant.CategoryConst;
import cn.comment.dao.BusinessesDao;
import cn.comment.dao.DicDao;
import cn.comment.dto.BusinessDto;
import cn.comment.dto.BusinessListDto;
import cn.comment.service.BusinessesService;
import cn.comment.util.CommonUtil;
import cn.comment.util.FileUtil;

@Service
public  class BusinessesServiceImpl implements BusinessesService {

	@SuppressWarnings("unused")
	private boolean hashMore=true;
	@Autowired
	private BusinessesDao businessesDao;
	
	@Autowired
	private DicDao dicDao;
	
	@Value("${businessImage.savePath}")
	private String businessImageSavePath;
	
	@Value("${businessImage.url}")
	private String businessImageURL;
	@Override
	public List<BusinessDto> searchByPage(BusinessDto businessDto) {
		Business business=new Business();
		List<BusinessDto> result=new ArrayList<BusinessDto>();
		BeanUtils.copyProperties(businessDto, business);
		List<Business> list=businessesDao.selectByPage(business);
		for(Business tempBusiness:list){
			BusinessDto dto=new BusinessDto();
			BeanUtils.copyProperties(tempBusiness, dto);
			dto.setImg(businessImageURL+tempBusiness.getImgFileName());
			dto.setStar(this.getStar(tempBusiness));
			result.add(dto);
		}
		return result;
	}
	@Override
	public boolean add(BusinessDto businessDto) {
		Business business=new Business();
	    BeanUtils.copyProperties(businessDto, business);
	    MultipartFile imageFile=businessDto.getImgFile();
	    if(imageFile!=null&&imageFile.getSize()>0){
	    	//TODO 必须包含图片才能插入成功
	    	try {
	    		String fileName=FileUtil.save(imageFile, businessImageSavePath);
				business.setImgFileName(fileName);
				businessesDao.insert(business);
				return true;
			} catch (IllegalStateException | IOException e) {
				// TODO 打印logo
				e.printStackTrace();
			}
	    }
		return false;
	}
	@Override
	public List<Dic> getListByType(String type) {
		// TODO Auto-generated method stub
		return dicDao.select(type);
		 
	}
	
	private int getStar(Business business) {
		if(business.getStarTotalNum() != null && business.getCommentTotalNum() != null && business.getCommentTotalNum() != 0) {
			return (int)(business.getStarTotalNum() / business.getCommentTotalNum());
		} else {
			return 0;
		}
	}
	@Override
	public BusinessDto findInfoById(Long id) {
		BusinessDto businessDto=new BusinessDto();
		Business business =businessesDao.findInfoById(id);
		BeanUtils.copyProperties(business, businessDto);
		businessDto.setImg(businessImageURL+business.getImgFileName());
		return businessDto;
	}
	@Override
	public boolean modify(BusinessDto dto) {
		MultipartFile multipartFile=dto.getImgFile();
		Business business=new Business();
		String fileName=null;
		BeanUtils.copyProperties(dto, business);
		if(multipartFile!=null&&multipartFile.getSize()>0){
			try {
				fileName=FileUtil.save(multipartFile, businessImageSavePath);
				business.setImgFileName(fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int updateRows=businessesDao.update(business);
		if(updateRows!=1){
			return false;
		}
		if(fileName!=null){
			FileUtil.delete(businessImageSavePath+dto.getImgFileName());
		}
		return true;
	}
	@Override
	public boolean remove(Long id) {
		Business business=businessesDao.findInfoById(id);
		if(business!=null){
			int deleteRows=businessesDao.delete(id);
			FileUtil.delete(businessImageSavePath+business.getImgFileName());
			return deleteRows==1;
		}else{
			return false;
		}
	}
	
	
	@Override
	public BusinessListDto serachByPageForApi(BusinessDto businessDto){
        Business businessSelect=new Business();
        BusinessListDto result=new BusinessListDto();
    	List<BusinessDto> BusinessDtolist=new ArrayList<BusinessDto>();
        BeanUtils.copyProperties(businessDto, businessSelect);
        if(!CommonUtil.isEmpty(businessDto.getKeyword())){
        	businessSelect.setTitle(businessDto.getKeyword());
        	businessSelect.setSubtitle(businessDto.getKeyword());
        	businessSelect.setDesc(businessDto.getKeyword());
        }
        if(businessSelect.getCategory()!=null&&CategoryConst.ALL.equals(businessSelect.getCategory())){
        	businessSelect.setCategory(null);
        }
        //app前端的页数是从1开始的
        int currentPage=businessSelect.getPage().getCurrentPage()+1;
        businessSelect.getPage().setCurrentPage(currentPage);
		List<Business> list=businessesDao.selectLikeByPage(businessSelect);
			for(Business b:list){
				BusinessDto dto=new BusinessDto();
				BeanUtils.copyProperties(b, dto);
				dto.setImg(businessImageURL+dto.getImgFileName());
				dto.setMumber(dto.getNumber());
				dto.setStar(this.getStar(b));
				BusinessDtolist.add(dto);
			}
			if(currentPage>businessSelect.getPage().getTotalPage()){
				result.setHasMore(false);
			}
			System.out.println(BusinessDtolist.get(0).toString());
			result.setData(BusinessDtolist);
		
		return result;
	}
	@Override
	public BusinessDto detailInfo(Long id) {
		// TODO Auto-generated method stub
		
		return this.findInfoById(id);
	}
}
