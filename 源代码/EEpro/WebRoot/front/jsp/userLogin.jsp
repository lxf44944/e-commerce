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

<title>用户登陆页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script language="javascript" src="<%=path%>/js/login.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="<%=path%>/css/login.css"> -->


<script type="text/javascript" src="<%=path%>/js/code.js"></script>
</head>

<body style="margin-top: 150px;text-align: left;">
	<form method="post" action="frontLoginServlet"
		onSubmit="return checkSform();" name="sform">
		<table width="950px" border="0" align="center"
			background="<%=path%>/front/image/bg_login.jpg" cellpadding="0"
			cellspacing="0" style="margin-top:0px;">

			<tr>
				<td width="540" height="259" align="center" valign="bottom"><table
						width="90%" border="0" cellspacing="3" cellpadding="0">
						<tr>
							<td align="left" valign="bottom" style="color:#05B8E4">Power
								by <a href="#" target="_blank">LuShelphen</a> Copyright 2013</td>
						</tr>
					</table></td>
				<td width="330">

					<table width="190" height="106" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td colspan="2" style="text-align: left; "><font
								color="white">用户登录</font>
							</td>
						</tr>
						<tr>
							<td height="50" colspan="2" align="right">&nbsp;</td>
						</tr>
						<tr>
							<td width="60" height="30" align="right" style="color: white">用户名:</td>
							<td><input type="text" value="${cookie.fuser.value }"
								style="background:url(<%=path%>/background/image/login_6.gif) repeat-x; border:solid 1px #27B3FE; height:20px; background-color:#FFFFFF"
								name="suser" size="16"><span id="suserSp"></span></td>
						</tr>
						<tr>
							<td height="30" align="left" style="color: white">密&nbsp;&nbsp;码:</td>
							<td><input type="password"
								style="background:url(<%=path%>/background/image/login_6.gif) repeat-x; border:solid 1px #27B3FE; height:20px; background-color:#FFFFFF"
								name="spass" size="16"><span id="spassSp"></span></td>
						</tr>
						<tr>
							<td height="30" style="color: white">验证码:</td>
							<td><input name="code" type="text" size="4" style=""
								maxlength="4"> <img src="<%=path%>/code/img.jsp"
								title="点击切换图片" onclick="changeImg(this)"
								style="cursor: pointer;" width="50" height="24" /><span
								id="codeSp"></span>
							</td>
						</tr>
						<tr>
							<td height="40" colspan="2" align="center"><img
								src="<%=path%>/background/image/tip.gif" width="16" height="16"><span
								id="span">请勿非法登陆！</span>
							</td>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								name="submit" style="width: 70px;" value="登  陆">
							</td>
							<td><input type="reset" name="rest" style="width: 70px;"
								value="取  消 "></td>
						<tr>
							<td height="5" colspan="2"></td>
					</table>
				</td>

			</tr>
			<%-- <tr>
				<td height="161" colspan="3"
					background="<%=path%>/front/image/login_4.gif"></td>
			</tr> --%>

		</table>
	</form>
</body>



</html>
