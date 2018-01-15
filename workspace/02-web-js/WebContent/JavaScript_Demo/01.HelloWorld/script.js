	//给window.onload属性赋一个function函数
	window.onload = function(){
		//获取按钮元素
		var btn = document.getElementById("btnId");
		//给按钮元素绑定一个onclick属性
		btn.onclick = function(){
			alert("我会JS操作了******");
		}
	}