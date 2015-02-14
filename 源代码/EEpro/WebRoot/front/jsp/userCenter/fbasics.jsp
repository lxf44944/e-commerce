<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>会员中心</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/list.css"/>
</head>

<body style="font: 22px/24px Geneva, "宋体", Tahoma, sans-serif;">
	<table align="center" width="90%" border="0"  style="text-align: center;font-size: 40px;">
	<tr>
	<td><a href="<%=path%>/front/jsp/userCenter/userPage.jsp"><font size="3" >基本资料</font></a></td>
	<td><a href="<%=path%>/front/jsp/userCenter/updateUserPage.jsp"><font size="3" >用户资料修改</font></a></td>
	<td><a href="<%=path%>/front/jsp/userCenter/updatePassPage.jsp"><font size="3">用户密码修改</font></a></td>
	<td><a href="<%=path %>/MyOrderServlet?fuser=${sessionScope.fuser}"><font size="3" >我的订单</font></a></td>

	</tr>
	</table>
	<table width=350 height=100 border=0 cellpadding=5 align="center" style="font-size: 22px;height: 50px;border: currentColor;color: rgb(51, 51, 51);">
		<caption
			style="font-size: 20px;padding-bottom: 20px;padding-top: 30px">会员资料</caption>
		<tr>
			<td style="text-align:left;">用&nbsp;户&nbsp;名：&nbsp;&nbsp;&nbsp;&nbsp;${fbean.user}
		</tr>

		<tr>
			<td style="text-align:left;">性&nbsp;&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;&nbsp;${fbean.sex }</td>
		</tr>
		<tr>
			<td style="text-align:left;">真实姓名：&nbsp;&nbsp;&nbsp;&nbsp;${fbean.name }</td>
			</tr>
			<tr>
				<td style="text-align:left;">出生日期：&nbsp;&nbsp;&nbsp;&nbsp;${fbean.birth }
				</td>
			</tr>
			<tr>
				<td style="text-align:left;">电子邮箱：&nbsp;&nbsp;&nbsp;&nbsp;${fbean.email }
				</td>
			</tr>
			<tr>
				<td style="text-align:left;">电话号码：&nbsp;&nbsp;&nbsp;&nbsp;${fbean.tel }
				</td>
			</tr>
			<tr>
				<td style="text-align:left;">地&nbsp;&nbsp;&nbsp;&nbsp;址：&nbsp;&nbsp;&nbsp;&nbsp;${fbean.adress }
				</td>
			</tr>
			<tr>
				<td style="text-align:left;">邮&nbsp;&nbsp;&nbsp;&nbsp;编：&nbsp;&nbsp;&nbsp;&nbsp;${fbean.postcode }
				</td>
			</tr>
			
		</table>
	<br>
</body>
</html>
