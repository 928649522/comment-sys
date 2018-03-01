package cn.comment.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.comment.bean.Ad;
import cn.comment.dao.AdDao;
import cn.comment.dto.AdDto;
import cn.comment.service.AdService;
import cn.comment.util.FileUtil;
@Service
public class AdServiceImpl implements AdService {
    @Autowired
	private AdDao adDao;
    @Value("${adImage.savePath}")
    private String adImageSavePath;

    @Value("${adImage.url}")
    private String adImageURL;

   
	@Override
	//TODO 可以改成返回获取详细情况
	public boolean add(AdDto adDto) {
		 Ad ad=new Ad();
		 ad.setTitle(adDto.getTitle());
		 ad.setLink(adDto.getLink());
		 ad.setWeight(adDto.getWeight());
		 //前端表单验证有不稳定性，因此后台一定要验证
		 if(adDto.getImgFile()!=null&&adDto.getImgFile().getSize()>0){
			 String fileName=System.currentTimeMillis()+"_"+adDto.getImgFile().getOriginalFilename();
			 File file=new File(adImageSavePath+fileName);
			 File fileFloder=new File(adImageSavePath);
			 if(!fileFloder.exists()){//如果目录不存在就创建所有目录。
				 fileFloder.mkdirs();
			 }
			 try {
				 adDto.getImgFile().transferTo(file);
				ad.setImgFileName(fileName);
				adDao.insert(ad);  
				return true;
			} catch (IllegalStateException | IOException e) {
				//TODO 需要添加日志
				e.printStackTrace();
				return false;
			}
			
		 }else{
			 return false;
		 }
	}
	
	@Override
	//根据页数搜寻
	public List<AdDto> searchByPage(AdDto adDto){
		List<AdDto> result=new ArrayList<AdDto>();
		Ad condition=new Ad();
	   BeanUtils.copyProperties(adDto, condition);
	   List<Ad> ads=adDao.selectByPage(condition);
	   for(Ad ad:ads){
		   AdDto dto=new AdDto();
		   BeanUtils.copyProperties(ad, dto);
		   dto.setImg(adImageURL+ad.getImgFileName());
		   dto.setImgFileName(adImageURL+ad.getImgFileName());
		   result.add(dto);
	   }
	   return result;
	}
	
	
	@Override
	public boolean delete(Long id) {
		Ad ad=adDao.selectById(id);
		int deleteRows=adDao.deleteById(id);
		FileUtil.delete(adImageSavePath+ad.getImgFileName());
		return deleteRows==1;
	}

	@Override
	public boolean modify(AdDto adDto) {
		// TODO Auto-generated method stub
		Ad ad=new Ad();
		String fileName=null;
		BeanUtils.copyProperties(adDto, ad);
		MultipartFile picture=adDto.getImgFile();
		if(picture!=null&&picture.getSize()>0){
			try {
				fileName=FileUtil.save(adDto.getImgFile(), adImageSavePath);
				ad.setImgFileName(fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int updateRows=adDao.update(ad);
		if(updateRows!=1){
			return false;
		}
		if(fileName!=null){
			return FileUtil.delete(adImageSavePath+adDto.getImgFileName());
		}
		return true;
	}

	@Override
	public AdDto getById(Long id) {
		// TODO Auto-generated method stub
		Ad ad=adDao.selectById(id);
		if(ad!=null){
			AdDto adDto=new AdDto();
			BeanUtils.copyProperties(ad, adDto);
			adDto.setImg(adImageURL+ad.getImgFileName());
		    return adDto;
		}
		return null;
	}
	

}
