<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
<script type="text/javascript">
	
	$(function(){
		//正则表达式:用来检查用户输入的信息是否符合要求
		//var reg = new RegExp();
	/* 	var reg =/^[a-z0-9_-]{3,16}$/;
		//test()返回布尔值 
		var flag = reg.test("@@@@@");
		alert(flag);
		 */
		 
		//给提交按钮绑定单击事件
		$("#sub_btn").click(function(){
			//获取用户输入的表单项信息
			var username = $("[name=username]").val();
			var password = $("[name=password]").val();
			var repwd = $("[name=repwd]").val();
			var email = $("[name=email]").val();
			var code = $("[name=code]").val();
			
			//通过正则表达式的test方法来检查用户输入的表单项信息是否符合要求
			var reg = /^[a-z0-9_-]{3,16}$/;
			var flag = reg.test(username);
			if(!flag){
				//如果用户名不符合要求
				alert("您输入的用户名不符合要求，请重新输入");
				return false;
			}
			
			reg = /^[a-z0-9_-]{6,18}$/;
			flag = reg.test(password);
			if(!flag){
				//如果密码不符合要求
				alert("您输入的密码不符合要求，请重新输入");
				return false;
			}
			
			//对密码与确认密码进行比对
			flag = password == repwd;
			if(!flag){
				alert("您输入的密码与确认密码不一致，请重新输入");
				return false;
			}
			
			//对邮箱进行验证
			reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			flag = reg.test(email);
			if(!flag){
				alert("您输入的邮箱格式不正确，请重新输入");
				return false;
			}
			
			//对验证进行验证
			if(code==""){
				alert("验证码不能为空，请重新输入");
				return false;
			}
			
			//取消按钮默认行为
			//return false;
		});
		 
		$("#code").click(function(){
			$(this).prop("src","${pageContext.request.contextPath}/code.jsp?t="+Math.random());
		});
		
		$("[name=username]").change(function(){
			//获取用户输入文本
			var username = $(this).val();
			$.post("${pageContext.request.contextPath}/client/UserServlet",{"method":"checkUsername","username":username},function(data){
				//根据返回值进行处理
				if(data){
					//不可用
					$(".errorMsg").html("用户名存在，请重新输入");
					$("#sub_btn").attr("disabled",true);
				}else{
					//可用
					$(".errorMsg").html("")
					$("#sub_btn").attr("disabled",false);
				}
			},"json")
		})
	});
	
</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${empty msg?"":msg}</span>
							</div>
							<div class="form">
								<form action="client/UserServlet?method=regist" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" value="${param.username }" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" value="${param.password }" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" value="${param.email }"  placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code"/>
									<img alt="" id="code" src="code.jsp" style="float: right; margin-right: 40px;width:90px;height:35px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>