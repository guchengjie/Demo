//全局变量
var nums = 1,
	times = 1;

$(function() {
		//	banner图轮播
		var swiper = new Swiper('.swiper-container', {
			pagination: '.swiper-pagination',
			paginationClickable: true,
			spaceBetween: 10,
			centeredSlides: true,
			autoplay: 3000,
			autoplayDisableOnInteraction: false
		});
	})
//侧边栏特效
$(function() {
	$("#doclick").click(function() {
		//侧边栏效果
		//实现思路，侧边栏通过fiexd的绝对定位和主体内容的相对定位，在以界面为基准线的左右定位移动。
		if(times == 1) {
			$(".aside_right").animate({
				"right": "0"
			}, 500);
			$(".aside_left").animate({
				"right": "3rem"
			}, 500);
			$("#doclick").attr("src", "images/ico_btn2.png");
			$("#doclick").bind("touchmove", function(event) {
				event.preventDefault(); //阻止默认事件的发生
			});
			times = 2;
		} else if(times == 2) {
			$(".aside_right").animate({
				"right": "-3rem"
			}, 500);
			$(".aside_left").animate({
				"right": "0"
			}, 500);
			$("#doclick").attr("src", "images/ico_btn2_hov.png");
			times = 1;
		}
	})
})
//	底部指纹按钮显示与隐藏
var numbers=1;
$(function(){
	$(".zhiwenmenu").siblings().hide();
	$(".zhiwenmenu").click(function(){
		if(numbers==1){
			$(this).siblings().show();
			$(this).siblings('.zhiwen-pic-one').animate({"left":"1rem"},500);
			$(this).siblings('.zhiwen-pic-two').animate({"left":"1.85rem"},500);
			$(this).siblings('.zhiwen-pic-three').animate({"left":"2.70rem"},500);
			$(this).siblings('.zhiwen-pic-four').animate({"left":"3.55rem"},500);
			$(this).siblings('.zhiwen-pic-five').animate({"left":"4.40rem"},500);
			$(".zhiwenmenu img").attr("src","images/ico_btn23.png");
			// $(".zhiwenmenu img").animate({'src':'images/ico_btn25.png'},500)
			numbers=2;
		}else if(numbers==2){
		$(this).siblings('.zhiwen-pic-one').animate({"left":"0px"},500);
		$(this).siblings('.zhiwen-pic-two').animate({"left":"0px"},500);
		$(this).siblings('.zhiwen-pic-three').animate({"left":"0px"},500);
		$(this).siblings('.zhiwen-pic-four').animate({"left":"0px"},500);
		$(this).siblings('.zhiwen-pic-five').animate({"left":"0px"},500);
		$(".zhiwenmenu img").attr("src","images/ico_btn22.png");
		// $(".zhiwenmenu").siblings().hide();
		numbers=1;
		}
	})
})
//实现跑马灯的效果
//$(function() {
//	function autoPlay() {
//		$(".content-tt li:first").slideUp(1000, function() {
//			$(this).show().appendTo(".content-tt");
//		})
//	}
//	var timer = setInterval(autoPlay, 1000);
//
//	$(".content-tt li").hover(function() {
//		clearInterval(timer);
//	}, function() {
//		timer = setInterval(autoPlay, 1000); //悬浮效果去除后，再次赋值自动播放
//	})
//})
//second 方法
$(function() {
	function autoGunDong() {
		$(".content-tt li:first").animate({
			"margin-top": "-0.4rem"
		}, 1000, function() {
			$(this).css("margin-top", 0).appendTo(".content-tt");
		})
	}
	var timer = setInterval(autoGunDong, 1000);
	//清除定时器
	$(".content-tt li").hover(function() {
		clearInterval(timer);
	}, function() {
		timer = setInterval(autoGunDong, 1000);
	})
})

//TAB切换  热门留学院校
$(function() {
	$(".to-liuxue .liuxue:gt(0)").hide();
	$(".nav-diqu ul").find("li").each(function(index) {
		// $(this) 当前选中的元素 鼠标移动
		$(this).click(function() {
			// $(this) 当前选中的元素 增加 on 样式 ，但是 其同胞元素 移除 on 样式
			//$(this).addClass("on").siblings().removeClass("on");
			$(".nav-diqu ul").find("li").removeClass("nav-diqu-show").eq(index).addClass("nav-diqu-show");
			// .slide 通过 eq(index) 选择器 来显示隐藏
			$(".to-liuxue .liuxue").hide().eq(index).show();
		})
	})
})

//返回顶部
// scrollTop() 滚动条的高度
$(function() {
	$(window).scroll(function(event) {
		$(window).scrollTop() > 320 ? $(".footer-top").show() : $(".footer-top").hide();
	});
	$(".footer-top").click(function(event) {
		$("html,body").animate({
			"scrollTop": 0
		}, 500);
	});
})

//优选方案的下拉菜单
$(function() {
	$(".header-con3").click(function() {
		if(nums == 1) {
			$(".content-youxuan-list").slideDown();
			$(".header-con3 #xiala").attr("src", "images/xiala_icon2.png");
			nums = 2;
		} else if(nums == 2) {
			$(".content-youxuan-list").slideUp();
			$(".header-con3 #xiala").attr("src", "images/xiala_icon1.png");
			nums = 1;
		}
	})
})

//页脚多选框
// $(function() {
// 		$(".footer-bottom").click(function() {
// 			if(times == 1) {
// 				$(".footer-bottom-list").animate({
// 					"left": "1rem"
// 				}, 500);
// 				$(".footer-bottom img").attr("src", "images/ico_btn23.png");
// 				$(".footer-bottom").bind("touchmove", function(event) {
// 					event.preventDefault(); //阻止默认事件的发生
// 				});
// 				times = 2;
// 			} else if(times == 2) {
// 				$(".footer-bottom-list").animate({
// 					"left": "-4.5rem"
// 				}, 500);
// 				$(".footer-bottom img").attr("src", "images/ico_btn22.png");
// 				times = 1;
// 			}
// 		})
// 	})
	//热门留学院校   加载更多
$(function() {
	$(".content-jiazai").click(function() {
		if(nums == 1) {
			$(".content-jz").html("点击收起更多");
			$(".to-liuxue .liuxue:visible").clone().insertAfter($(".to-liuxue .liuxue:visible"));
			nums = 2;
		} else if(nums == 2) {
			$(".content-jz").html("点击加载更多");
			$(".to-liuxue .liuxue:visible:last").remove();
			nums = 1;
		}
	})
})

//footer悬浮框  先隐藏10s在显示5s
var number=1
$(function() {
	function xuanFu() {
		if(number <= 20) {
			$(".footer-xuanfu").hide();
			number++;
		} else if(number > 20) {
			$(".footer-xuanfu").show();
			number++;
			if(number >= 25) {
				number = 1;
			}
		}
	}
	var timer = setInterval(xuanFu, 1000);
	$("#xf").hover(function() {
		clearInterval(timer);
	}, function() {
		timer = setInterval(xuanFu, 1000);
	})
})

// 取消键
$(function(){
	$("#xf span").click(function(){
		$("#xf").hide();
	})
})









