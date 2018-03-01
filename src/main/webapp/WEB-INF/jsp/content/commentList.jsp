<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'commentList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	    <link rel="stylesheet" type="text/css" href="${basePath} /comment/css/all.css">
		<link rel="stylesheet" type="text/css" href="${basePath} /comment/css/pop.css">
		<link rel="stylesheet" type="text/css" href="${basePath} /comment/css/main.css">
		<script type="text/javascript" src="${basePath} /comment/js/common/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${basePath} /comment/js/content/adList.js"></script>

  </head>
  
	<body style="background: #e1e9eb;">
		<form action="http://127.0.0.1:8081/comment/ad/search" id="mainForm" method="post">
			<input id="id" name="id" type="hidden">
			<input id="basePath" value="http://127.0.0.1:8081/comment" type="hidden">
			<input name="page.currentPage" id="currentPage" value="1" type="hidden">
			<div class="right">
				<div class="current">当前位置：<a href="#">内容管理</a> &gt; 订单查询</div>
				<div class="rightCont">
					<p class="g_title fix">订单列表</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="80" align="right">手机号：</td>
								<td>
									<input name="title" id="title" value="" class="allInput" type="text">
								</td>
	                            <td style="text-align: right;" width="150">
	                            	<input class="tabSub" value="查询" onclick="search('1');" type="button">&nbsp;&nbsp;&nbsp;&nbsp;
	                            </td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>序号</th>
								    <th>手机号</th>
								    <th>订单号</th>
								    <th>金额(元)</th>
								</tr>
								
									<tr>
										<td>1</td>
										<td>13912345678</td>
										<td>123</td>
										<td>668</td>
									</tr>
							</tbody>
						</table>
						

<script type="text/javascript">
	function transCurrentPage(currentPage) {
		var rule = /^[0-9]*[1-9][0-9]*$/;
		if(!rule.test(currentPage)) {
			currentPage = 1;
		}
		eval("search(currentPage)");
	}
</script>

<div class="page fix">
	<a href="javascript:transCurrentPage('1');" class="first">首页</a>
	<a href="javascript:transCurrentPage('0');" class="pre">上一页</a>
	当前第<span>1/1</span>页
	<a href="javascript:transCurrentPage('2');" class="next">下一页</a>
	<a href="javascript:transCurrentPage('1');" class="last">末页</a>
	跳至 &nbsp;<input id="currentPageText" value="1" class="allInput w28" type="text">&nbsp;页 &nbsp;
	<a href="javascript:transCurrentPage($('#currentPageText').val());" class="go">GO</a>
</div>
					</div>
				</div>
			</div>
		</form>
	
</body>
</html>