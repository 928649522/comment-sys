package cn.comment.constant;

public enum PageCodeEnum {
  ADD_SUCCESS(1000,"新增成功"),
  ADD_FAIL(1001,"新增失败"),
  DELETE_SUCCESS(2000,"删除成功"),
  DELETE_FAIL(2001,"删除失败"),
  UPDATE_SUCCESS(3000,"修改成功"),
  UPDATE_FAIL(3001,"修改失败"), 
  
  LOGIN_FAIL(1301,"登录失败！用户名密码错误！"),
  SESSION_TIMEOUT(1302,"session超时，请重新登录！"),
  NO_AUTH(1303,"没有权限访问请求资源，请切换账户后重试！"),
  
  USERNAME_EXISTS(1401,"用户名已存在！"),
  GROUPNAME_EXISTS(1402,"用户组名已存在！"),
  SUB_MENU_EXISTS(1403,"菜单下还存在子菜单！"),
  
  ASSIGN_SUCCESS(1500,"分配成功！"),
  ASSIGN_FAIL(1501,"分配失败！"),
  ORDER_SUCCESS(1600,"排序成功！"),
  ORDER_FAIL(1601,"排序失败！"),
  ;
	public static final String KEY="pageCode";
	
	private Integer code;
	private String msg;
	private PageCodeEnum(Integer code,String msg) {
         this.code=code;
         this.msg=msg;
	}
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
   
}
