<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
.btn{
	position:absolute;
	left:20px;
	top:250px;
	z-index:99;
}
</style>
<script type="text/javascript">

	//修改json
	function modifyer(id) {
		$(".myxunfu").show();
		/* $("#topicid").val(id); */
		addmodify(id);
		
	}
	
	$(function(){
		var date=new Date();
		var year =date.getFullYear();
		var month=date.getMonth();
		var day=date.getDay();
		var hour=date.getHours();
		var minute=date.getMinutes();
		var second=date.getSeconds();
		var shijian=year+"-"+(month+1)+"-"+(day+1)+" "+hour+":"+minute+":"+second;

		$("#time").textbox("setValue",shijian);	
		
	})
	
	function addmodify(id){
		$.ajax({
			url:"addmodify.action",
			dataType:"json",
			data:{"ti.topicid":id},
			success:function(data){
				$("#userid").textbox("setValue",data[0].uinfo.loginname);
				$("#title").textbox("setValue",data[0].title);
				$("#tcontents").textbox("setValue",data[0].tcontents);
			}
			
		})
	}
	//悬浮框隐藏
	function hider(){
		$(".myxunfu").hide();
	}
	
	//删除json
	function deleter(id){
			$.messager.confirm('删除框', '你确定要删除吗?', function(r){
				if (r){
					delet(id);
				}
			});
		}
	function delet(id){
		$.ajax({
			url:"adddelet.action",
			dataType:"json",
			data:{"ti.topicid":id},
			success:function(data){
				alert("删除成功");
				window.self.location.href="findtopic.action";
			}
		})
	}
	
	
	var current_page=${requestScope.fm.pagenumber};
	var maxpage=Math.ceil(${requestScope.count}/${requestScope.fm.pagesize});
	
	$(function(){
		$("#fenye").html(${requestScope.fm.pagenumber}+"/"+Math.ceil(${requestScope.count}/${requestScope.fm.pagesize}));
		
		$("#tabers").tabs('select',1);
	});
	
	function nex(){
		if(current_page<maxpage){
			current_page++;
			window.self.location.href="findtopic.action?pagesize=6&pagenumber="+current_page;
		}
	}
	function pre(){
		if(current_page>1){
			current_page--;
			window.self.location.href="findtopic.action?pagesize=6&pagenumber="+current_page;
		}
	}
	
	$(function(){
		$("input[type='checkbox']").on({
			"change":function(){
				if($(this).attr("flag")=="istop"){
					var istop=$(this).attr("checked");
					var topicid=$(this).attr("id");
					if(istop!="checked"){
						addtop(topicid,0);
						$(this).removeAttr("checked");
					}else{
						addtop(topicid,1);
						$(this).Attr("checked","checked");
					}
				}
			},
		});
		
		$("input[type='checkbox']").on({
			"change":function(){
				if($(this).attr("flag")=="isgood"){
					var isgood=$(this).attr("checked");
					var topicid=$(this).attr("id");
					if(isgood=="checked"){
						addgood(topicid,0);
						$(this).Attr("checked","checked");
					}else{
						addgood(topicid,1);
						$(this).removeAttr("checked");
					}
				}
			},
		});
	});
	
	function addtop(topicid,istop){
		$.ajax({
			url:"addtop.action",
			dataType:"json",
			data:{"ti.topicid":topicid,"ti.istop":istop},
			success:function(data){
				alert(data);
			},
		})
	}
	
	function addgood(topicid,isgood){
		$.ajax({
			url:"addgood.action",
			dataType:"json",
			data:{"ti.topicid":topicid,"ti.isgood":isgood},
			success:function(data){
				alert(data);
			},
		})
	}
	
	function saver(){
		if($("#ff").form("validate")){
			$("#ff").submit();
			$(".myxunfu").show();
		}
	}

</script>
</head>
<body>
	<div class="easyui-layout" style="width: 800px; height: 300px;">
		<div data-options="region:'center',title:'详情',iconCls:'icon-ok'">
			<div id="tabers" class="easyui-tabs"
				data-options="fit:true,border:false,plain:true">
				<div title="首页" data-options="href:''" style="padding: 10px">
					欢迎你的光临，管理员；
				</div>
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
								<th data-options="field:'df',align:'center'" width="90">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.topic}" var ="every" varStatus="vs">
								<tr>
									<td>${every.topicid}</td> 
									<td>${every.title}</td>
									<td>${every.tcontents}</td>
									<td>${every.uinfo.loginname}</td>
									<td>${every.postdate}</td>
									<td>${every.modifydate}</td>
									<td>
										<input flag="istop"  type="checkbox" id="${every.topicid}" <c:if test="${every.istop!=0}">checked="checked"</c:if>> 
									</td>
									<td>
										<input flag="isgood" type="checkbox" id="${every.topicid}" <c:if test="${every.isgood!=1}">checked="checked"</c:if>>
									</td>
									<td>
										<button class="easyui-linkbutton" onclick="modifyer(${every.topicid})">修改</button>
										<button class="easyui-linkbutton" onclick="deleter(${every.topicid});">删除</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<div class="btn">
							<p style="display: hidden; margin-top: 5px;"></p>
							<a href="javascript:;" class="easyui-linkbutton c1" style="width: 80px" onclick="pre()">
								上一页 </a>
							<a id="fenye" href="javascript:;" class="easyui-linkbutton c1" style="width: 40px" >
								</a>
							<a href="javascript:;" class="easyui-linkbutton c1" style="width: 80px" onclick="nex()">
								下一页 </a>
						</div>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div class="myxunfu">
		<div id="xuanfu" class="easyui-panel" title="发帖信息修改"
			style="width: 400px">
			<div style="padding: 10px 60px 20px 60px">
				<form id="ff" method="post" action="addchange.action">
					<p>
						发帖人:<input id="userid" class="easyui-textbox" type="text"
							 style="width:150px" disabled="false">
					</p>
					<p>
						标题:<input id="title" class="easyui-textbox" type="text" name="ti.title"
							data-options="required:true" style="width:150px">
					</p>
					
					<p>
						发帖内容:<input id="tcontents" class="easyui-textbox" type="text" name="ti.tcontents"
							data-options="multiline:true" style="width:150px">
					</p>

					<p>
						修改时间:<input id="time" class="easyui-textbox" name="ti.modifydate"
							 style="width:150px" disabled="false">
					</p>
				</form>
				<div style="text-align: center; padding: 5px">
					<a onclick="saver()" href="javascript:;" class="easyui-linkbutton"
						>提交</a> <a href="javascript:;"
						class="easyui-linkbutton" onclick="hider()">取消</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>