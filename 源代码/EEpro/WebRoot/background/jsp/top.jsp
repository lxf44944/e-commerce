<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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

<title>top</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="/EEpro/css/top_css.css">

</head>

<body bgcolor="#03A8F6">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="194" height="60" align="center"
				background="<%=path%>/background/image/top_logo.jpg"></td>
			<td align="center"
				style="background:url(<%=path%>/background/image/top_bg.jpg) no-repeat"><table
					cellspacing="0" cellpadding="0" border="0" width="100%" height="33">
					<tbody>

						<tr>
							<td>${sessionScope.suser}，欢迎光临！</td>
							<td width="80" align="right" nowrap="nowrap" class="topbar">返回首页：</td>
							<td class="topbar"><a href="<%=path %>/background/jsp/welcome.jsp" target="rightFrame"><img
									title="返回首页" height="23"
									src="<%=path%>/background/image/home.gif" width="33" border="0" />
							</a>&nbsp;</td>
						</tr>
					</tbody>
				</table>
				<table height="26" border="0" align="left" cellpadding="0"
					cellspacing="0" class="subbg" NAME=t1>
					<tbody>
						<tr align="middle">
							<td width="71" height="26" align="center" valign="middle"
								background="<%=path%>/background/image/top_tt_bg.gif"><a
								href="<%=path %>/background/jsp/welcome.jsp" target="rightFrame" class="STYLE2">管理首页</a>
							</td>
							<td align="center" class="topbar"><span class="STYLE2">
							</span>
							</td>
							<td width="71" height="26" align="center" valign="middle"
								background="<%=path%>/background/image/top_tt_bg.gif"><a
								href="<%=path %>/McTypeServlet" target="rightFrame" class="STYLE2">商品管理</a>
							</td>
							<td align="center" class="topbar"><span class="STYLE2">
							</span>
							</td>
							<td width="71" align="center" valign="middle"
								background="<%=path%>/background/image/top_tt_bg.gif"><a
								href="<%=path %>/UserServlet" target="rightFrame" class="STYLE2">用户管理</a>
							</td>
							<td align="center" class="topbar"><span class="STYLE2">
							</span>
							</td>
							<td width="71" align="center" valign="middle"
								background="<%=path%>/background/image/top_tt_bg.gif"><a
								href="<%=path %>/BorderServlet" target="rightFrame">订单管理</a>
							</td>
							<td align="center" class="topbar"><span class="STYLE2">
							</span>
							</td>
							<td width="71" align="center" valign="middle"
								background="<%=path%>/background/image/top_tt_bg.gif"><a
								href="<%=path %>/background/jsp/basics.jsp" target="rightFrame" class="STYLE3">个人资料</a>
							</td>
							<td align="center" class="topbar"><span class="STYLE2">
							</span>
							</td>
							
							<td align="center" class="topbar"><span class="STYLE2">
							</span>
							</td>
							<td width="71" align="center" valign="middle"
								background="<%=path%>/background/image/top_tt_bg.gif"><a
								href="<%=path %>/QuitLogin" target="_top" class="STYLE2">安全退出</a>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr height="6">
			<td bgcolor="#1F3A65"
				background="<%=path%>/background/image/top_bg.jpg"></td>
		</tr>
	</table>

</body>
</html>
