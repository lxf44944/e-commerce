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

<title>商品展示页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<%=path%>/css/reg.css">
<script type="text/javascript">
    function getMin(){
    var nmaxid=document.getElementById("nmaxid");
    var nminid=document.getElementById("nminid");
    var smax=nmaxid.selectedIndex;
	var i=1;
	nminid.options.length = 1;
      <c:forEach items="${typeBeans}" var="mintype" varStatus="vs">
      	if (${mintype.npid}==smax&&smax!=0) 
      	{
			nminid[i]=new Option("${mintype.sname}","${mintype.nid}");
			i++;
		}
	  </c:forEach>  
  }
  </script>

</head>

<body>
	<table width="780px" align="center" style="text-align: center;"
		border="0">


		<form action="BackMcServlet" method="post" name="form">
			<table width="100%">
				<tr>
					<td width="100" style="padding-left: 100px"><select
						class="index_select" name="nmaxid" id="nmaxid" onchange="getMin()">
							<option value="-1">-大类搜索-</option>
							<c:forEach items="${typeBeans}" var="maxtype" varStatus="vs">
								<c:if test="${maxtype.npid==0}">
									<option value="${maxtype.nid}" ${maxtype.nid==smaxid?'selected':''}>${maxtype.sname}</option>
								</c:if>
							</c:forEach>
					</select></td>

					<td width="100"><select class="index_select" name="nminid"
						id="nminid">
							<option value="-1">-小类搜索-</option>
							<!-- 小类下：保留查询条件，根据作用域中的大类编号迭代对应得的小类，设置?'selected':'' -->
							<c:forEach items="${typeBeans}" var="mintype" varStatus="vs">
								<c:if test="${mintype.npid==smaxid}">
									<option value="${mintype.nid}" ${mintype.nid==sminid?'selected':''}>${mintype.sname}</option>
								</c:if>
							</c:forEach>
					</select></td>
					<td width="150"><INPUT onBlur="if(!value){value='请输入商品名称';}"
						class="index_top_input"
						onFocus="if(value == '请输入商品名称'){this.value=''}" name="sname"
						value="${sname==null?'请输入商品名称':sname}" type="text">
					</td>
					<td width="150"><INPUT
						style="border:none;background: url('<%=path%>/front/image/icon_index_search04.png')  left top no-repeat;
							width:41px; height:25px; cursor:pointer "
						type="submit" value="" title="提交检索"></td>
						<td width="20%"><a href="<%=path%>/AddMcTypeServlet">添加商品</a></td>
				</tr>
			</table>

		</form>

		<%-- <a href="<%=path%>/background/jsp/mainFrame.jsp">后台</a> --%>
	

						<table border="1" style="width: 90%; margin-top: 40px; text-align: center;"
							align="center">
							<tr>
								<th>商品序号</th>
								<th>商品名称</th>
								<th>商品价格</th>
								<th>商品描述</th>
								<th>商品图片</th>
								<th>缺货</th>
								<th>上传时间</th>
								<th>大类</th>
								<th>小类</th>

								<th colspan="2">操作</th>
							</tr>
							<c:if test="${empty beans}">
						<tr align="center" style="margin-top: 50px">
						<td colspan="11"><font color="red">没找到名字为"${sname}"的商品！</font>	
					</td>	</tr>
					</c:if>
							<c:forEach items="${beans}" var="bean" varStatus="vs">
								<form action="" method="post" name="form2">
									<tr>
										<!-- <td><input type="hidden" name="nid" /></td> -->
										<td>${bean.nid}</td>
										<td width="10%">${bean.sname}</td>
										<td>￥${bean.nprice}</td>
										<td width="25%">${bean.sdescription}</td>
										<td rowspan="1" style="text-align:center;"><img
											width="60px" height="45px" alt="${bean.sname}"
											src="<%=path %>/mcimg/${bean.simg}">
										</td>
										<td>${bean.smctag}</td>
										<td>${bean.dcdate}</td>
										<td>${bean.nmaxid}</td>
										<td>${bean.nminid}</td>
										<td><a
											href="UpdateMcServlet?task='update'&sid=${bean.nid}">修改</a>
										</td>
										<td><a
											href="javascript:if(confirm('确认删除该商品？')){window.location.href='<%=path %>/AdminMcServlet?sid=${bean.nid}&task=remove';}">删除</a>
										</td>
									</tr>
								</form>
							</c:forEach>
							<tr>
								<td colspan="11" align="center">${pageTool}</td>
							</tr>
						</table>
						</table>
				
</body>
</html>
