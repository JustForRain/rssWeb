<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>RSS地址分析</title>
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
							<!-- 
							<form class="bs-example bs-example-form col-md-6" role="form"
								style="margin: 20px 0 10px 0;"
								action="rssadmin/findByRssName.do" id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入RSS名字"
										name="rssName"> <span class="input-group-addon btn"
										onclick="searchh(document.getElementById('form1').rssName.value)">搜索</span>
								</div>
							</form>
							 -->
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown">
									我的订阅 <span class="caret"></span>
								</button>
								<ul id="list" class="dropdown-menu" role="menu">
								<li><a id="items" onclick="searchh(document.getElementById('items').innerText)" href="javascript:void(0);"></a></li>
								</ul>
							</div>
						</div>
					</div>
					<table class="table table-bordered"
						style="word-break:break-all; word-wrap:break-all;">
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
$(function(){
	$.ajax({
			type : "post",
			"url" : "${pageContext.request.contextPath}/rssadmin/findAll.do",
			"dataType" : "json",
			success : function(result) {
				$.each(result.list, function(i, items) {
				console.log(items.id);
					$("#list").append(
					"<li><a id=\""+items.id+
					"\" onclick=\"searchh(document.getElementById('"+items.id+
					"').innerText)\" href=\"javascript:void(0);\">"+items.name+
					"</a></li>"
					);
				});
			},
			error : function() {
				alert("服务器错误");
			}
		})
});
	function searchh(date) {
		var contentTableBody = document.getElementById("result");
		var size = contentTableBody.childNodes.length;
		for (var i = size - 1; i >= 0; i--) {
			contentTableBody.removeChild(contentTableBody.childNodes[i]);
		}
		$.ajax({
			type : "post",
			"url" : "${pageContext.request.contextPath}/rssadmin/findByRssName.do",
			data : {
				rssName : date
			},
			"dataType" : "json",
			success : function(result) {
				$.each(result.list, function(i, items) {
					$("#result").append(
						"<tr>" +
						"<td>" + items.title + "</td>" +
						"<td>" + items.author + "</td>" +
						"<td>" + items.pubDate + "</td>" +
						"<td><a href='" + items.downLoadUrl + "'>下载链接</a></td>" +
						"</tr>"
					);
				});
			},
			error : function() {
			}
		})
	}
</script>
</html>
