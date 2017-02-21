
$(function(){
	var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
	//验证姓名
	
	$("input[name='loginname']").focus(function() {
		$(this).text("用户名在2-20位 之间").addClass("state2");
	}).blur(function() {
		if($(this).val().trim().length>=2 && $(this).val().trim().length<=20 && $(this).val().trim().length!=0){
			$(this).next().text('输入成功').addClass("state4");
			ok1=true;
		}else{
			$(this).next().text('用户名在2-20位 之间').removeClass("state4").addClass("state3");
		}
	})
	
   
	
		


	//验证密码
	$("input[name='loginpwd']").focus(function(){
		$(this).next().text("密码在3-10位之间").addClass("state2");
	}).blur(function(){
		if($(this).val().trim().length>=3 && $(this).val().trim().length<=10 && $(this).val().trim().length!=0){
			$(this).next().text('输入成功').addClass("state4");
			ok2=true;
		}else{
			$(this).next().text('密码在3-10位之间').removeClass("state4").addClass("state3");
		}
	});
	//验证确认密码
	$("input[name='password1']").focus(function(){
		$(this).next().text("密码要输入一致").addClass("state2");
	}).blur(function() {
		if($(this).val().trim().length>=3 && $(this).val().trim().length<=10 && $(this).val().trim().length!=0 && $(this).val().trim()== $("input[name='loginpwd']").val().trim()){
			$(this).next().text('输入成功').addClass("state4");
			ok3 = true;
		}else{
			$(this).next().text("密码不一致，请重新输入").removeClass("state4").addClass("state3");
		}
	});
	//验证邮箱
	$("input[name='email']").focus(function() {
		$(this).next().text("输入正确的email 格式").addClass("state2");
	}).blur(function() {
		var reg =  /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if(reg.test($(this).val().trim())){
			$(this).next().text('输入成功').addClass("state4");
			ok4 = true;
		}else{
			$(this).next().text("输入正确的email 格式").removeClass("state4").addClass("state3");
		}
	})

	$("button").click(function() {
		if(ok1 && ok2 && ok3 && ok4){
			$("form").submit();
		}else{
			alert("请正确输入注册信息")
			return false;
		}
	});
})