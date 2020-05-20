<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <!-- Title here -->
        <title>餐厅首页</title>
        <!-- Description, Keywords and Author -->
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0, user-scalable=no"/>
        <!-- Custom CSS -->
        <link rel="stylesheet" type="text/css" href="/css/customer/swiper.min.css"/>
        <link rel="stylesheet" type="text/css" href="/css/customer/style.css"/>
        <link href="/css/customer/style2.css" rel="stylesheet">
        <!-- jQuery -->
        <script src="/js/jquery.js" type="text/javascript"></script>
        <script src="/js/customer/swiper.min.js" type="text/javascript"></script>
        <!-- Custom JS -->
        <script type="text/javascript" src="/js/customer/custom.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                //首页banner
                var mySwiper = new Swiper('.slide', {
                    autoplay: 5000,
                    visibilityFullFit: true,
                    loop: true,
                    pagination: '.pagination',
                });
            });
        </script>
        <style>
            html,
            body {
                height: 100%;
            }

            .style1 {
                width: 100%;
                height: 15%;
                overflow: hidden;
                position: relative;
                text-align: center;
                vertical-align: middle;
            }

            .style2 {
                font-size: 16px;
                color: black;
            }

            .style3 {
                font-size: 13px;
                color: #959698;
                margin-top: 10px;
            }

            img {
                max-height: 180px;
                max-width: 180px;
            }

            .back_img {
                background: url(/images/customer/logo.jpg) no-repeat;
            }
        </style>
    </head>

    <body class="PB50">

        <div class="header">
            <div class="leftlogo back_img"></div>
            <div class="righttitle">
                <h1 style="color: white">${restInfoDTO.getRestName()}</h1>
                <h2 style="color: white">${restInfoDTO.getRestAddress()}</h2>
                <h2 style="margin-top: 0px; color: white">${(restInfoDTO.getRestDescription())!""}</h2>
            </div>
            <div class="bulletin" style="color: white">
                <span class="bulletin-title"></span>
                ${(restInfoDTO.getRestAnnouncement())!""}
            </div>
        </div>

        <div class="style1">
            <div style="height: 30%; width: 100%;"></div>
            <p style="font-size: 24px; color: black;">餐厅服务</p>
        </div>

        <div style="height: 55%; width: 100%;">
            <a href="/customer/product/list">
                <div style="width: 50%; height: 40%;float: left; min-height: 180px">
                    <div style="width: 100%;text-align: center;">
                        <img style="width: 50%; height: 50%; margin-top: 20px"
                             src="/images/customer/order.jpg">
                        <p class="style2">开始点餐</p>
                        <p class="style3">众多美食任你选择</p>
                    </div>
                </div>
            </a>

            <a href="/customer/order/list">
                <div style="width: 50%; height: 40%; float: left; min-height: 180px">
                    <div style="width: 100%;text-align: center;">
                        <img style="width: 50%; height: 50%; margin-top: 20px"
                             src="/images/customer/orderDetail.jpg">
                        <p class="style2">查看订单</p>
                        <p class="style3">记录您的每一次订餐情况</p>
                    </div>
                </div>
            </a>

            <a href="/customer/discuss/list">
                <div style="width: 50%; height: 40%; float: left; min-height: 180px">
                    <div style="width: 100%;text-align: center;">
                        <img style="width: 50%; height: 50%;  margin-top: 20px"
                             src="/images/customer/discuss.jpg">
                        <p class="style2">所有评价</p>
                        <p class="style3">阅读与分享每一位食客的想法</p>
                    </div>
                </div>
            </a>

            <a href="/customer/info/message">
                <div style="width: 50%; height: 40%;float: left; min-height: 180px">
                    <div style="width: 100%;text-align: center;">
                        <img style="width: 50%; height: 50%;  margin-top: 20px"
                             src="/images/customer/user.jpg">
                        <p class="style2">个人信息</p>
                        <p class="style3">独属于您的身份信息</p>
                    </div>
                </div>
            </a>

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

            // 监听微信返回
            // window.addEventListener("popstate", function (e) {
            //
            //     alert('正在返回，等下会关闭微信窗口');
            //
            //     WeixinJSBridge.call('closeWindow');
            //
            // }, false);
        </script>

    </body>

</html>
