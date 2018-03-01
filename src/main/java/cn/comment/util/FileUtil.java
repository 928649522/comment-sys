package cn.comment.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
   public static boolean delete(String filePath){
	   File file= new File(filePath);
	   if(file.exists()){
		   file.delete();
		   return true;
	   }else{
		   return false;
	   }
	  
   }
   /**
    * @return fileName
    * */
   public static String save(MultipartFile multipartFile,String finalPath) throws IOException{
	  if(multipartFile!=null){
		  String fileName=System.currentTimeMillis()+"_"+multipartFile.getOriginalFilename();
		  File fileTest=new File(finalPath);
		  if(!fileTest.exists()){
			  fileTest.mkdirs();
		  }
		  File file=new File(finalPath+fileName);
		  multipartFile.transferTo(file);
		  return fileName;
	  }else{
		  return null;
	  }
	  
   }
}
