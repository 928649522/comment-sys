package cn.comment.util;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import cn.comment.constant.SessionKeyConst;
import cn.comment.dto.ActionDto;


public class CommonUtil {
   public static boolean isEmpty(String targt){
	   if(targt!=null&&"".equals(targt)){
		   return true;
	   }else{
		   return false;
	   }
   }
   /**
    * @param number  设置随机数的位数
    * @return 随机数
    * */
   public static int random(int number){
	   return (int) ((Math.random()*9+1)*Math.pow(10, number));
   }
	public static String getUUID() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static void main(String[] args) {
		System.out.println(getUUID());
	}
		/**
	 * 判断session中存放的动作dto列表中是否包含指定的url
	 * @param session
	 * @param url 
	 * @param method http动作
	 * @return true:包含，false：不包含
	 */
	public static boolean contains(HttpSession session,String url,String method) {
		Object obj = session.getAttribute(SessionKeyConst.ACTION_INFO);
		if(obj != null) {
			@SuppressWarnings("unchecked")
			List<ActionDto> dtoList = (List<ActionDto>)obj;
			for(ActionDto actionDto : dtoList) {
				if(!isEmpty(actionDto.getMethod()) && !actionDto.getMethod().equals(method)) {
					continue;
				}
				if(!url.matches(actionDto.getUrl())) {
					continue;
				}
				return true;
			}
		}
		return false;
	}
}
