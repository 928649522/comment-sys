package cn.comment.service;

import java.util.List;


import cn.comment.dto.AdDto;


public interface AdService {
	boolean  add(AdDto adDto); 
	
	List<AdDto> searchByPage(AdDto adDto);
   
	boolean delete(Long id);
    
    boolean modify(AdDto adDto);

	AdDto getById(Long id);
}
