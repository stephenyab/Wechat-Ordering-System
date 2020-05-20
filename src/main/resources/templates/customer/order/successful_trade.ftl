<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
        <title>交易详情</title>
        <link rel="stylesheet" type="text/css" href="/css/customer/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="/css/customer/base.css">
        <link rel="stylesheet" href="/css/customer/order_notes.css">
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
                交易详情
            </p>
        </div>

        <div class="incomplete_order success_back" style="margin-top: 45px;">
            <p>交易成功</p>
            <p>谢谢您的光临，期待您下次再来</p>
        </div>
        <div class="main">
            <div class="invoice">
                <div>已点${productNum}样菜品</div>
                <#--                <span>桌号：23</span>-->
            </div>
            <ul class="food_list">
                <#list orderDetail.getOrderDetailList() as detailInfo>
                    <li class="food_li">
                        <img src="${detailInfo.getProductIcon()}" class="food_li_left">
                        <div class="food_li_middle">
                            <div>
                                <p>${detailInfo.getProductName()}</p>
                                <p></p>
                                <p>×${detailInfo.getProductQuantity()}</p>
                            </div>
                            <div class="food_li_price">
                                ¥${detailInfo.getProductPrice() * detailInfo.getProductQuantity()}</div>
                        </div>
                    </li>
                </#list>
            </ul>

            <div class="invoice">
                <div>菜品小计：</div>
                <div class="food_price">¥ ${orderDetail.getOrderAmount()}</div>
            </div>

            <div class="total_price">合计：<span>¥ ${orderDetail.getOrderAmount()}</span></div>
        </div>

        <#--        <div class="btn">-->
        <#--            <button class="btn1">开发票</button>-->
        <#--            <a href="evaluate.html">-->
        <#--                <button class="btn2">去评价</button>-->
        <#--            </a>-->
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
