package cn.comment.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.comment.constant.PageCodeEnum;
import cn.comment.dto.AdDto;
import cn.comment.service.AdService;

@Controller
@RequestMapping("/ad")
public class AdController {
   @Autowired
   private AdService adService;
  @RequestMapping
  public String init(Model model){
	  AdDto adDto=new AdDto();
	  model.addAttribute("list", adService.searchByPage(adDto));
	  model.addAttribute("searchParam", adDto);
	  return "/content/adList";
  }
  @RequestMapping("addInit")
  public String addInit(){
	  return "/content/adAdd";
  }
  @RequestMapping(value="/add",method=RequestMethod.POST)
  public String add(AdDto adDto,Model model){
	  if(adService.add(adDto)){
		  model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
	  }else{
		  model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
	  }
	  return "/content/adAdd";
  }
  @RequestMapping(value="/search")
 public String search(Model model,AdDto adDto){
	 model.addAttribute("list", adService.searchByPage(adDto));
	 model.addAttribute("searchParam", adDto);
	 return"/content/adList";
  }
  
  
  @RequestMapping(value="/remove")
  public String remove(@RequestParam("id")Long id,Model model){
	  if(adService.delete(id)){
		  model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DELETE_SUCCESS);
		 
	  }else{
		  model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DELETE_FAIL);
	  }
	  return "forward:/ad";
  }
  
  /**
	 * 修改页初始化
	 */
	@RequestMapping("/modifyInit")
	public String modifyInit(Model model, @RequestParam("id") Long id) {
		model.addAttribute("modifyObj", adService.getById(id));
		return "/content/adModify";
	}
	
  @RequestMapping(value="/modify")
  public String modify(AdDto adDto,Model model){
	  model.addAttribute("modifyObj", adDto);
	 if(adService.modify(adDto)){
		 model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.UPDATE_SUCCESS);
		 
	 }else{
		 model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.UPDATE_FAIL);
	 }
	  return "/content/adModify";
  }
}
