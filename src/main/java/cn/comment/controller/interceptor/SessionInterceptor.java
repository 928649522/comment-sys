package cn.comment.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.comment.constant.SessionKeyConst;

public class SessionInterceptor implements HandlerInterceptor{

	/**
	 * 进入handler方法之前执行此方法
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if(request.getSession().getAttribute(SessionKeyConst.USER_INFO)!=null){
			return true;
		}
		if (request.getHeader("x-requested-with") != null) {
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
			response.setHeader("url", basePath + "/login/sessionTimeout");
		} else {
			request.getRequestDispatcher("/login/sessionTimeout").forward(request, response);
		}
		return false;
	}

	/**
	 * 在进入Handler之后，返回modelAndView之前
	 * */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	/**
	 * 在handler方法执行完
	 * */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
   
}
