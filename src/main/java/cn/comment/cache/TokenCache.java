package cn.comment.cache;

import java.util.HashMap;
import java.util.Map;

public class TokenCache {
   private static TokenCache instance;
   
   private Map<String, Long> map;
   
   private TokenCache(){
	   map=new HashMap<String, Long>();
   }
   
   public static final TokenCache getInstance(){
	   if(instance==null){
		   synchronized(TokenCache.class){
			   if(instance==null){
				   instance=new TokenCache();
			   }
		   }
	   }
	   return instance;
   }
   
   /**
    * 保存token与对应的手机号
    * @param token
    * @param phone 手机号
    */
   public void saveToken(String token,Long phone){
	   map.put(token, phone);
   }
   
   /**
    * 根据token获取用户信息(手机号)
    * @param token
    * @return 手机号
    */
   public Long getPhoneByToken(String token){
	   return map.get(token);
   }
}
