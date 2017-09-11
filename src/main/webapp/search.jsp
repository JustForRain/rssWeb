<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<!-- 引入bootstrap -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!-- 引入JQuery  bootstrap.js-->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container" id="content">
		<div class="row">
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<h1 class="col-md-5">RSS地址分析</h1>
							<form class="bs-example bs-example-form col-md-6" role="form"
								style="margin: 20px 0 10px 0;" action="search.do" id="form1"
								method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入RSS地址"
										name="rssUrl"> <span class="input-group-addon btn"
										onclick="search(document.getElementById('form1').rssUrl.value)">搜索</span>
								</div>
							</form>

						</div>
					</div>
					<table class="table table-bordered" style="word-break:break-all; word-wrap:break-all;">
						<thead>
							<tr>
								<th>标题</th>
								<th>上传者</th>
								<th>上传日期</th>
								<th>下载链接</th>
							</tr>
						</thead>
						<tbody id="result">
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	function search(date) {
		var contentTableBody = document.getElementById("result");
		var size = contentTableBody.childNodes.length;
		for (var i = size - 1; i >= 0; i--) {
			contentTableBody.removeChild(contentTableBody.childNodes[i]);
		}
		$.ajax({
			type : "post",
			"url" : "${pageContext.request.contextPath}/search.do",
			data : {
				rssUrl : date
			},
			"dataType" : "json",
			success : function(result) {
				$.each(result.list, function(i, items) {
					$("#result").append(
						"<tr>" +
						"<td>" + items.title + "</td>" +
						"<td>" + items.author + "</td>" +
						"<td>" + items.pubDate + "</td>" +
						"<td><a heef='" + items.downLoadUrl + "'>下载链接</a></td>" +
						"</tr>"
					);
				});
			},
			error : function() {
				alert("服务器错误");
			}
		})
	}
</script>
</html>
