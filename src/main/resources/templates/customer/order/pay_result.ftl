<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
        <title>支付结果</title>
        <link rel="stylesheet" type="text/css" href="/css/customer/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="/css/customer/base.css">
        <link rel="stylesheet" type="text/css" href="/css/customer/payment_results.css">
        <style>
            .top {
                width: 100%;
                height: 45px;
                position: fixed;
                top: 0;
                background-color: #FF6633;
                z-index: 9999;
            }
        </style>
    </head>
    <body>
        <div class="top">
            <a href="/customer/index">
                <img src="/images/customer/back_white.png"
                     style="margin-top: 13px; margin-left: 15px; float:left;"
                     height="20px" width="20px">
            </a>
            <p style="margin-left: 26px; margin-top: 13px; float:left; font-size: 15px;color: white">
                支付结果
            </p>
        </div>

        <div class="incomplete_order" style="margin-top: 45px;">
            <p>支付成功</p>
            <p>${payResult.getOrderAmount()}</p>
            <a href="/customer/order/detail?orderId=${payResult.getOrderId()}">查看详情</a>
        </div>
        <div class="main_info">
            <#--            <div class="hang">-->
            <#--                <span>门店名称</span>-->
            <#--                <span>味千拉面（上海长寿路二分店）</span>-->
            <#--            </div>-->
            <div class="hang">
                <span>交易时间</span>
                <span>${payResult.getUpdateTime()}</span>
            </div>
            <div class="hang">
                <span>交易订单</span>
                <span>${payResult.getOrderId()}</span>
            </div>
        </div>
        <#--        <div class="invoice">-->
        <#--            <span>点一点，马上开发票</span>-->
        <#--            <span>开发票</span>-->
        <#--        </div>-->

        <script>
            pushHistory();

            function pushHistory() {
                var state = {
                    title: "title",
                    url: "#"
                };
                window.history.pushState(state, "title", "#");
            };

            window.onpopstate = function () {
                location.replace('/customer/index');//自己的地址
            };
        </script>

    </body>
</html>
