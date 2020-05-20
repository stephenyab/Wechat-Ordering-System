<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
        <title>评价列表</title>
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

            .top {
                width: 100%;
                height: 45px;
                position: fixed;
                top: 0;
                background-color: white;
                z-index: 9999;
            }

            .discuss_type {
                width: 60px;
                height: 30px;
                margin-right: 10px;
                border-radius: 2px;
                background-color: #ffeedd;
            }

            .discuss_type a {
                color: gray;
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
                订单评论列表
            </p>
        </div>

        <div class="main" style="margin-top: 45px;">

            <div style="margin-bottom: 10px;">
                <button class="discuss_type" <#if discussType == "all">style="background-color: #f63"</#if>>
                    <a <#if discussType == "all">style="color: white" </#if> href="list?discussType=all">全部</a>
                </button>
                <button class="discuss_type" <#if discussType == "good">style="background-color: #f63"</#if>>
                    <a <#if discussType == "good">style="color: white" </#if>href="list?discussType=good">好评</a>
                </button>
                <button class="discuss_type" <#if discussType == "normal">style="background-color: #f63"</#if>>
                    <a <#if discussType == "normal">style="color: white" </#if>href="list?discussType=normal">中等</a>
                </button>
                <button class="discuss_type" <#if discussType == "bad">style="background-color: #f63"</#if>>
                    <a <#if discussType == "bad">style="color: white" </#if>href="list?discussType=bad">差评</a></button>
            </div>

            <#list orderDiscussPage.content as orderDiscuss>
                <div style="margin-bottom: 10px; padding: 10px; background-color: white;">
                    <div style="width: 10%; float: left">
                        <img src="${orderDiscuss.getUserImgUrl()}"
                             style="width: 35px;height: 35px;margin-top: 3px">
                    </div>
                    <div style="width: 100%;margin-left: 43px; padding-right: 38px">
                        <div>
                            <span>${orderDiscuss.getUserName()}</span>
                            <span style="float:right; color: gray;font-size: 12px">${orderDiscuss.getCreateTime()}</span>
                        </div>
                        <span style="font-size: 13px;color: #E75B18">${orderDiscuss.getDiscussStatusEnum().getMessage()}</span>
                        <br>
                        <div style="height: 5px"></div>
                        <span>${(orderDiscuss.getDiscussWord())!"暂无评价内容"}</span>
                    </div>
                </div>
            </#list>

            <div style="text-align: center">
                <div class="container">
                    <div class="row clearfix">
                        <div class="col-md-12 column">

                            <#if currentPage == orderDiscussPage.getTotalPages()>
                                <p style="color: gray">已经加载全部评论</p>
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

                                <#if currentPage lt orderDiscussPage.getTotalPages()>
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
                location.replace('/customer/index');//自己的地址
            };
        </script>

    </body>
</html>
