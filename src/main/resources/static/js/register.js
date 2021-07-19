function register() {
    $.ajax({
        url: "/user/register",
        type: "post",
        data: $('#regForm').serialize(),
        dataType: "json",
        success: function (data) {
            if (data.result == "success"){
                alert("注册成功,请登录")
                window.location.href='/login';
            }
        }
    })
}