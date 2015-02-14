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



<title>Ê×Ò³Õ¹Ê¾</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<table width="800px" align="center" style="text-align: center;">
		<tr>
			<td width="500px" height="85"><jsp:include
					page="/front/jsp/ftop.jsp"></jsp:include></td>
			<td width="300px" rowspan="2"><jsp:include
					page="/front/jsp/showright.jsp"></jsp:include></td>

		</tr>
		<tr>
			<td height="96" style="text-align: center;"><jsp:include
					page="/front/jsp/showleft.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td height="50" colspan="2"><jsp:include
					page="/front/jsp/fFooter.jsp"></jsp:include></td>
		</tr>
	</table>

</body>
</html>
