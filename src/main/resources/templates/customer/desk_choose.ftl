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

            .top {
                width: 100%;
                height: 50px;
                background-color: white;
                position: fixed;
                top: 0;
                z-index: 9999;
            }

            .desk_num {
                width: 90%;
                height: 50px;
            }
        </style>
    </head>

    <body class="PB50">

        <div class="top">
            <a href="/customer/index">
                <img src="/images/customer/back.png"
                     style="margin-top: 13px; margin-left: 15px; float:left; max-width: 20px"
                     height="20px" width="20px">
            </a>
            <p style="margin-left: 26px; margin-top: 14px; float:left; font-size: 15px">
                请选择你的座位号
            </p>
        </div>

        <#--        <div style="height: 100px; text-align: center">-->
        <#--            <p style="line-height: 100px; height: 100px; font-size: 20px">请选择你的座位号</p>-->
        <#--        </div>-->

        <div style="margin-top: 60px">
            <#list deskNumList as deskNum>
                <div style="width: 50%; height: 50px;float: left; min-height: 50px; margin: 10px 0;">
                    <div style="width: 100%;text-align: center;">
                        <button class="desk_num" onclick="selectDeskNum(this,${deskNum})">
                            ${deskNum}
                        </button>
                    </div>
                </div>
            </#list>
        </div>

        <img src="/images/customer/finish.png"
             id="deskSelected"
             style="width: 5rem;height: 5rem;position: fixed;bottom: 2rem;right: 0.5rem;z-index: 9999;"/>

        <script>
            window.onload = function () {
                cookieUtil.setCookie("deskNum", 0);
            }

            $("#deskSelected").click(function () {
                var deskNum = cookieUtil.getCookie("deskNum");
                if (deskNum == 0) {
                    alert("请先选择座位号！")
                } else {
                    window.location.href = "/customer/product/list";
                }
            })

            function selectDeskNum(deskButton, deskNum) {
                alert("你选择了" + deskNum + "号座位");
                var date = new Date();
                date.setDate(date.getDate() + 5); //保存5天
                cookieUtil.setCookie("deskNum", deskNum);
            }

            //Cookie工具
            var cookieUtil = {
                //添加cookie
                setCookie: function (name, value, expires) {
                    var cookieText = encodeURIComponent(name) + "=" +
                        encodeURIComponent(value);
                    if (expires && expires instanceof Date) {
                        cookieText += "; expires=" + expires;
                    }
                    cookieText += "; path=" + escape("/");
                    // if (domain) {
                    //   cookieText += "; domain=" + domain;
                    // }
                    document.cookie = cookieText;
                },
                //获取cookie
                getCookie: function (name) {
                    var cookieText = decodeURIComponent(document.cookie);
                    var cookieArr = cookieText.split("; ");
                    for (var i = 0; i < cookieArr.length; i++) {
                        var arr = cookieArr[i].split("=");
                        if (arr[0] == name) {
                            return arr[1];
                        }
                    }
                    return null;
                },
                //删除cookie
                unsetCookie: function (name) {
                    document.cookie = encodeURIComponent(name) + "=; expires=" +
                        new Date(0);
                }
            };
        </script>


        <script>
            pushHistory();

            function pushHistory() {
                var state = {
                    title: "title",
                    url: "#"
                };
                window.history.pushState(state, "title", "#");
            };
        </script>

    </body>

</html>
