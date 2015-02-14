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

<title>我的订单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/list.css"/>
<script language="javascript" src="<%=path%>/js/calendar.js"
	charset="GBK"></script>
</head>

<body>
	<table width="95%" align="center" style="text-align: center;" border="0">
		<tr>
			<td><form
					action="<%=path %>/MyOrderServlet?fuser=${sessionScope.fuser}"
					method="post" name="orderForm">
					<table width="100%">
						<tr>
							<td width="100" style="padding-left: 100px"><select
								class="index_select" name="sstatus" id="sstatus">
									<option value="-1">-审核状态-</option>
									<option value="未审核" ${sstatus=='未审核'?'selected':''}>未审核</option>
									<option value="通过" ${sstatus=='通过'?'selected':''}>通过</option>
									<option value="不通过" ${sstatus=='不通过'?'selected':''}>不通过</option>

							</select></td>


							<td width="150"><INPUT
								onBlur="if(!value){value='请输入下单开始日期';}" class="index_top_input"
								style="width: 130px"
								onFocus="if(value == '请输入下单开始日期'){this.value=''};javascript:{show_cele_date(this,'','',this);}"
								name="sdgdate" value="${sdgdate==null?'请输入下单开始日期':sdgdate}"
								type="text"> -</td>

							<td width="150"><INPUT
								onBlur="if(!value){value='请输入下单结束日期';}" class="index_top_input"
								style="width: 130px"
								onFocus="if(value == '请输入下单结束日期'){this.value=''};javascript:{show_cele_date(this,'','',this);}"
								name="edgdate" value="${edgdate==null?'请输入下单结束日期':edgdate}"
								type="text">
							</td>
							<td width="150"><INPUT
								style="border:none;background: url('<%=path%>/front/image/icon_index_search04.png')  left top no-repeat;
							width:41px; height:25px; cursor:pointer "
								type="submit" value="" title="提交检索"></td>


						</tr>
					</table>

				</form></td>
		</tr>
		<tr>
			<td>







				<table border="0"
					style="width: 780px; margin-top: 40px; text-align: center;"
					align="center">
					<tr>
						<th>订单编号</th>
						<th>下单时间</th>
						<th>订单状况</th>
						<th>订单金额</th>
						<th>商品总数</th>
						<th>操作</th>
					</tr>
					<c:if test="${empty orders}">
						<tr align="center" style="margin-top: 50px">
						<td colspan="6"><font color="red">未找到该类订单!</font>	
					</td>	</tr>
					</c:if>
					<c:forEach items="${orders}" var="order" varStatus="vs">

						<tr>

							<td>${order.nid}</td>
							<td>${order.dgdate}</td>
							<td>${order.sstatus}</td>
							<td>￥${order.ntotalPrice}</td>
							<td>${order.nmcSize}</td>
							<td><a href="<%=path %>/ViewOrderServlet?sid=${order.nid}">查看订单</a>
							</td>

						</tr>

					</c:forEach>
					<tr>
						<td colspan="11" align="center">${pageTool}</td>
					</tr>
				</table></td>
		</tr>
	</table>

</body>
</html>
