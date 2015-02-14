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

<title>下单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
<script type="text/javascript" src="<%=path%>/js/order.js"></script>

</head>

<body>
	<table border="1" width="90%"
		style="text-align: center; margin-top: 20px" align="center">
		<caption>
			<h3>订单详情</h3>
		</caption>
		<tr>
			<th>所购商品种类数</th>
			<th>所购商品总件数</th>
			<th>价格总计</th>
			<th>付款方式</th>
			<th>收货方式</th>
		</tr>
		<tr>
			<td>${car.totalType}</td>
			<td>${car.totalCount}</td>
			<td>￥${car.totalPrice}</td>
			<td>${pay}</td>
			<td>${shipping}</td>
		</tr>

	</table>
	<form action="<%=path %>/OrderServlet?suser=${fbean.user}&pay=${pay}&shipping=${shipping}&totalType=${car.totalType}
	&totalCount=${car.totalCount}&totalPrice=${car.totalPrice}" method="post" name="sform">
	<table border="0" width="90%"
		style="text-align: center; margin-top: 50px" align="center">
		<caption>
			<h3>收货人相关信息</h3>
		</caption>
		
		<tr>
			<td>收货人姓名： <input type="text" name="sname" maxlength=30
				value="${fbean.name}" /> <span id="snameSp" /></span></td>
		</tr>
		<tr>
			<td>收货人地址： <input type="text" name="sadress" maxlength=30
				value="${fbean.adress}" /> <span id="sadressSp"></span></td>
		</tr>
		<tr>
			<td>收货人邮编： <input type="text" name="spostcode" maxlength=30
				value="${fbean.postcode}" /> <span id="spostcodeSp"></span></td>
		</tr>
		<tr>
			<td>收货人电话： <input type="text" name="snumber" maxlength=30
				value="${fbean.tel}" /> <span id="snumberSp"></span></td>
		</tr>
		<tr>
			<td>收货人邮箱： <input type="text" name="semail" maxlength=30
				value="${fbean.email}" /> <span id="semailSp"></span></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td><input type="submit" value="提交订单"/></td></tr>
	</table>
	</form>
</body>
</html>
