<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
        <title>交易详情</title>
        <link rel="stylesheet" type="text/css" href="/css/customer/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="/css/customer/base.css">
        <link rel="stylesheet" href="/css/customer/order_notes.css">
        <script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
        <link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
        <script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
        <style>
            body {
                background-color: #F7F7F7;
            }

            .style5 {
                text-align: right;
                padding: 0 10px;
                line-height: 40px;
                background: #fff;
                width: 100%;
                height: 60px;
            }

            .style6 {
                width: 100%;
                display: flex;
                justify-content: flex-end;
                color: #f63;
                height: 60px;
                align-items: center;
            }

            .style7 {
                background: #f63;
                color: #fff;
                border: 1px solid #f63;
                border-radius: 4px;
            }

            .style8 {
                background: #fff;
                color: #333;
                border: 1px solid #B8B8B8;
                border-radius: 4px;
            }

            .top {
                width: 100%;
                height: 50px;
                background-color: white;
                position: fixed;
                top: 0;
                z-index: 9999;
            }

            button {
                line-height: 30px;
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
            <p style="margin-left: 26px; margin-top: 13px; float:left; font-size: 15px">
                所有订单
            </p>
        </div>

        <div class="main" style="margin-top: 50px">
            <#list orderDTOList as orderDTO>

                <div class="invoice">
                    <div>${orderDTO.getUpdateTime()}</div>
                    <span>订单状态：${orderDTO.getOrderStatusEnum().getMessage()} (${orderDTO.getPayStatusEnum().getMessage()})</span>
                </div>

                <div class="invoice">
                    <div>订单小计：</div>
                    <div class="food_price">¥ ${orderDTO.getOrderAmount()}</div>
                </div>

                <div class="invoice">
                    <div>座位号：</div>
                    <div class="food_price">${orderDTO.getDeskNum()}</div>
                </div>

                <ul class="food_list" style="margin-bottom: 0px;">
                    <#list orderDTO.getOrderDetailList() as detailInfo>
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

                <#if orderDTO.getOrderStatusEnum().getMessage() != "已取消">
                    <div class="style5">
                        <div class="style6">
                            <#if orderDTO.getOrderStatusEnum().getMessage() == "新订单">
                                <a href="/customer/order/cancel?orderId=${orderDTO.getOrderId()}">
                                    <button style="width: 60px; height: 30px; margin-right: 5px;" class="style7">
                                        取消
                                    </button>
                                </a>
                                <#if orderDTO.getPayStatusEnum().getMessage() == "未支付">
                                    <a href="/customer/order/pay?orderId=${orderDTO.getOrderId()}">
                                        <button style="width: 60px; height: 30px;" class="style7">去支付</button>
                                    </a>
                                </#if>
                            <#else>
                                <#if orderDTO.getDiscussStatus() == 0>
                                    <a href="/customer/order/discuss?orderId=${orderDTO.getOrderId()}">
                                        <button style="width: 60px; height: 30px;" class="style7">去评价</button>
                                    </a>
                                <#else>
                                    <button style="width: 60px; height: 30px; margin-right: 5px;" class="style8">已评价
                                    </button>
                                </#if>

                            </#if>

                        </div>
                    </div>
                </#if>
                <div style="width: 100%; height: 10px;"></div>
            </#list>

            <div style="text-align: center">
                <div class="container">
                    <div class="row clearfix">
                        <div class="col-md-12 column">

                            <#if currentPage == totalPages>
                                <p style="color: gray">已经加载全部订单</p>
                            <#else>
                                <div style="width: 100%; height: 30px;"></div>
                            </#if>

                            <ul class="pagination" style="width: 100%; margin-top: 0px">
                                <#if currentPage lte 1>
                                    <li class="disabled">
                                        <a href="" style="width: 30%">Prev</a>
                                    </li>
                                <#else>
                                    <li disabled="disabled">
                                        <a href="list?page=${currentPage-1}" style="width: 30%">Prev</a>
                                    </li>
                                </#if>

                                <li class="disabled">
                                    <a href="" style="width: 40%">${currentPage}</a>
                                </li>

                                <#if currentPage lt totalPages>
                                    <li>
                                        <a href="list?page=${currentPage+1}" style="width: 30%">Next</a>
                                    </li>
                                <#else>
                                    <li class="disabled">
                                        <a href="" style="width: 30%">Next</a>
                                    </li>
                                </#if>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>

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
                location.replace('/customer/index');
            };
        </script>

    </body>
</html>
