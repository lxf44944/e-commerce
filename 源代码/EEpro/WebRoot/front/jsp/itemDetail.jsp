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

<title>商品明细</title>

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

<body>
<div ><input type="button"
				value="返回商品列表" onclick="window.history.back()" />
			</div>
	<table border="0" width="90%"
		style="text-align: center; margin-top: 50px" align="center">
		<caption>
			<h3>商品具体信息</h3>
		</caption>
		<tr>
			<td>商品编号</td>
			<td>${mcbean.nid}</td>
		</tr>

		<tr>
			<td>商品名称</td>
			<td>${mcbean.sname}</td>
		</tr>
		<tr>
			<td>商品简介</td>
			<td>${mcbean.sdescription}</td>
		</tr>
		<tr>
			<td>商品图片</td>
			<td><img src="<%=path%>/mcimg/${mcbean.simg}" width="80px"
				height="60px" />
			</td>
		</tr>
		<tr>
			<td>商品单价</td>
			<td>￥${mcbean.nprice}</td>
		</tr>
		<tr>
			<td>是否缺货</td>
			<td>${mcbean.smctag}</td>
		</tr>
		<tr>
			<td>上架时间</td>
			<td>${mcbean.dcdate}</td>
		</tr>
		<tr>
			<td>所属大类</td>
			<td>${mcbean.nmaxid}</td>
		</tr>
		<tr>
			<td>所属小类</td>
			<td>${mcbean.nminid}</td>
		</tr>

	</table>
	<table align="center" style="margin-top: 40px">
		<tr>		
			<td  style="text-align:center;"><input type="image"
				onclick="document.location.href='CarServlet?task=buy&nid=${mcbean.nid}'" alt="购买" id="img"
				src="<%=path%>/front/image/pay.jpg"></td>
		</tr>
	</table>
</body>
</html>
