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

<title>后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<frameset rows="59,*" frameborder="no" border="0" framespacing="0">
	<frame src="<%=path%>/background/jsp/top.jsp" noresize="noresize"
		frameborder="0" name="topFrame" marginwidth="0" marginheight="0"
		scrolling="no">
	<frameset rows="*" cols="188,7,*" id="frame">
		<frame src="<%=path%>/background/jsp/menu.jsp" name="leftFrame"
			noresize="noresize" marginwidth="0" marginheight="0" frameborder="0"
			scrolling="auto">
		<frame src="<%=path%>/background/jsp/centerFrame.jsp" scrolling="no" noresize="noresize"
			id="centerframe" />
		<frame src="<%=path %>/background/jsp/welcome.jsp" name="rightFrame" id="rightFrame"
			marginwidth="0" marginheight="0" frameborder="0" scrolling="yes">
	</frameset>
	<frame src="<%=path%>/background/jsp/bFooter.jsp" noresize="noresize"
		frameborder="0" name="bottomFrame" marginwidth="0" marginheight="0"
		scrolling="no">
	<noframes>
		<body></body>
	</noframes>
</frameset>
</head>


<body>
</body>
</html>
