<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ tag language="java" import="cn.comment.constant.SessionKeyConst" %>
<%@ tag language="java" import="cn.comment.dto.ActionDto" %>
<%@ tag language="java" import="java.util.List" %>
<%@ tag language="java" import="cn.comment.util.CommonUtil" %>
<%@ attribute name="url" type="String" required="true" %>
<%@ attribute name="method" type="String"   %>
<%
   if(CommonUtil.contains(session, url, method)){
%>
<jsp:doBody/>
<%
}
%>