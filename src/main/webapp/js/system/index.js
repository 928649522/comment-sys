// 当前登录用户可以访问的菜单Map
var dataFlag = [{"id":1,"name":"系统管理","url":"","parentId":0,"orderNum":1,"actionList":null},{"id":9,"name":"订单统计","url":"/orderReport","parentId":8,"orderNum":1,"actionList":null},{"id":4,"name":"广告管理","url":"/ad","parentId":3,"orderNum":1,"actionList":null},{"id":2,"name":"权限管理","url":"/auth","parentId":1,"orderNum":1,"actionList":null},{"id":5,"name":"商户管理","url":"/businesses","parentId":3,"orderNum":2,"actionList":null},{"id":3,"name":"内容管理","url":"","parentId":0,"orderNum":2,"actionList":null},{"id":8,"name":"统计报表","url":"","parentId":0,"orderNum":3,"actionList":null},{"id":6,"name":"评论查询","url":"/comments","parentId":3,"orderNum":3,"actionList":null},{"id":7,"name":"订单查询","url":"/orders","parentId":3,"orderNum":4,"actionList":null}];
var menuMap = {};
$(function() {
	alert('ok');
	 
	common.ajax({
			url : $("#basePath").val() + "/session/menus",
			success : function(data) {
				if(data && data.length > 0) {
					$.each(data,function(i,value) {
						if(!menuMap[value.parentId]) {
							menuMap[value.parentId] = new Array();
						}
						menuMap[value.parentId].push(value);
					});
					initMenu();
				}
			}
	});
	//1
	$.each(menuMap,function(i,value) {
		if(!menuMap[value.parentId]) {
			menuMap[value.parentId] = new Array();
		}
		menuMap[value.parentId].push(value);
	});
	initMenu();
	//1
});

/**
 * 初始化菜单
 */
function initMenu() {
	var menuList = menuMap[0];
	$("#menuDiv").html("");
	$.each(menuList,function(i,value) {
		$("#menuDiv").append("<li onclick='clickMenu(this," + value.id + ")'><a><span>" + value.name + "</span></a></li>");
	});
}

/**
 * 根据父菜单ID初始化子菜单
 */
function initSubMenu(parentId) {
	var menuList = menuMap[parentId];
	$("#subMenuDiv").html("");
	$.each(menuList,function(i,value) {
		$("#subMenuDiv").append("<h3 onclick=\"clickSubMenu(this,'" + value.url + "')\"><a>" + value.name + "</a></h3>");
	});
}

/**
 * 方法描述:单击菜单（页面上部菜单），初始化子菜单（即页面左部菜单）
 */
function clickMenu(element,id) {
	// 将同级节点的[选中样式]清空
	$("#menuDiv").children().attr("class","");
	// 将当前单击的节点置为[选中样式]
	$(element).attr("class","on");
	// 加载子菜单内容
	initSubMenu(id);
}

/**
 * 方法描述:单击子菜单（页面左部菜单），初始化主页面
 */
function clickSubMenu(element,path) {
	// 将其他有[选中样式]的节点的样式清空
	$("#subMenuDiv").find(".on").attr("class","");
	// 将当前单击的节点置为[选中样式]
	$(element).children().attr("class","on");
	// 按指定地址加载主页面(iframe)
	$("#mainPage").attr("src",$("#basePath").val()+ path);
}

/**
* 打开密码修改弹出层
*/
function openAddDiv(){
	$("#mengban").css("visibility","visible");
	$(".wishlistBox").show();
	$(".wishlistBox").find(".persongRightTit").html("&nbsp;&nbsp;修改密码");
	$("#submitVal").show();
}

/**
* 关闭密码修改弹出层
*/
function closeDiv(){
	$("#mengban").css("visibility","hidden");
	$("#oldPassword").val("");
	$("#newPassword").val("");
	$("#newPasswordAgain").val("");
	$(".wishlistBox").hide();
}