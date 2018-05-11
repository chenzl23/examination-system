
// $(document).ready(function){
// 	$('#reg').click(function() {
// 		alert("lll");
// 		// if ($('#stunumber').val() == "") {
// 		// 	$('#stunumber').focus().css({
// 		// 		border: "1px solid red",
// 		// 		boxShadow: "0 0 2px red"
// 		// 	});
// 		// 	return false;
// 		// }
// 	}
// };
function validateForm() {
		 //alert("lll");
		if ($('#stunumber').val() == "") {
			$('#stunumber').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>/*学号不能为空*/</b></font>");
			return false;
		}else {
			$('#stunumber').focus().css({
				border: "1px solid grey",
				boxShadow: "0 0 2px grey"
			});
		}

		if ($('#stunumber').val().length !=9) {
			$('#stunumber').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>/*学号格式错误*/</b></font>");
			return false;

		} else {
			$('#stunumber').focus().css({
				border: "1px solid grey",
				boxShadow: "0 0 2px grey"
			});
		}
		if ($('#psw').val() == "") {
			$('#psw').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>/*密码不能为空*/</b></font>");
			return false;
		} else {
			$('#pwd').focus().css({
				border: "1px solid grey",
				boxShadow: "0 0 2px grey"
			});
		}

		//发送post请求
    	$.ajax({
			type: "POST",
        	dataType: "json",
        	url:"/user/login",
        	data:
				{
					username:$('#stunumber').val(),
					psw:$('#psw').val(),
					role:$("input:radio[name='optionsRadios']:checked").val()
				},
        	success: function (data) {
				if (data.state == "true")
				{
                    window.location.href="/index";
				}
				else if (data.state == "valid")
				{
					alert("已有用户登录，现直接跳转");
                    window.location.href="/index";
				}
				else
				{
                    $('#userCue').html("<font color='red'><b>/*账号或密码错误*/</b></font>");
				}
        	}
    	});


}

