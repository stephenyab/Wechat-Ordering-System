<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
        <title>评价</title>
        <link rel="stylesheet" type="text/css" href="/css/customer/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="/css/customer/base.css">
        <link rel="stylesheet" href="/css/customer/evaluate.css">
        <link rel="stylesheet" href="/css/customer/order_notes.css">
        <style>
            .input_style {
                height: 60px;
                width: 40%;
                text-align: center;
                background-color: #f63;
                color: #fff;
                font-size: 16px;
                line-height: 60px;
            }
        </style>

    </head>
    <body>

        <div>
            <div class="invoice">
                <div>${orderDTO.getUpdateTime()}</div>
                <div class="food_price">¥ ${orderDTO.getOrderAmount()}</div>
            </div>

            <ul class="food_list">
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
        </div>

        <form method="post" action="/customer/order/discuss">
            <input hidden="hidden" name="orderId" value="${orderDTO.getOrderId()}">
            <input hidden="hidden" name="openId" value="${openid}">
            <input hidden="hidden" name="userName" value="${userName}">

            <div class="fixed-cont">
                <section class="assess">
                    <textarea rows="7" placeholder="请在这里写下你的评价" name="discuss"></textarea>

                    <ul>
                        <li>评价</li>
                        <li class="assess-right">
                            <div>
                                <input type="radio" name="status" value="0" checked="checked"/>
                                <img src="/images/customer/hua.png"/>
                            </div>
                            <div>
                                <input type="radio" name="status" value="1"/>
                                <img src="/images/customer/huah.png"/>
                            </div>
                            <div>
                                <input type="radio" name="status" value="2"/>
                                <img src="/images/customer/huae.png">
                            </div>
                        </li>
                    </ul>

                </section>
            </div>

            <footer class="fixed-footer">
                <div class="nmpj">
                    <input type="checkbox" id="ass" name="anonymous"/>
                    <label for="ass" onselectstart="return false">匿名评价</label>
                </div>

                <button type="submit" class="input_style">发表评价</button>

            </footer>
        </form>

        <script src="../../../static/js/jquery.min.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>
