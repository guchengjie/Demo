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
<style type="text/css">
.easyui-layout {
	position: relative;
}

.myxunfu {
	position: absolute;
	top: 15%;
	left: 25%;
	display: none;
}

</style>
<script type="text/javascript">
	function modify() {
		$(".myxunfu").show();
	}
	function confirm1(){
		$.messager.confirm('删除框', '确定要删除帖子吗？', function(r){
			if (r){
				alert('confirmed: '+r);
			}
		});
	}
	
</script>
</head>
<body>
	<div class="easyui-layout" style="width: 800px; height: 400px;">
		<div data-options="region:'center',title:'详情',iconCls:'icon-ok'">
			<div class="easyui-tabs"
				data-options="fit:true,border:false,plain:true">
				<div title="首页" data-options="href:''" style="padding: 10px"></div>
				<div title="发帖信息管理" style="padding: 5px">
					<table class="easyui-datagrid"
						data-options="method:'get',singleSelect:true,fit:true,fitColumns:true">
						<thead>
							<tr>
								<th data-options="field:'itemid',align:'center'" width="70">发帖ID</th>
								<th data-options="field:'productid',align:'center'" width="70">标题</th>
								<th data-options="field:'listprice',align:'center'" width="120">内容</th>
								<th data-options="field:'unitcost',align:'center'" width="80">发帖人</th>
								<th data-options="field:'attr1',align:'center'" width="80">发帖时间</th>
								<th data-options="field:'status',align:'center'" width="80">修改时间</th>
								<th data-options="field:'as',align:'center'" width="60">置顶</th>
								<th data-options="field:'sd',align:'center'" width="60">加精</th>
								<th data-options="field:'df',align:'center'" width="85">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>12</td>
								<td>lol</td>
								<td>超神</td>
								<td>msgu</td>
								<td>2016-12-12</td>
								<td>2016-12-12</td>
								<td><input type="checkbox"></td>
								<td><input type="checkbox"></td>
								<td><a href="javascript:;" class="easyui-linkbutton" onclick="modify();">修改</a></button>
									<a href="javascript:;" class="easyui-linkbutton" onclick="confirm1();">删除</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<p style="display: hidden; margin-top: 5px;"></p>
	<a href="javascript:;" class="easyui-linkbutton c1" style="width: 80px">
		上一页 </a>
	<a href="javascript:;" class="easyui-linkbutton c1" style="width: 80px">
		1/10 </a>
	<a href="javascript:;" class="easyui-linkbutton c1" style="width: 80px">
		下一页 </a>
	<div class="myxunfu">
		<div id="xuanfu" class="easyui-panel" title="发帖信息修改"
			style="width: 400px">
			<div style="padding: 10px 60px 20px 60px">
				<form id="ff" method="post">
					<p>
						发帖ID:<input class="easyui-textbox" type="text" name="name"
							data-options="required:true" style="width:150px">
					</p>

					<p>
						标题:<input class="easyui-textbox" type="text" name="email"
							data-options="required:true,validType:'email'" style="width:150px">
					</p>

					<p>
						内容:<input class="easyui-textbox" type="text" name="subject"
							data-options="required:true" style="width:150px">
					</p>

					<p>
						发帖人:<input class="easyui-textbox" name="message"
							data-options="required:true" style="width:150px">
					</p>
				</form>
				<div style="text-align: center; padding: 5px">
					<a href="javascript:;" class="easyui-linkbutton"
						onclick="">提交</a> <a href="javascript:;"
						class="easyui-linkbutton" onclick="">取消</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>