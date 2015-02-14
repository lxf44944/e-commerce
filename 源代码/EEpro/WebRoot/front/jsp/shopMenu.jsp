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

<title>类别菜单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<!-- <link rel="stylesheet" type="text/css" href="/EEpro/css/left_css.css"> -->
<script type="text/javascript">
function hide(id) {
		var tbody = document.getElementById("tbody" + id);
		var img = document.getElementById("img" + id);
		if (tbody.style.display == "none") {
			tbody.style.display = "block";
			img.src = "background/image/collapse.gif";
			img.title = "点击隐藏大类别";
		} else {
			tbody.style.display = "none";
			img.src = "background/image/expand.gif";
			img.title = "点击显示大类别";
		}
	}
</script>
</head>

<body>
	<table border="1" align="center" width="200px" >
		<caption
			style="background-color: rgb(18,145,129);height: 30px;text-align: center;">
			<font color="white" size="5px">商品类别</font>
		</caption>
		<c:forEach items="${typeBeans}" var="typeBean" varStatus="vs">
			<c:if test="${typeBean.npid==0}">
				<tr>
					<td><img alt="点击伸缩" src="<%=path %>/front/image/collapse.gif"
						id="img${typeBean.nid}" onclick="hide(${typeBean.nid})" /> <a
						href="<%=path%>/McServlet?nmaxid=${typeBean.nid}">${typeBean.sname}</a>
					</td>
				</tr>
			</c:if>
			<tbody id="tbody${typeBean.nid}">
				<c:forEach items="${typeBeans}" var="typeBean2" varStatus="vs">
					<c:if test="${typeBean2.npid==typeBean.nid}">
						<tr>
							<td><a
								href="<%=path%>/McServlet?nminid=${typeBean2.nid}&nmaxid=${typeBean.nid}">${typeBean2.sname}</a>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>
