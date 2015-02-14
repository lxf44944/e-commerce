<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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

<title>My JSP 'centerFrame.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script language="javascript" src="<%=path%>/js/hide.js"></script>
</head>

<body background="<%=path%>/background/image/p_bg.gif" style="margin:0;">
	<table height="700" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td onclick="hide();" style="cursor:pointer" align="center"><img
				src="<%=path%>/background/image/p_left.gif" title="µã»÷Òþ²Ø²Ëµ¥À¸" id="img1" width="7"
				height="50" />
			</td>
		</tr>
	</table>
</body>

</html>
