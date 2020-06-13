<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
        <title>订单备注信息</title>
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
            <a href="/customer/product/list">
                <img src="/images/customer/back_white.png"
                     style="margin-top: 13px; margin-left: 15px; float:left;"
                     height="20px" width="20px">
            </a>
            <p style="margin-left: 26px; margin-top: 13px; float:left; font-size: 15px; color: white">
                订单详情
            </p>
        </div>

        <div class="incomplete_order" style="margin-top: 45px">
            <p>待付款</p>
            <p>支付完成后订单才会下到厨房呦</p>
        </div>
        <div class="main">
            <div class="invoice">
                <div>已点${productNum}个菜品</div>
                <#-- <span>桌号：23</span>-->
            </div>
            <ul class="food_list">
                <#list orderInfo.getOrderDetailList() as orderDetail>
                    <li class="food_li">
                        <img src="${orderDetail.getProductIcon()}" class="food_li_left">
                        <div class="food_li_middle">
                            <div>
                                <p>${orderDetail.getProductName()}</p>
                                <p></p>
                                <p>×${orderDetail.getProductQuantity()}</p>
                            </div>
                            <div class="food_li_price">
                                ¥${orderDetail.getProductPrice()*orderDetail.getProductQuantity()}</div>
                        </div>
                    </li>
                </#list>
            </ul>

            <div class="invoice total">
                <div>菜品小计：</div>
                <div class="food_price">¥ ${orderInfo.getOrderAmount()}</div>
            </div>

            <div class="invoice total">
                <div>座位号：</div>
                <div class="food_price">${orderInfo.getDeskNum()}</div>
            </div>
            <#--            <div class="invoice">-->
            <#--                <div>餐具小计：</div>-->
            <#--                <div class="food_price">¥ 4</div>-->
            <#--            </div>-->
            <div class="total_price">合计：<span>¥ ${orderInfo.getOrderAmount()}</span></div>
        </div>
        <#--        <div class="pay_notice">15分钟内未支付系统将自动取消订单</div>-->
        <div class="btn">
            <a href="/customer/order/cancel?orderId=${orderInfo.getOrderId()}">
                <button class="btn1">取消订单</button>
            </a>
            <a href="/customer/order/pay?orderId=${orderInfo.getOrderId()}">
                <button class="btn2">付款</button>
            </a>
        </div>
        <script src="/js/jquery.min.js"></script>
        <script>
            $(function () {
                $(".remark").focus(function () {
                    $(this).parent().height("100px");
                    $(this).addClass("tefocus");
                })
                $(".remark").blur(function () {
                    $(this).parent().height("40px");
                    $(this).removeClass("tefocus");
                })
            })

            //拦截返回键
            pushHistory();

            function pushHistory() {
                var state = {
                    title: "title",
                    url: "#"
                };
                window.history.pushState(state, "title", "#");
            };
            window.onpopstate = function () {
                location.href = '/customer/order/list';//自己的地址
            };
        </script>
    </body>
</html>
