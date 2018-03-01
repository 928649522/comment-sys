<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统错误页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
          <script src="${basePath}/js/common/jquery-1.8.3.js" type="text/javascript"></script>
        <script src="${basePath}/js/common/common.js" type="text/javascript"></script>
  <script type="text/javascript">
   $(function(){
	   common.showMessage('${pageCode.msg}');
	   var topWindow=window;
	   while(topWindow!=window.parent){
		   topWindow=window.parent;
	   }
	   topWindow.location.href="${basePath }/login";
   });
  </script>
  <body>
  </body>
</html>
