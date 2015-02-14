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

<title>基本资料</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="/EEpro/css/right_css.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/reg.css">
</head>

<body>
	
	<table width=300 height=100 border=0 cellpadding=5 align="center">
		<caption
			style="font-size: 20px;padding-bottom: 20px;padding-top: 30px">会员资料</caption>
		<tr>
			<td>用&nbsp;户&nbsp;名：&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.suser}
		</tr>

		<tr>
			<td>性&nbsp;&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.bean.sex }</td>
		</tr>
		<tr>
			<td>真实姓名：&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.bean.name }</td>
			</tr>
			<tr>
				<td>出生日期：&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.bean.birth }
				</td>
			</tr>
			<tr>
				<td>电子邮箱：&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.bean.email }
				</td>
			</tr>
			<tr>
				<td>电话号码：&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.bean.tel }
				</td>
			</tr>
			<tr>
				<td>地&nbsp;&nbsp;&nbsp;&nbsp;址：&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.bean.adress }
				</td>
			</tr>
			<tr>
				<td>邮&nbsp;&nbsp;&nbsp;&nbsp;编：&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.bean.postcode }
				</td>
			</tr>
			
		</table>
	<br>
</body>
</html>
