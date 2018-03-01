package cn.comment.controller.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cn.comment.bean.Page;
import cn.comment.constant.ApiCodeEnum;
import cn.comment.dto.AdDto;
import cn.comment.dto.ApiCodeDto;
import cn.comment.dto.BusinessDto;
import cn.comment.dto.BusinessListDto;
import cn.comment.dto.CommentForSubmitDto;
import cn.comment.dto.CommentListDto;
import cn.comment.dto.OrderForBuyDto;
import cn.comment.dto.OrdersDto;
import cn.comment.service.AdService;
import cn.comment.service.BusinessesService;
import cn.comment.service.CommentService;
import cn.comment.service.MemberService;
import cn.comment.service.OrdersService;
import cn.comment.util.CommonUtil;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private AdService adService;
	
	@Autowired
	private BusinessesService businessesService;
	
	@Autowired 
	private MemberService memberService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private CommentService commentService;	
	
	@Value("${ad.pageNumber}")
	private Integer adPageNumber;
	
	@Value("${business.pageNumber}")
	private Integer businessPageNumber;
	
	
	//模拟数据
	/*@RequestMapping(value="/homead" , method=RequestMethod.GET)
    public List<Ad> homead() throws JsonParseException, JsonMappingException, IOException{
    	ObjectMapper mapper=new ObjectMapper();
    	String s="[{\"title\":\"暑假5折\",\"imgFileName\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191639092-2000037796.png\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"特价出国\",\"imgFileName\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191648124-298129318.png\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"亮亮车\",\"imgFileName\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191653983-1962772127.png\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"学钢琴\",\"imgFileName\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191700420-1584459466.png\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"电影\",\"imgFileName\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191706733-367929553.png\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"旅游热线\",\"imgFileName\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191713186-495002222.png\",\"link\":\"http://www.imooc.com/wap/index\"}]";
    	return mapper.readValue(s, new TypeReference<List<Ad>>(){});
    }*/
	
	
	// 首页 —— 广告（超值特惠）
	@RequestMapping(value="/homead" , method=RequestMethod.GET)
    public List<AdDto> homead() {
        AdDto adDto=new AdDto();
        adDto.getPage().setPageNumber(adPageNumber);
        return adService.searchByPage(adDto);
	}
	
	/*// 首页 —— 推荐列表（猜你喜欢） 模拟数据
	@RequestMapping(value="/homelist/{city}/{page}",method=RequestMethod.GET)
	public BusinessList homeList() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper=new ObjectMapper();
    	String s="{\"hasMore\":true,\"data\":[{\"imgFileName\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201638030-473660627.png\",\"title\":\"汉堡大大\",\"subTitle\":\"叫我汉堡大大，还你多彩口味\",\"price\":\"28\",\"distance\":\"120\",\"number\":\"389\",\"id\":\"08970018649793943\"},{\"imgFileName\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201645858-1342445625.png\",\"title\":\"北京开源饭店\",\"subTitle\":\"[望京]自助晚餐\",\"price\":\"98\",\"distance\":\"140\",\"number\":\"689\",\"id\":\"22100113677893063\"},{\"imgFileName\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201652952-1050532278.png\",\"title\":\"服装定制\",\"subTitle\":\"原价xx元，现价xx元，可修改一次\",\"price\":\"1980\",\"distance\":\"160\",\"number\":\"106\",\"id\":\"22074364008715652\"},{\"imgFileName\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201700186-1351787273.png\",\"title\":\"婚纱摄影\",\"subTitle\":\"免费试穿，拍照留念\",\"price\":\"2899\",\"distance\":\"160\",\"number\":\"58\",\"id\":\"9863834351321439\"},{\"imgFileName\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201708124-1116595594.png\",\"title\":\"麻辣串串烧\",\"subTitle\":\"双人免费套餐等你抢购\",\"price\":\"0\",\"distance\":\"160\",\"number\":\"1426\",\"id\":\"8833435634504967\"}]}";
    	     	return mapper.readValue(s, new TypeReference<BusinessList>(){});
    } */
	
	
	// 首页 —— 推荐列表（猜你喜欢）
	@RequestMapping(value="/homelist/{city}/{page.currentPage}",method=RequestMethod.GET)
	public BusinessListDto homeList(BusinessDto businessDto) {
		businessDto.getPage().setPageNumber(businessPageNumber);
    	return businessesService.serachByPageForApi(businessDto);
    }
	
	/**
	 * 搜索结果页 - 搜索结果 - 三个参数
	 */
	@RequestMapping(value="/search/{page.currentPage}/{city}/{category}/{keyword}",method=RequestMethod.GET)
	public BusinessListDto searchByKeyword(BusinessDto businessDto){
		businessDto.getPage().setPageNumber(businessPageNumber);
		return businessesService.serachByPageForApi(businessDto);
	}
	
	@RequestMapping(value="/search/{page.currentPage}/{city}/{category}",method=RequestMethod.GET)
	public BusinessListDto search(BusinessDto businessDto){
		businessDto.getPage().setPageNumber(businessPageNumber);
		return businessesService.serachByPageForApi(businessDto);
	}
	
	// 详情页 - 商户信息
	@RequestMapping(value="/detail/info/{id}" ,method=RequestMethod.GET)
	public BusinessDto detailInfo(@PathVariable("id")Long id){
		BusinessDto businessDto=businessesService.detailInfo(id);
		System.out.println(businessDto.toString());
		return  businessDto;
	}

	@RequestMapping(value="/submitComment",method=RequestMethod.POST)
   public ApiCodeDto submitComment(CommentForSubmitDto submitDto){
		ApiCodeDto result;
		String token=submitDto.getToken();
		Long phone=memberService.getPhone(token);
		if(phone!=null&&phone.equals(submitDto.getUsername())){
		   Long memberId=memberService.getIdByPhone(phone);
		   if(memberId.equals(ordersService.getMemberIdById(submitDto.getId()))){
			   commentService.add(submitDto);
			   result=new ApiCodeDto(ApiCodeEnum.SUCCESS);
		   }else{
			   result=new ApiCodeDto(ApiCodeEnum.NO_AUTH);
		   }
		}else{
			result=new ApiCodeDto(ApiCodeEnum.NOT_LOGGED);
		}
		return result;
   }
	
	
   @RequestMapping(value="/sms",method=RequestMethod.POST)
	public  ApiCodeDto sms(@RequestParam("username") Long username){
	   ApiCodeDto apiCodeDto;
	   
	   if(memberService.exists(username)){
		   String code=String.valueOf(CommonUtil.random(6));
		   if(memberService.saveCode(username,code)){
			   if(memberService.sendCode(username,code)){
				   apiCodeDto=new ApiCodeDto(ApiCodeEnum.SUCCESS.getErrno(),code);
			   }else{
				   apiCodeDto=new ApiCodeDto(ApiCodeEnum.SEND_FAIL);
			   }
		   }else{
			   apiCodeDto=new ApiCodeDto(ApiCodeEnum.REPEAT_REQUEST);
		   }
	   }else{
		   apiCodeDto=new ApiCodeDto(ApiCodeEnum.USER_NOT_EXISTS);
	   }
	 return apiCodeDto;   
   } 
   
   @RequestMapping(value="/login",method=RequestMethod.POST)
   public ApiCodeDto login(@RequestParam("username")Long username,
		   @RequestParam("code")String code){
	   ApiCodeDto apiCodeDto=null;
	   String saveCode=memberService.getCode(username);
	   if(saveCode!=null){
		   if(code.equals(saveCode)){
			   String token = CommonUtil.getUUID();
			   memberService.saveToken(token, username);
			   apiCodeDto=new ApiCodeDto(ApiCodeEnum.SUCCESS);
			   apiCodeDto.setToken(token);
		   }else{
			   apiCodeDto=new ApiCodeDto(ApiCodeEnum.CODE_ERROR);
		   }
	   }else{
		   apiCodeDto=new ApiCodeDto(ApiCodeEnum.CODE_INVALID);
	   }
	   return apiCodeDto;
   }
  
   
   @RequestMapping(value="/detail/comment/{currentPage}/{businessId}",method=RequestMethod.GET)
   public CommentListDto detail(@PathVariable("businessId")Long id,Page page){
	  CommentListDto commentListDto=commentService.searchByPage(id,page);
	   return commentListDto;
	   
   }
   
   @RequestMapping(value="/order",method=RequestMethod.POST)
   public ApiCodeDto order(OrderForBuyDto buyDto){
	 //  Long phone=TokenCache.getInstance().getToken(buyDto.getToken());
	   ApiCodeDto dto=null;
	   Long phone=memberService.getPhone(buyDto.getToken());
	   if(phone!=null&&phone.equals(buyDto.getUsername())){
		   OrdersDto ordersDto=new OrdersDto();
		   Long memberId=ordersService.getIdByPhone(phone);
		   ordersDto.setMemberId(memberId);
		   ordersDto.setBusinessId(buyDto.getId());
		   ordersDto.setPrice(buyDto.getPrice());
		   ordersDto.setNum(buyDto.getNum());
		   ordersService.add(ordersDto);
		   dto=new ApiCodeDto(ApiCodeEnum.SUCCESS);
	   }else{
		   dto=new ApiCodeDto(ApiCodeEnum.NOT_LOGGED);
	   }
	   return dto;
   }
   
   @RequestMapping(value="/orderlist/{username}",method=RequestMethod.GET)
   public List<OrdersDto> orderList(@PathVariable("username")Long username){
	   //TODO 此处应该优化加权限
	   Long id=memberService.getIdByPhone(username);
	   return ordersService.getListById(id);
   }
   
   
}
