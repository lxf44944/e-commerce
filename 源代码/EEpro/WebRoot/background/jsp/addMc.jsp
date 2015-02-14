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

<title>My JSP 'addMc.jsp' starting page</title>

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
function changeImage(file){
		var img = document.getElementById("imgId");
		var s = "yyy";
		
		//判断图片格式jpg/png/gif/BMP 文件的后缀
		var ext = file.substring(file.lastIndexOf(".")+1);
	//	alert("ext="+ext);
		var regex = /^(jpg|png|gif|bmp)$/;
		//alert(regex.test(ext));
		if(regex.test(ext)){
			img.src=file;	
			
		}else{
			alert('图片格式不合法jpg,png,gif,bmp');			
		}		
	}	

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
  
  function testSuser() {
	// 用户名: 必填, 且长度不小于3;
	var user = sform.sname.value;
	var userSp = document.getElementById("snameSp");

	var regex = /^a{3,15}$/;

	// alert(regex.test(sname));
	if (user != null && user != "") {
		if (user.length>=3&&user.length<=15) {
			userSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">商品名合法</font>";
			return true;
		} else {
			userSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">商品名长度不合法，长度应该在3-15字符!</font>";
		}
	} else {
		userSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">商品名不能为空!</font>";
	}
	return false;
}

function testNprice() {

	var nprice = sform.nprice.value;

	var npriceSp = document.getElementById("npriceSp");
	var regex = /^[-|+]?\d*([.]\d{0,2})?$/;
	if (nprice != null && nprice != "") {
		if (regex.test(nprice)) {
			npriceSp.innerHTML = "<img src=\"front/image/agree_ok.gif\"/><font color=\"green\">价格合法</font>";
			return true;
		} else {
			npriceSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">价格最多包含2位小数!</font>";
		}
	} else {
		npriceSp.innerHTML = "<img src=\"front/image/agree_no.gif\"/><font color=\"red\">价格不能为空!</font>";
	}
	return false;
}
  
  function checkSform() {
	var t = testSuser() && testNprice();
	// alert(t);
	return t;
}
  </script>
</head>

<body>
	<form method="post" action="<%=path %>/AddMcServlet" name="sform" enctype="multipart/form-data"
		onsubmit="return checkSform();">
		<table width=800 height=100 border=0 cellpadding=5 align="center">
			<caption
				style="font-size: 20px;padding-bottom: 20px;padding-top: 30px">商品添加</caption>
			<tr>
				<td>商品名称： <input type="text" name="sname" value="" maxlength=30 />
					<span id="snameSp"></span>
				</td>
			</tr>

			<tr>
				<td>商品价格： <input type="text" name="nprice" maxlength=30
					value="" /> <span id="npriceSp"></span>
				</td>
			</tr>
			<tr>
				<td><font style="margin-top: 0px">商品描述:</font>
				</td>
			</tr>
			<tr>
				<td width="200px"><textarea name="sdescription" title="商品描述"
						cols="50" rows="10"></textarea> <span id="sdescriptionSp" /></span>
				</td>
			</tr>
			<tr>
				<td>商品图片：<input type="file" name="simg"  onchange="changeImage(this.value);"/>
  
				</td>
			</tr>
			<tr>
			<td> 图片浏览:</td>
			</tr>
			<tr>
			<td><img src="" alt="显示您即将要上传的图片" width="100px" height="100px" id="imgId"/></td>
			</tr>
			<tr>
				<td>是否缺货： <input type="radio" name="smctag" value="0"
					style="width:50px;" checked="checked" /> 否
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="smctag" value="1"
					style="width:50px;" /> 是</td>
			</tr>
			<tr>
				<td width="100">所属大类：<select class="index_select"
					name="nmaxid" id="nmaxid" onchange="getMin()">
						<option value="-1">无</option>
						<c:forEach items="${typeBeans}" var="maxtype" varStatus="vs">
							<c:if test="${maxtype.npid==0}">
								<option value="${maxtype.nid}" ${maxtype.nid==smaxid?'selected':''}>${maxtype.sname}</option>
							</c:if>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td width="100">所属小类：<select class="index_select" name="nminid"
					id="nminid">
						<option value="-1">无</option>
						<!-- 小类下：保留查询条件，根据作用域中的大类编号迭代对应得的小类，设置?'selected':'' -->
						<c:forEach items="${typeBeans}" var="mintype" varStatus="vs">
							<c:if test="${mintype.npid==smaxid}">
								<option value="${mintype.nid}" ${mintype.nid==sminid?'selected':''}>${mintype.sname}</option>
							</c:if>
						</c:forEach>
				</select>
				</td>
			</tr>

			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="保存" title="保存"
					style="border:none;width:100px; height:38px; cursor:pointer " />
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" title="重置"
					style="border:none;width:100px; height:38px; cursor:pointer " />
				</td>

			</tr>
		</table>
	</form>
</body>
</html>
