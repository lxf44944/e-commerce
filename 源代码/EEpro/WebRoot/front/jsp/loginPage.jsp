<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%-- <link rel="stylesheet" href="<%=path%>/css/mainLayout.css"
	type="text/css"> --%>

<title>µÇÂ½Ò³Ãæ</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<LINK rel="stylesheet" type="text/css" href="<%=path%>/css/common.css">
<LINK rel="stylesheet" type="text/css"
	href="<%=path%>/css/index_new.css">
</head>

<body>
<table width="800px" align="center" >
		<tr>
			<td ><IMG src="<%=path%>/front/image/icon_index_logo.png">
		</td>
		</tr>		
					<tr>
						<td width="30%"  style="vertical-align:top;"><jsp:include
								page="userLogin.jsp"></jsp:include></td>	
					</tr>
	

		<tr>
			<td height="30" colspan="2"><jsp:include page="fFooter.jsp"></jsp:include></td>
		</tr>
	</table>




</body>
</html>
