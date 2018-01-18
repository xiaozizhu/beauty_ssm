//存放主要交互逻辑的js代码

var handler = {
    //封装相关ajax的url
    URL: {
        goodsBuy: function (goodsId) {
            return '/goods/' + goodsId + '/buy';
        },
        goodsAdd: function () {
            return '/goods/adds';
        },
        userLogin:function () {
            return "/user/assert";
        },
        userAdd:function () {
            return "/user/add";
        },

    },
    //验证手机号
    validatePhone: function (phone) {
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;//直接判断对象会看对象是否为空,空就是undefine就是false; isNaN 非数字返回true
        } else {
            return false;
        }
    },
    //详情页秒杀逻辑
    goods: {
        //详情页初始化
        init: function (params) {
            //在cookie中查找手机号
            var userPhone = $.cookie('userPhone');
            //验证手机号
            if (!handler.validatePhone(userPhone)) {
                //绑定手机 控制输出
                var loginModal = $('#loginModal');
                loginModal.modal({
                    show: true,//显示弹出层
                    backdrop: 'static',//禁止位置关闭
                    keyboard: false//关闭键盘事件
                });

                $('#loginBtn').click(function () {
                    var inputPhone = $('#userPhone').val();
                    if (handler.validatePhone(inputPhone)) {
                        //电话写入cookie(7天过期)
                        $.cookie('userPhone', inputPhone, {path:'/',expires: 7});
                        //验证通过　　刷新页面
                        window.location.reload();
                    } else {
                        $('#userPhoneMessage').hide().html('<label class="label label-danger">手机号错误!</label>').show(300);
                    }
                });
            }
        }
    },

    //购买商品
    goodsBuy: function (goodsId) {
        //执行购买请求
        $.post(handler.URL.goodsBuy(goodsId), {}, function (result) {
            if (result && result['success']) {
            	alert("购买成功！");
            	window.location.reload();
            }else{
            	alert(result['error']);
            }
            
        });

    },

    //新增商品
    goodsAdd: function (title,price,number) {

        if (title&&price&&number){
            //执行ADD请求
            $.post(handler.URL.goodsAdd(), {"title":title,"price":price,"number":number}, function (result) {
                if (result && result['success']) {
                    alert("新增商品成功！");
                    window.location.href="/goods/list";
                }else{
                    alert(result['error']);
                }

            });

        }else{
            alert("title或者price或者number不能为空");
        }

    },


    //验证登录
    userLogin: function (userPhone,passwd) {
        if (userPhone&&passwd){
            $.post(handler.URL.userLogin(), {"userPhone":userPhone,"passwd":passwd}, function (result) {
                if (result && result['success']) {
                    alert("登录成功！");
                    //电话写入cookie(7天过期)
                    $.cookie('userPhone', userPhone, {expires: 7,path:'/'});
                    $.cookie('userPermission', userPhone, {expires: 7,path:'/'});
                    window.location.href="/user/mineapi?userPhone="+userPhone;
                }else{
                    alert(result['error']);
                }

            });

        }else{
            alert("电话或者密码不能为空");

        }
    },


    //用户注册
    userAdd:function (userPhone,userName,passwd) {
        if (userPhone&&userName&&passwd){
            $.post(handler.URL.userAdd(),{"userName":userName,"userPhone":userPhone,"passwd":passwd},function(result){
                if (result&&result['success']){
                    alert("注册成功！");
                    window.location.href="/user/login";

                }else {
                    alert("注册失败");
                }

            });

        }else{
            alert("电话或者用户名或者密码不能为空");
        }

    },

}