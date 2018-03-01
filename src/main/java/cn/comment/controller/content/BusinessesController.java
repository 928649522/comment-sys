package cn.comment.controller.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.comment.constant.DicTypeConst;
import cn.comment.constant.PageCodeEnum;
import cn.comment.dto.BusinessDto;
import cn.comment.service.BusinessesService;

@Controller
@RequestMapping("/businesses")
public class BusinessesController {
	@Autowired
	private BusinessesService businessesService;
   @RequestMapping(method=RequestMethod.GET)
   public String initBusinesses(Model model){
	   BusinessDto searchParam=new BusinessDto();
	   List<BusinessDto> result= businessesService.searchByPage(searchParam);
	   model.addAttribute("list", result);
	   //cityDic
	   model.addAttribute("searchParam", searchParam);
	   return"/content/businessList";
   }
   
   @RequestMapping(method=RequestMethod.POST)
   public String add(BusinessDto businessDto,Model model){
	   if(businessDto!=null){
		   businessesService.add(businessDto);
		   model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
	   }else{
		   model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
		   return null; 
	   }
	   return "/content/businessAdd";
   }
   
   @RequestMapping(value="/addPage",method=RequestMethod.GET)
   public String addInit(Model model){
	   model.addAttribute("cityList",businessesService.getListByType(DicTypeConst.CITY));
	   model.addAttribute("categoryList", businessesService.getListByType(DicTypeConst.CATEGORY));
	   return "/content/businessAdd";
   }
   @RequestMapping(value="/{id}",method=RequestMethod.GET)
   public String modifyInit(@PathVariable("id") Long id,Model model){
	   model.addAttribute("modifyObj", businessesService.findInfoById(id));
	   model.addAttribute("cityList",businessesService.getListByType(DicTypeConst.CITY));
	   model.addAttribute("categoryList", businessesService.getListByType(DicTypeConst.CATEGORY));

	   return  "/content/businessModify";
   }
   
   @RequestMapping(value="/{id}",method=RequestMethod.PUT)
   public String modify(@PathVariable Long id,BusinessDto dto,Model model){
	   dto.setId(id);
	   model.addAttribute("modifyObj", dto);
	  if(businessesService.modify(dto)){
		  model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.UPDATE_SUCCESS);
		  model.addAttribute("cityList",businessesService.getListByType(DicTypeConst.CITY));
		  model.addAttribute("categoryList", businessesService.getListByType(DicTypeConst.CATEGORY));
	  }else{
		  model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.UPDATE_FAIL);
	  }
	  return  "/content/businessModify";
   }
   @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
   public String remove(@PathVariable("id") Long id,RedirectAttributes model){
	   if(businessesService.remove(id)){
		   model.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.DELETE_SUCCESS);
	   }else{
		   model.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.DELETE_FAIL);
	   }
	   return "redirect:/businesses";
   }
}
