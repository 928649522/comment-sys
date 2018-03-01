package cn.comment.cache;

import java.util.HashMap;
import java.util.Map;

public class CodeCache {
   private static CodeCache instance;
   private Map<Long, String> codeMap;
   private CodeCache() {
      codeMap=new HashMap<Long, String>();
   }
   public static CodeCache getCodeCache(){
	   if(instance==null){
		   synchronized(CodeCache.class){
			   instance=new CodeCache();
		   }
	   }
	   return instance;
   }
   
   public  boolean save(Long phone,String code){
	   if(codeMap.containsKey(phone)){
		   return false;
	   }
	   codeMap.put(phone, code);
	   return true;
   }

	public String getCode(Long phone) {
		return codeMap.get(phone);
	}
}
