<!DOCTYPE html>

<html class="js cssanimations">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>菜品列表</title>
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="renderer" content="webkit">
        <meta http-equiv="Cache-Control" content="no-siteapp">
        <link href="/css/customer/style2.css" rel="stylesheet">
        <link rel="stylesheet" href="/css/admin/app.css">
        <link rel="stylesheet" href="/css/admin/amazeui.min.css"/>
        <style type="text/css">
            .tpl-content-scope {
                margin: 15px 10px 10px 10px;
            }

            .header {
                position: relative;
                height: auto;
                overflow: hidden;
                color: #fff;
                background: #e9ecf3;
                background-size: 100% 100%;
            }

            body {
                position: relative;
                background: #e9ecf3;
                font-family: "Segoe UI", "Lucida Grande", Helvetica, Arial, "Microsoft YaHei", FreeSans, Arimo, "Droid Sans", "wenquanyi micro hei", "Hiragino Sans GB", "Hiragino Sans GB W3", FontAwesome, sans-serif;
                font-weight: 400;
                line-height: 1.6;
                color: #333;
                font-size: 1.6rem;
                padding: 10px;
            }

            ul {
                padding: 0px;
            }

            .title {
                width: 180px;
                height: 20px;
                display: -webkit-box;
                -webkit-box-orient: vertical;
                -webkit-line-clamp: 1;
                overflow: hidden;
                text-overflow: ellipsis;
            }

            .description {
                width: 180px;
                height: 24px;
                font-size: 12px;
                color: #A9A9A9;
                margin-top: 2px;
                display: -webkit-box;
                -webkit-box-orient: vertical;
                -webkit-line-clamp: 2;
                overflow: hidden;
                text-overflow: ellipsis;
            }
        </style>
    </head>

    <body>

        <div class="header">
            <div class="tpl-content-scope">
                <div class="note note-info">
                    <h3>菜品列表
                        <span class="close" data-close="note"></span>
                    </h3>
                    <p>本页按照分类信息显示餐厅的所有菜品信息。</p>
                    <p><span class="label label-danger">提示:</span>
                        点击右下角的悬浮按钮可以进入添加新菜品的页面
                    </p>
                </div>
            </div>
        </div>

        <div class="tpl-portlet-components" style="margin: 0 10px">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 菜品列表
                </div>
            </div>

            <div class="tpl-block ">
                <ul>
                    <#list categoryVOList as categoryVO>
                        <li>
                            <div style="margin-top: 10px;">
                                <blockquote>
                                    <p>
                                        ${categoryVO.getCategoryName()}
                                    </p>
                                </blockquote>
                            </div>
                            <#list categoryVO.getProductVOList() as productVO>
                                <div>
                                    <div class="item">
                                        <div class="item-left">
                                            <div class="item-img"><img
                                                        src="${productVO.getProductIcon()}">
                                            </div>
                                        </div>
                                        <div class="item-right" style="width: 50px">
                                            <div class="title">${productVO.getProductName()}</div>
                                            <div class="description">
                                                ${productVO.getProductDescription()}
                                            </div>
                                            <div class="price">
                                                ¥
                                                <span style="font-size: 18px">${productVO.getProductPrice()}</span>
                                                元
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </#list>
                        </li>
                    </#list>

                </ul>
            </div>

        </div>

        <img src="/images/admin/add.png"
             id="addproductbutton"
             style="width: 5rem;height: 5rem;position: fixed;bottom: 2rem;right: 0.5rem;z-index: 9999;"/>

        <script src="/js/jquery.js"></script>
        <script>
            $("#addproductbutton").click(function () {
                window.location.href = "/adminMobile/add";
            })
        </script>

    </body>

</html>
