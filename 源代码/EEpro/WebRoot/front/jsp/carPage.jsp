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

		<title>π∫ŒÔ–≈œ¢</title>

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
				<td width="500px"><jsp:include page="ftop.jsp"></jsp:include>

					<table border="0" width="780px" height="670px">
						<tr>
							<td width="30%" style="vertical-align: top; padding-top: 40px;"><jsp:include
									page="car.jsp"></jsp:include></td>

						</tr>
					</table>
				</td>
				<td width="300px" rowspan="2"
					style="vertical-align: top; padding-top: 40px;"><jsp:include
						page="showright.jsp"></jsp:include></td>
				<td></td>

			</tr>

			<tr>
				<td></td>
			</tr>
			<tr>
				<td height="50" colspan="2"><jsp:include page="fFooter.jsp"></jsp:include></td>
			</tr>
		</table>



	</body>
</html>
