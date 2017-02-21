var ok1,ok2,ok3,ok4,ok5;
var time=61;
//手机号码验证
function checkTel(){
	var reg=/^[1][1-9]{2}[1-9]{1}\d{7}$/;
	if(!reg.test(check("tel").value)){
		check("errorTel").className="error";
		check("errorTel").innerHTML="号码格式错误";
		ok1=false;
	}else{
		check("errorTel").className="ok";
		check("errorTel").innerHTML="OK";
		ok1=true;
	}
}
//密码验证
function checkPwd(){
	var reg=/^[\da-z]{6,10}$/i;
	if(!reg.test(check("pwd").value)){
		check("errorPwd").className="error";
		check("errorPwd").innerHTML="确认密码错误";
		ok2=false;
	}else{
		check("errorPwd").className="ok";
		check("errorPwd").innerHTML="OK";
		ok2=true;
	}
}
//确认密码验证
function checkRepwd(){
	if(check("repwd").value!=check("pwd").value||check("repwd").value==""){
		check("errorRe").className="error";
		check("errorRe").innerHTML="密码不重复";
		ok3=false;
	}else{
		check("errorRe").className="ok";
		check("errorRe").innerHTML="OK";
		ok3=true;
	}
}
//email验证
function checkEmail(){
	var reg=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
	if(!reg.test(check("email").value)){
		check("errorEmail").className="error";
		check("errorEmail").innerHTML="email有误";
		ok4=false;
	}else{
		check("errorEmail").className="ok";
		check("errorEmail").innerHTML="OK";
		ok4=true;
	}
}
//checkbox的验证
	function checkBox(){
		if(check("checkb").checked){
			ok5=true;
			check("sbt").style.background="orange";
		}else{
			ok5=false;
			check("sbt").style.background="#ccc";
		}
	}

//表单提交验证
function checkForm(){
	if(ok1&&ok2&ok3&&ok4&&ok5){
		$.cookies("username","$('#tel').val()");//写cookies
		check("tj").style.display="block";
	    setTimeout("check('fom1').submit()",2000);
	}else{
		alert("信息有误，请检查！");
		return false;
	}
}
//读取cookie
$(function(){
	$("#readcook").innerHTML="$.cookies('username')";
})

// 清除悬浮框
	$(function(){
	    check("bgl").onclick=function(){
			check("bgl").style.display="none";
			check("xuanfu").style.display="none";
	    }	
	})

//page2的短信验证码验证
function doQueRen(){
	if(check("test").value=="888888"){
		check("fom2").submit();
	}else{
		alert("验证码有误，请检查！");
		return false;
	}
}
//page2的短信发送倒计时
/*	var counts=60;
	function doFaSong2(){
		var btn=check("yanzhen2");
		btn.disabled=true;
		var timer=setInterval(write,1000);
		function write(){
			counts--;
			if(counts>0){
				btn.innerHTML=counts+"后可重新发送";
			}else{
				btn.innerHTML="重新发送短信";
				btn.disabled=false;
				clearInterval(timer);
				counts=60;
			}
		}	
	}*/
function doFaSong(){
	time--;
	if(time>=0){
		check("yanzhen2").innerHTML=time+"后可重新发送";
		setTimeout(doFaSong,1000);
	}else{
		check("yanzhen2").innerHTML="点击重新发送短信";
		time=61;
	}
}

//page3js效果   公用的悬浮框跳转
function doXuFu(){
	check("bgl").style.display="block";
	check("xuanfu").style.display="block";
}
//悬浮面板的tab切换效果,必须在页面加载完成后
$(function(){
	$(".xuanfu-left").bind({
	"mouseover": function (){
		console.log("wo zai xuan fu");
		$(".xuanfu-bottom").css("display","block");
		$(".xuanfu-bottom1").css("display","none");
	}
	});
	$(".xuanfu-right").bind({
	"mouseover": function (){
		$(".xuanfu-bottom1").css("display","block");
		$(".xuanfu-bottom").css("display","none");
	}
    });
})









function check(id){
	return document.getElementById(id);
}