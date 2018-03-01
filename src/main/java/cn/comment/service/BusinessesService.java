package cn.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.comment.bean.Dic;
import cn.comment.dto.BusinessDto;
import cn.comment.dto.BusinessListDto;

@Service
public interface BusinessesService {
    List<BusinessDto> searchByPage(BusinessDto businessDto);
    
    boolean add(BusinessDto businessDto);
    
    List<Dic> getListByType(String type);

    BusinessDto findInfoById(Long id);

	boolean modify(BusinessDto dto);

	boolean remove(Long id);

	/***/
	BusinessDto detailInfo(Long id);
	/**
	 *@param 条件
	 *api中获得商户信息
	 * */
	 BusinessListDto serachByPageForApi(BusinessDto businessDto);
}
