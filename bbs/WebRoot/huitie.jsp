<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/base.css">
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="locale/easyui-lang-zh_CN.js"></script>
<title>发帖信息</title>
</head>
<body>
	<div class="easyui-layout" style="width:750px;height:600px;">
		<div data-options="region:'center',title:'详情',iconCls:'icon-ok'">
			<div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
				<div title="首页" data-options="href:''" style="padding:10px"></div>
				<div title="回帖信息管理" style="padding:5px">
					<table class="easyui-datagrid"
							data-options="url:'http://bbs.itany.com/portal.php',method:'get',singleSelect:true,fit:true,fitColumns:true">
						<thead>
							
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>