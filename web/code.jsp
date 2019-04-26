<%@ page import="com.imooc.servicempl.CaptcahCode" %><%--
  Created by IntelliJ IDEA.
  User: kans
  Date: 2019-03-27
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    response.setHeader("pragma","no-cache");
    response.setHeader("cache-control","no-cache");
    response.setHeader("expires","0");

    String code = CaptcahCode.drawImage(response);
    session.setAttribute("code",code);
    out.clear();
    out = pageContext.pushBody();
%>