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

<title>商品类别</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<!-- <link rel="stylesheet" type="text/css" href="/EEpro/css/left_css.css"> -->
<link rel="stylesheet" type="text/css" href="<%=path%>/css/reg.css">
<script type="text/javascript">

function hide(id) 
{
		var tbody = document.getElementById("tbody" + id);
		var img = document.getElementById("img" + id);
		if (tbody.style.display == "none") 
		{
			tbody.style.display = "block";
			img.src = "background/image/collapse.gif";
			img.title = "点击隐藏大类别";
		} else {
			tbody.style.display = "none";
			img.src = "background/image/expand.gif";
			img.title = "点击显示大类别";
		}
}

function update(id,num) {
	
	
		var form=document.getElementById("updateForm");
		//var form="form"+id;
		//alert(form);
		var count=document.getElementById("typeName"+id);
		//var regex = /^a{3,15}$/;
		//alert(count.value);
		 if(count.value.length>15||count.value.length<3)
		{//alert(count);
			alert("类别名称长度3-15！");
			count.value=num;
		}else{
			
		form.action ="TypeServlet?btask=update&bmaxid="+id+"&typeName="+count.value; //设置处理程序
		//alert(form.action);
		form.submit(); //提交表单
		
		}
	}
</script>

</head>

<body>
	<form action="" name="updateForm" id="updateForm" method="post">
		<table border="0" align="center" width="50%" style="margin-top: 50px">
			<c:forEach items="${typeBeans}" var="typeBean" varStatus="vs">

				<c:if test="${typeBean.npid==0}">
					<tr>
						<td><img alt="点击伸缩" src="<%=path %>/front/image/collapse.gif"
							id="img${typeBean.nid}" onclick="hide(${typeBean.nid});" />
						</td>
						<td><input type="text" name="typeName"
							id="typeName${typeBean.nid}" value="${typeBean.sname}" />
						</td>
						<td width="15%"><a
							href="javascript:update(${typeBean.nid},'${typeBean.sname}');">修改</a>
						</td>
						<td width="15%"><a
							href="javascript:if(confirm('确认删除该类别？')){window.location.href='<%=path %>/TypeServlet?bmaxid=${typeBean.nid}&btask=remove';}">删除</a></td>
					</tr>
				</c:if>

				<tbody id="tbody${typeBean.nid}">
					<c:forEach items="${typeBeans}" var="typeBean2" varStatus="vs">

						<c:if test="${typeBean2.npid==typeBean.nid}">
							<tr>

								<td>
								<td><input type="text" name="typeName"
									id="typeName${typeBean2.nid}" value="${typeBean2.sname}" />
								</td>

								<td><a
									href="javascript:update(${typeBean2.nid},'${typeBean2.sname}')">修改</a>
								</td>
								<td><a
									href="javascript:if(confirm('确认删除该类别？')){window.location.href='<%=path %>/TypeServlet?bminid=${typeBean2.nid}&btask=remove';}">删除</a>
								</td>
							</tr>
						</c:if>

					</c:forEach>
				</tbody>
			</c:forEach>
			<tr>
				<td colspan="3" style="text-align: center;"><a href="AddTypeServlet">添加</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
