<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>结算确认页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<%-- <link rel="stylesheet" type="text/css" href="<%=path %>/css/reg.css"> --%>
	
  </head>
  
  <body>
  <form action="<%=path %>/OderSureServlet" method="post" name="orderSureForm">
   	<table align="center">
   		<tr>
   		<td>支付方式：</td>
   		<td><input type="radio" name="pay" value="网银支付" checked="checked"/>网银支付</td>
   		<td><input type="radio" name="pay" value="支付宝支付"/>支付宝支付</td>
   		</tr>
   		<tr>
   		<td>收货方式：</td>
   		<td><input type="radio" name="shipping" value="直接付款" checked="checked"/>直接付款</td>
   		<td><input type="radio" name="shipping" value="货到付款"/>货到付款</td>
   		</tr>
   		<tr>
   		<td><input type="submit" value="确认结算"/></td>
   		<td></td>
   		<td><input type="button" value="返回购物车" onclick="window.history.back()"/></td>
   		</tr>
   	</table>
   	</form>
  </body>
</html>
