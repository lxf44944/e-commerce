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
<script type="text/javascript">
var xmlHttp = null;
function createXmlHttpRequest() {
	//IE浏览器
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		//其他浏览器
		xmlHttp = new XMLHttpRequest();
	}
}

function testSusername() {
	createXmlHttpRequest();
	var suser = document.all.suser.value;
	//拼接url
	var url = "<%=path%>/AjaxServletUrl?sname=" + suser + "&date="
			+ new Date().getTime();
	xmlHttp.open("GET", url, true);
	xmlHttp.onreadystatechange = dealRes;
	xmlHttp.send(null);
}

function dealRes() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			//获得服务器响应回来的文本
			var text = xmlHttp.responseText;
			//alert('text=' + text);
			var suserSp = document.getElementById("suserSp");
			//document.all.spid.innerText=text;
			document.all.suserSp.innerHTML=text;

		}

	}

}
</script>

<title>注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script language="javascript" src="<%=path%>/js/calendar.js"
	charset="GBK"></script>
<script language="javascript" src="<%=path%>/js/reg.js"></script>
</head>

<body>
	<form method="post" action="regServlet" name="sform" 
		onsubmit="return checkSform();">
		<table width=800 height=100 border=0 cellpadding=5 align="center">
			<caption
				style="font-size: 20px;padding-bottom: 20px;padding-top: 30px"><h2>会员注册</h2></caption>
			<tr>
				<td>用&nbsp;户&nbsp;名： <input type="text" name="suser"
					maxlength=30 style="width: 170px"/><input type="button" style="width: 70px" value="测试可用" onclick="testSusername()" /> <span id="suserSp" style="color:blue;"></span>
				</td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;码： <input type="password"
					name="spass" style="width: 170px"/> <span id="spassSp"></span>
				</td>
			</tr>
			<tr>
				<td>确认密码： <input type="password" name="srepass"  style="width: 170px"/> <span
					id="srepassSp"></span>
				</td>
			</tr>
			<tr>
				<td>性&nbsp;&nbsp;&nbsp;&nbsp;别： <input type="radio" name="sex"
					value="男" style="width:50px;" checked="checked" />
					男 &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女"
					style="width:50px;"  />
					女</td>
			</tr>
			<tr>
				<td>真实姓名： <input type="text" name="sname" maxlength=30 style="width: 170px"/> <span
					id="snameSp" /></span>
				</td>
			</tr>
			<tr>
				<td>出生日期： <input type="text" name="sdate" size="30"
					onfocus="javascript:{show_cele_date(this,'','',this);}" style="width: 170px"/> <span
					id="sdateSp"></span>
				</td>
			</tr>
			<tr>
				<td>电子邮箱： <input type="text" name="semail" maxlength=30 style="width: 170px"/> <span
					id="semailSp"></span>
				</td>
			</tr>
			<tr>
				<td>电话号码： <input type="text" name="snumber" maxlength=30 style="width: 170px"/> <span
					id="snumberSp"></span>
				</td>
			</tr>
			<tr>
				<td>地&nbsp;&nbsp;&nbsp;&nbsp;址： <input type="text"
					name="sadress" maxlength=30 style="width: 170px"/> <span id="sadressSp"></span>
				</td>
			</tr>
			<tr>
				<td>邮&nbsp;&nbsp;&nbsp;&nbsp;编： <input type="text"
					name="spostcode" maxlength=30 style="width: 170px"/> <span id="spostcodeSp"></span>
				</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="" title="立即注册" height="40px"
					style="border:none;background:url(<%=path%>/front/image/icon_zc.png) 
					 left top no-repeat;width:148px; height:48px; cursor:pointer " />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
