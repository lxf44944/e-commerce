<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String	currentPage=(String)request.getSession().getAttribute("currentPage");
	
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商品展示页面</title>

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


	<%-- <a href="<%=path%>/background/jsp/mainFrame.jsp">后台</a> --%>
	<c:if test="${empty beans}">
	<div align="center" style="margin-top: 50px">没找到"<font color="red">${sname}</font>"对应的商品!</div>
	</c:if>
	<c:forEach items="${beans}" var="bean" varStatus="vs">
	<hr/>
	<form action="CarServlet?currentPage=<%=currentPage %>" name="formBuy" method="post">
			<table align="center" border="0" width="90%">
				<tr>
					<td style="text-align: center;font-weight: bolder;" colspan="3">商品信息</td>
				</tr>
				<tr>
					<td colspan="2" id="${bean.nid}">商品名称：${bean.sname}<c:out value=""></c:out>
					</td>
					<td rowspan="4" style="text-align:center;"><img width="300px"
						height="225px" alt="${bean.sname}"
						src="<%=path %>/mcimg/${bean.simg}"></td>
				</tr>
				<tr>
					<td>商品价格：￥<c:out value="${bean.nprice}"></c:out>
					</td>

				</tr>
				<tr>
					<td>所属大类：<c:out value="${bean.nmaxid}"></c:out>
					</td>

				</tr>
				<tr>
					<td>所属小类：<c:out value="${bean.nminid}"></c:out>
					</td>

				</tr>
				<tr>
					<td>是否缺货：<c:out value="${bean.smctag}"></c:out>
					</td>

				</tr>
				<tr>

					<td><input type="hidden" name="nid" value="${bean.nid}">
					</td>
					<td><input type="hidden" name="task" value="buy">
					</td>
				</tr>
				<tr>
					<td style="text-align: right;"><a href="<%=path%>/ItemDetailServlet?nid=${bean.nid}"><img
							border="0px" alt="详细" src="<%=path%>/front/image/detail.jpg">
					</a>
					</td>
					<td colspan="2" style="text-align:center;"><input type="image"
						alt="购买" id="img" src="<%=path%>/front/image/pay.jpg">
					</td>
				</tr>
			</table>
		</form>
		
		<br />
	</c:forEach>

	<%-- <div>${pageTool}</div> --%>
</body>
</html>
