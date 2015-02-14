<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("sid", request.getParameter("sid"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单审核</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=path %>/css/reg.css">
<script type="text/javascript">
function testSname() {
	// 真实姓名 : 必填; 且长度不能大于 15

	var name = orderSureForm.smsg.value;
		
	var nameSp = document.getElementById("smsgSp");
//	regex = /^a{0,15}$/;
//	regex = /^([\u4e00-\u9fa5]+|([a-z]+\s?)+)$/;

		if (name.length <= 1000) {
			nameSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">反馈信息合法</font>";
			return true;
		} else {
			nameSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">反馈信息长度不合法，长度不能大于1000个字符!</font>";
		}
	
	return false;
}

function checkSform() {
	var t = testSname();
	//alert(t);
	return t;
}
</script>
  </head>
  
  <body>
    <form action="<%=path %>/CheckOrderServlet?sid=${sid}" method="post" name="orderSureForm" onsubmit="return checkSform();">
   	<table align="center" style="margin-top: 50px; width: 90%">
   	<h4>审核状态：</h4>
   		<tr>
   		
   		<td><input type="radio" name="status" value="1" checked="checked"/>未审核</td>
   		<td><input type="radio" name="status" value="2"/>审核通过</td>
   		<td><input type="radio" name="status" value="3"/>审核未通过</td>
   		</tr>
   		<tr><td><h4>订单反馈信息</h4></td></tr>
   		<tr>
   		<td colspan="3">
   		<textarea rows="20" cols="70" name="smsg"></textarea><span id="smsgSp"></span>
   		</td>
   	
   		</tr>
   		<tr>
   		<td><input type="submit" value="确认提交"/></td>
   		<td></td>
   		<td><input type="button" value="返回订单列表" onclick="window.history.back()"/></td>
   		</tr>
   	</table>
   	</form>
  </body>
</html>
