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

<title>购物车</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
<script type="text/javascript">
	function update(id, num) {
		//alert("form"+id);

		var form = document.getElementById(id);
		//var form="form"+id;
		//alert(form);
		var count = document.getElementById("count" + id);
		var regex = /^\+?[1-9][0-9]*$/;
		//alert(count.value);
		if (!regex.test(count.value)) {//alert(count);
			alert("请输入大于0的数字！");
			count.value = num;
		} else {
			/* document.form.action ="CarServlet?task=update&nid="+id; //设置处理程序
			document.form.submit(); //提交表单
			}  */
			//alert(form);
			form.action = "CarServlet?task=update&nid=" + id; //设置处理程序
			form.submit(); //提交表单
		}
	}
</script>
</head>

<body>
	<table border="0" width="770px" style="text-align: center;">
		<tr>
			<th>商品号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品数量</th>
			<th>小计价格</th>
			<th colspan="2">操作</th>
		</tr>
		<c:if test="${empty car.carBeans}">
						<tr align="center" style="margin-top: 50px">
						<td colspan="6"><font color="red">您的购物车暂时没有商品!</font>	
					</td>	</tr>
					</c:if>
		<c:forEach items="${car.carBeans}" var="carBean">
			<form action="" method="post" name="form${carBean.mcBean.nid}"
				id="${carBean.mcBean.nid}">
				<tr>
					<!-- <td><input type="hidden" name="nid" /></td> -->
					<td>${carBean.mcBean.nid}</td>
					<td>${carBean.mcBean.sname}</td>
					<td>￥${carBean.mcBean.nprice}</td>
					<td><input type="text" name="count"
						id="count${carBean.mcBean.nid}" value="${carBean.count}" />
					</td>
					<td>￥${carBean.mcBean.nprice*carBean.count}</td>

					<td><a
						href="javascript:update(${carBean.mcBean.nid},${carBean.count})">修改</a>
					
					</td>
					<td><a
						href="CarServlet?task=remove&nid=${carBean.mcBean.nid}">删除 </a></td>
				</tr>
			</form>
		</c:forEach>
		<tr>
			<td colspan="1">总数：${car.totalCount}</td>
			<td colspan="2">总价：￥${car.totalPrice}</td>
			<td><a href="<%=path%>/McServlet?currentPage=${currentPage}">继续购物</a>
			<td><a href="CarServlet?task=clear">清空购物车</a></td>
			<td colspan="2"><a href="<%=path%>/front/jsp/userCenter/orderSurePage.jsp">结账 </a>
			</td>
		</tr>
	</table>
</body>
</html>
