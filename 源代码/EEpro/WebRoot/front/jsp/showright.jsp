<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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

<title>My JSP 'showright.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


</head>

<body>
	<DIV class="index_content_right">
		<DIV class="cut">
			<DIV class="cut_top provider opened"
				style="height: 90px; width: 180px; padding-top:20px;text-align: left;padding-left: 10px">
				<a class="linkYahei" href="<%=path%>/background/adminLogin.jsp" target="blank"><font
					color="rgb(22, 146, 116)" >后台管理</font>
				</a>
			</DIV>
			<UL>
				<LI style="width: 160px;text-align: center;"><A href="<%=path%>/front/jsp/userCenter/userPage.jsp">${fuser==null?'登陆':fuser}</A></LI>
				<LI style="width: 160px;text-align: center;"><A href="<%=path %>/FquiteLogin">${fuser==null?'':'安全退出'}</A></LI>
				
				<LI style="width: 180px;"><A href="<%=path%>/front/jsp/carPage.jsp">您还有<font color="red" size="5px">${car.totalCount==null?0:car.totalCount}</font>件商品未结算，请点击这里进入购物车</A></LI>
				
			</UL>
		</DIV>
		<DIV class="cut">
			<DIV class="cut_top collector"></DIV>
			<!-- <UL style="display: none;">
				<LI style="width: 60px;"><A href="">竞价公告</A></LI>
				<LI style="width: 60px;"><A href="">公共信息</A></LI>
			</UL> -->
		</DIV>
		<DIV class="clearit"></DIV>
		<DIV class="right_news">
			<DIV class="right_news_top">
				<IMG src="<%=path%>/front/image/icon_index_right01.png">
			</DIV>
			<UL>
				<!-- 系统公告缓存10分钟begin -->
				<LI><A title="2013年4月20日系统升级公告"
					onClick="showNewsDetail('021001', '18222');"
					href="javascript:void(0);">2013年4月20日系统... </A></LI>
				<LI><A title="2013年3月29日系统升级公告"
					onClick="showNewsDetail('021001', '17919');"
					href="javascript:void(0);">2013年3月29日系统... </A></LI>

				<!-- 系统公告缓存10分钟end -->
				<LI style="text-indent: 80px;"><A href="">查看更多</A></LI>
			</UL>
		</DIV>
		<DIV class="clearit"></DIV>
		<DIV class="right_img">
			<IMG src="<%=path%>/front/image/icon_index_right02.png">
		</DIV>
		<DIV class="clearit"></DIV>
		<DIV class="right_img">
			<IMG src="<%=path%>/front/image/icon_index_right03.png">
		</DIV>
		<DIV class="clearit"></DIV>
		<DIV class="right_img hotlines">
			<IMG style="cursor: pointer;"
				src="<%=path%>/front/image/icon_index_right04.png">
		</DIV>
		<DIV class="clearit"></DIV>
		<DIV class="right_input">
			<SELECT id="friendlink">
				<OPTION value="">------- 友情链接 -------</OPTION>
				<OPTION value="http://www.taobao.com">淘宝网</OPTION>
				<OPTION value="http://www.fjut.edu.cn">福建工程学院</OPTION>
				<OPTION value="http://www.speedfull.com">捷盈科技</OPTION>
			</SELECT>
		</DIV>
	</DIV>
	


</body>
</html>
