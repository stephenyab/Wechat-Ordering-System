<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
        <title>个人资料</title>
        <script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
        <link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
        <script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
        <style>
            .top {
                width: 100%;
                height: 40px;
                position: fixed;
                top: 0;
                z-index: 9999;
            }
        </style>
    </head>

    <body>

        <div class="top">
            <a href="/customer/index">
                <img src="/images/customer/back.png"
                     style="margin-top: 13px; margin-left: 15px; float:left;"
                     height="20px" width="20px">
            </a>
            <p style="margin-left: 28px; margin-top: 13px; float:left; font-size: 15px">
                详细信息
            </p>
        </div>

        <div style="width: 100%; min-height: 120px; margin-top: 54px; text-align: center">
            <div style="border-radius:50%">
                <img style="width: 80px; height: 80px;"
                     src="${userInfo.getUserHeadimgurl()}"
                     alt="头像">
            </div>

            <b>
                <p style="margin-top: 18px; font-size: 15px; color: black">
                    ${userInfo.getUserName()} &nbsp;
                    <#if userInfo.getUserSexEnum().getMessage() == "男">
                        <img src="/images/customer/male.png"
                             style="width: 17px; height: 17px; margin-bottom: 2px">
                    <#elseif userInfo.getUserSexEnum().getMessage() == "女">
                        <img src="/images/customer/female.png"
                             style="width: 17px; height: 17px; margin-bottom: 2px">
                    <#else>
                        <img src="/images/customer/sex_unknown.png"
                             style="width: 17px; height: 17px; margin-bottom: 2px">
                    </#if>
                </p>
            </b>

        </div>

        <div style="width: 100%; margin-top: 30px;">
            <div style="margin-left: 15px">
                <div style="margin-bottom: 10px">
                    <img src="/images/customer/ID.png" width="20px" height="20px"
                         style="margin-right: 5px; margin-bottom: 3px;">
                    <b><span style="font-size: 14px;">用户ID</span></b>
                </div>
                <p style="margin-left: 30px; font-size: 14px">${userInfo.getUserOpenid()}</p>
                <hr style="height: 2px; background-color: #F6F6F6; border: none; margin-right: 30px; margin-left: 30px;">
            </div>

            <div style="margin-left: 15px">
                <div style="margin-bottom: 10px">
                    <img src="/images/customer/address.png" width="20px" height="20px"
                         style="margin-right: 5px; margin-bottom: 3px;">
                    <b><span style="font-size: 14px;">常住地</span></b>
                </div>
                <p style="margin-left: 30px; font-size: 14px">
                    ${(userInfo.getUserCountry())!"未知"}-${(userInfo.getUserProvince())!"未知"}
                    -${(userInfo.getUserCity())!"未知"}
                </p>
                <hr style="height: 2px; background-color: #F6F6F6; border: none; margin-right: 30px; margin-left: 30px;">
            </div>

            <div style="margin-left: 15px">
                <div style="margin-bottom: 10px">
                    <img src="/images/customer/phone.png" width="20px" height="20px"
                         style="margin-right: 5px; margin-bottom: 3px;">
                    <b><span style="font-size: 14px;">联系电话</span></b>
                </div>
                <div onclick="changePhone()">
                    <span style="margin-left: 30px; font-size: 14px">
                        ${(userInfo.getUserPhone())!" "}
                    </span>
                    <img style="float:right; margin-right: 30px;"
                         width="24px" height="24px"
                         src="/images/customer/change.png">

                </div>
                <hr style="height: 2px; background-color: #F6F6F6; border: none; margin-right: 30px; margin-left: 30px;">
            </div>

            <div style="margin-left: 15px">
                <div style="margin-bottom: 10px">
                    <img src="/images/customer/register_time.png" width="20px" height="20px"
                         style="margin-right: 5px; margin-bottom: 3px;">
                    <b><span style="font-size: 14px;">注册时间</span></b>
                </div>
                <p style="margin-left: 30px; font-size: 14px">
                    ${userInfo.getRegisterTime()}
                </p>
                <hr style="height: 2px; background-color: #F6F6F6; border: none; margin-right: 30px; margin-left: 30px;">
            </div>

            <div style="margin-left: 15px">
                <div style="margin-bottom: 10px">
                    <img src="/images/customer/order_record.png" width="20px" height="20px"
                         style="margin-right: 5px; margin-bottom: 3px;">
                    <b><span style="font-size: 14px;">消费记录</span></b>
                </div>
                <p style="margin-left: 30px; font-size: 14px">
                    订单总数：${totalOrderNum}<br>
                    完结订单数：${totalOrderFinishNum}<br>
                    订单总金额：${totalOrderAmount}
                </p>
                <hr style="height: 2px; background-color: #F6F6F6; border: none; margin-right: 30px; margin-left: 30px;">
            </div>

        </div>

        <script>
            function changePhone() {
                var phone = prompt("请输入新的联系电话");

                if (phone == "") {
                    alert("手机号码为空，请重新输入");
                    return false;
                } else if (!(/^1[3456789]\d{9}$/.test(phone))) {
                    alert("手机号码格式错误，请重新输入");
                    return false;
                } else {
                    $.ajax({
                        type: "post",
                        url: "http://${webSocketUrl}/customer/info/changePhone",
                        data: {
                            phone: phone,
                            f: "json"
                        },
                        dataType: "json",
                        async: false,
                        success: function (data) {
                            if (data["result"] == "success") {
                                alert("联系电话修改成功");
                                location.reload();
                            } else if (data["result"] == "fail") {
                                alert("系统出现错误，请稍后重试！");
                            }
                        },
                        error: function (e) {
                            alert("系统出现错误，请稍后重试！");
                        }
                    });
                }
            }

        </script>

    </body>

</html>
