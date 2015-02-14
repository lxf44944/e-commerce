<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String	currentPage=request.getParameter("currentPage");
	request.getSession().setAttribute("currentPage", currentPage);
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%-- <link rel="stylesheet" href="<%=path%>/css/mainLayout.css"
	type="text/css"> --%>
<%-- <link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/reg.css"> --%>
<title>商品展示</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
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

	<table width="780px" align="center" style="text-align: center;" border="0">

		<tr>
			<td width="500px"><jsp:include page="ftop.jsp"></jsp:include>
				<form action="McServlet" method="post">
					<table width="780px"
						background="<%=path%>/front/image/bg_index_search.png">
						<tr>
							<td width="100" style="padding-left: 100px"><select
								class="index_select" name="nmaxid" id="nmaxid"
								onchange="getMin()">
									<option value="-1">-大类搜索-</option>
									<c:forEach items="${typeBeans}" var="maxtype" varStatus="vs">
										<c:if test="${maxtype.npid==0}">
											<option value="${maxtype.nid}" ${maxtype.nid==smaxid?'selected':''}>${maxtype.sname}</option>
										</c:if>
									</c:forEach>
							</select>
							</td>

							<td width="100"><select class="index_select" name="nminid"
								id="nminid">
									<option value="-1">-小类搜索-</option>
									<!-- 小类下：保留查询条件，根据作用域中的大类编号迭代对应得的小类，设置?'selected':'' -->
									<c:forEach items="${typeBeans}" var="mintype" varStatus="vs">
										<c:if test="${mintype.npid==smaxid}">
											<option value="${mintype.nid}" ${mintype.nid==sminid?'selected':''}>${mintype.sname}</option>
										</c:if>
									</c:forEach>
							</select>
							</td>
							<td width="150"><INPUT onBlur="if(!value){value='请输入商品名称';}"
								class="index_top_input"
								onFocus="if(value == '请输入商品名称'){this.value=''}" name="sname"
								value="${sname==null?'请输入商品名称':sname}" type="text"></td>
							<td width="150"><INPUT
								style="border:none;background: url('<%=path%>/front/image/icon_index_search04.png')  left top no-repeat;
							width:41px; height:25px; cursor:pointer "
								type="submit" value="" title="提交检索">
							</td>
						</tr>
					</table>
				</form>

				<table border="0" width="780px" height="670px">
					<tr>
						<td width="30%" style="vertical-align:top;padding-top: 40px;"><jsp:include
								page="shopMenu.jsp"></jsp:include></td>
						<td width="70%" style="vertical-align:top;padding-top: 40px;"><jsp:include
								page="shopShow.jsp"></jsp:include></td>
					</tr>
				</table>
			</td>
			<td width="300px" rowspan="1"
				style="vertical-align:top;padding-top: 40px;"><jsp:include
					page="showright.jsp"></jsp:include></td>
			

		</tr>
		<tr>
			<td height="50" colspan="3" >${pageTool}</td>
		</tr> 

		<tr>
			<td height="50" colspan="2"><jsp:include page="fFooter.jsp"></jsp:include></td>
		</tr> 
	</table>



</body>
</html>
