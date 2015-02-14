<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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

<title>订单明细</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=path%>/css/reg.css">


</head>

<body>
<input type="button" value="返回订单列表" style="width: 150px;margin-top: 30px;margin-left: 50px" onclick="window.history.back()">
	<table border="1" width="90%"
		style="text-align: center; margin-top: 20px" align="center">
		<caption >
			<h2 style="margin-top: 20px;margin-bottom: 20px;">订单详情</h2>
		</caption>
		
		<tr>
			<td>订单编号</td>
			<td>${order.nid}</td>
		</tr>
		<tr>
			<td>下单时间</td>
			<td>${order.dgdate}</td>
		</tr>
		<tr>
			<td>付款方式</td>
			<td>${order.spayType}</td>
		</tr>
		<tr>
			<td>收货方式</td>
			<td>${order.ssendType}</td>
		</tr>
		<tr>
			<td>商品类数</td>
			<td>${order.nmcTypeSize}</td>
		</tr>
		<tr>
			<td>商品总数</td>
			<td>${order.nmcSize}</td>
		</tr>
		<tr>
			<td>商品总价</td>
			<td>${order.ntotalPrice}</td>
		</tr>
		<tr>
			<td>订单状态</td>
			<td>${order.sstatus}</td>
		</tr>
		<tr>
			<td>订单反馈</td>
			<td>${order.smsg}</td>
		</tr>
		<tr>
			<td>审核人</td>
			<td>${order.sauser}</td>
		</tr>
		<tr>
			<td>审核时间</td>
			<td>${order.dadate}</td>
		</tr>
		<tr>
			<td>收货人</td>
			<td>${order.ssname}</td>
		</tr>
		<tr>
			<td>收货地址</td>
			<td>${order.ssaddress}</td>
		</tr>
		<tr>
			<td>收货邮编</td>
			<td>${order.sscode}</td>
		</tr>
		<tr>
			<td>收货电话</td>
			<td>${order.ssphone}</td>
		</tr>
		<tr>
			<td>电子邮箱</td>
			<td>${order.ssemail}</td>
		</tr>

	</table>


	<table border="1" width="90%"
		style="text-align: center; margin-top: 50px;" align="center">
		<caption>
			<h2 style="margin-top: 20px;margin-bottom: 20px;">商品具体信息</h2>
		</caption>
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品简介</th>
			<th>商品图片</th>
			<th>商品单价</th>
			<th>购买数量</th>
			<th>价格小计</th>

		</tr>

		<c:forEach items="${orderItems}" var="orderItem">
			<tr>
				<td>${orderItem.nmcid}</td>
				<td>${orderItem.smcname}</td>
				<td>${orderItem.sdescription}</td>
				<td><img src="<%=path%>/mcimg/${orderItem.simg}" width="80px" height="60px"/></td>
				<td>${orderItem.ncount}</td>
				<td>${orderItem.nprice}</td>
				<td>${orderItem.ntotalprice}</td>
			</tr>
		</c:forEach>


	</table>
	<table>
	<tr><td></td></tr>
	<tr><td></td></tr>
	</table>
</body>
</html>
