
jQuery(function($) {
    function checkPhone(phone){
        if(!(/^1[3456789]\d{9}$/.test(phone))){
            $.hulla = new hullabaloo();
            $.hulla.send("请输入正确的手机号："+ phone, "danger");
            return false;
        }
        return true;
    }
    var flag = true;
    var time = 60;
    $('#btn-smssend').on('click', function(e) {
        var moblie = $('#form-login-sms input[name="moblie"]').val();
        var checkphone = checkPhone(moblie);
        if(checkphone){
            //按钮置为不可用
            $(this).attr("disabled",true);
            if(flag){
                var timer = setInterval(function () {
                    if(time == 60 && flag) {
                        flag = false;
                        var data = {"moblie": moblie};
                        $.post("/code/sms", data, function (data) {
                            console.log(data);
                            if(data.body.code=='0000'){
                                $('#btn-smssend').html("已发送");
                            }
                        }, 'json')
                    }else if(time == 0){
                        $('#btn-smssend').removeAttr('disabled');
                        $('#btn-smssend').html('发送短信验证码');
                        clearInterval(timer);
                        flag=true;
                        time=60;
                    }else{
                        $('#btn-smssend').html(time + ' s 重新发送')
                        time--;
                    }
                },1000);
            }
        }

        e.preventDefault();
    });

    $('#btn-form-login-sms').on('click',function (e) {
        var url = $('#form-login-sms').attr("action");
        var moblie = $('#form-login-sms input[name="moblie"]').val();
        var smsCode = $('#form-login-sms input[name="smsCode"]').val();
        var rememberme = $('#form-login-sms input[name="remember-me"]').val();
        var data = {"moblie": moblie, "smsCode": smsCode, "remember-me": rememberme};
        postjson(url, data);
    });

    $('#btn-form-login').on('click', function (e) {
        // $('#form-login').submit()

        var url = $('#form-login').attr("action");
        var username = $('#form-login input[name="username"]').val();
        var password = $('#form-login input[name="password"]').val();
        var imageCode = $('#form-login input[name="imageCode"]').val();
        var rememberme = $('#form-login input[name="remember-me"]').val();
        var data = {"username": username, "password": password, "remember-me": rememberme, "imageCode": imageCode};
        postjson(url, data);
    });

    function postjson(url, data) {
        $.post(url, data, function (data) {
            console.log(data);
            $.hulla = new hullabaloo();
            if(data.code=='0000'){
                // alert("登录成功欢迎您的访问")
                $.hulla.send("登录成功欢迎您的访问！", "success");
                setTimeout(function() {
                    window.location.href = data.value;
                }, 2000);
            }else{
                // setTimeout(function() {
                    $.hulla.send("登录失败,原因："+ data.value, "danger");
                // }, 2000);
            }
        }, 'json')
    }

    function callback(data) {
        data.code
        alert("data" + data);
    }

})





