<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <!-- Title here -->
        <title>厨师</title>
        <!-- Description, Keywords and Author -->
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=no"/>
        <link rel="stylesheet" type="text/css" href="/css/chief/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="/css/chief/base.css">
        <link rel="stylesheet" href="/css/chief/order_notes.css">
        <style>
            .top {
                width: 100%;
                height: 50px;
                background-color: white;
                position: fixed;
                top: 0;
                z-index: 9999;
            }

            .top_header {
                width: 50%;
                height: 50px;
                float: left;
            }

            .top_header p {
                font-size: 16px;
                width: 100%;
                height: 50px;
                display: block;
                line-height: 50px;
                text-align: center;
            }

            .header_active {
                border-bottom: 2px #f63 solid;
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

        </style>
    </head>

    <body>

        <div class="top">

            <div class="top_header">
                <a href="/chief/index" style="color:black;">
                    <p>订单列表</p>
                </a>
            </div>

            <div class="top_header header_active">
                <a href="/chief/cook/list" style="color:#f63;">
                    <p>正在烹饪</p>
                </a>
            </div>

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

                <div class="style5">
                    <div class="style6">
                        <a href="/chief/cook/finishCook?orderId=${orderDTO.getOrderId()}">
                            <button style="width: 60px; height: 30px; margin-right: 5px;" class="style7">
                                完成
                            </button>
                        </a>
                    </div>
                </div>

                <div style="width: 100%; height: 10px;"></div>
            </#list>

        </div>

    </body>

</html>
