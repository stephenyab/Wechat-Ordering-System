<!doctype html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>餐厅后台管理</title>
        <meta name="description" content="这是一个 index 页面">
        <meta name="keywords" content="index">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="renderer" content="webkit">
        <meta http-equiv="Cache-Control" content="no-siteapp"/>
        <link rel="icon" type="image/png" href="/images/admin/favicon.png">
        <link rel="apple-touch-icon-precomposed" href="/images/admin/app-icon72x72@2x.png">
        <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
        <link rel="stylesheet" href="/css/admin/amazeui.min.css"/>
        <link rel="stylesheet" href="/css/admin/admin.css">
        <link rel="stylesheet" href="/css/admin/app.css">
    </head>

    <body data-type="generalComponents">


        <header class="am-topbar am-topbar-inverse admin-header">
            <div class="am-topbar-brand">
                <a href="javascript:;" class="tpl-logo">
                    <img src="/images/admin/logo.png" alt="">
                </a>
            </div>
            <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

            </div>

            <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
                    data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
                        class="am-icon-bars"></span></button>

            <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

                <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">

                    <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>

                    </li>
                    <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>

                    </li>
                    <li class="am-hide-sm-only"></li>

                    <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                        <span class="tpl-header-list-user-nick">餐厅管理员</span>
                        <span class="tpl-header-list-user-ico">
                            <img src="/images/admin/user01.png">
                        </span>
                </ul>
            </div>
        </header>


        <div class="tpl-page-container tpl-page-header-fixed">

            <div class="tpl-left-nav tpl-left-nav-hover">
                <div class="tpl-left-nav-title">
                    操作列表
                </div>
                <div class="tpl-left-nav-list">
                    <ul class="tpl-left-nav-menu">
                        <li class="tpl-left-nav-item">
                            <a href="/admin/index" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>首页</span>
                            </a>
                        </li>

                        <li class="tpl-left-nav-item">
                            <a href="/admin/order/list" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>订单列表</span>
                            </a>
                        </li>

                        <li class="tpl-left-nav-item">
                            <a href="/admin/product/list" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>商品列表</span>
                            </a>
                        </li>

                        <li class="tpl-left-nav-item">
                            <a href="/admin/product/detail" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>商品详情</span>
                            </a>
                        </li>

                        <li class="tpl-left-nav-item">
                            <a href="/admin/category/list" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>分类列表</span>
                            </a>
                        </li>

                        <li class="tpl-left-nav-item">
                            <a href="/admin/category/detail" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>分类详情</span>
                            </a>
                        </li>

                        <li class="tpl-left-nav-item">
                            <a href="/admin/user/customer/list" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>顾客列表</span>
                            </a>
                        </li>

                        <li class="tpl-left-nav-item">
                            <a href="/admin/user/staff/list" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>员工列表</span>
                            </a>
                        </li>

                        <li class="tpl-left-nav-item">
                            <a href="/admin/discuss/list" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>评论列表</span>
                            </a>
                        </li>

                        <li class="tpl-left-nav-item">
                            <a href="/admin/restInfo/index" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>餐厅信息</span>
                            </a>
                        </li>

                        <li class="tpl-left-nav-item">
                            <a href="/admin/bind/list" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>绑定账户</span>
                            </a>
                        </li>

                        <li class="tpl-left-nav-item">
                            <a href="/admin/authorize/logout" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>登出</span>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>


            <div class="tpl-content-wrapper">
                <div class="tpl-content-page-title">
                    餐厅 订单详情
                </div>
                <ol class="am-breadcrumb">
                    <li><a href="/admin/index" class="am-icon-home">首页</a></li>
                    <li class="am-active">订单详情</li>
                </ol>
                <div class="tpl-portlet-components">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            <span class="am-icon-code"></span> 订单详情
                        </div>
                    </div>

                    <div class="tpl-block">

                        <div class="am-g tpl-amazeui-form">

                            <div class="am-u-sm-12 am-u-md-9">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label for="order-master-id" class="am-u-sm-3 am-form-label">订单id</label>
                                        <div class="am-u-sm-9">
                                            <input disabled="disabled" type="text" id="order-master-id"
                                                   value="${(orderDTO.getOrderId())!""}">
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="order-master-amount" class="am-u-sm-3 am-form-label">订单总金额 /
                                            Amount</label>
                                        <div class="am-u-sm-9">
                                            <input disabled="disabled" type="text" id="order-master-amount"
                                                   value="${(orderDTO.getOrderAmount())!""}">
                                        </div>
                                    </div>

                                    <#if orderDTO.getOrderStatusEnum().getMessage() == "完结">
                                        <div class="am-form-group">
                                            <label for="user-intro" class="am-u-sm-3 am-form-label">评价 / Discuss</label>
                                            <div class="am-u-sm-9">
                                                <textarea disabled="disabled" class="" rows="5" id="user-intro"
                                                          placeholder="暂无评价内容">${(orderDiscuss.getDiscussWord())!""}</textarea>
                                            </div>
                                        </div>
                                    </#if>

                                </form>
                            </div>
                        </div>

                        <div class="am-g">
                            <div class="am-u-sm-12">
                                <form class="am-form">
                                    <hr>

                                    <table class="am-table am-table-striped am-table-hover table-main">
                                        <thead>
                                            <tr>
                                                <th class="table-title">商品id</th>
                                                <th class="table-author am-hide-sm-only">商品名称</th>
                                                <th class="table-author am-hide-sm-only">商品单价</th>
                                                <th class="table-date am-hide-sm-only">数量</th>
                                                <th class="table-date am-hide-sm-only">总额</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <#list orderDTO.getOrderDetailList() as orderDetail>
                                                <tr>
                                                    <td>${orderDetail.getDetailId()}</td>
                                                    <td>${orderDetail.getProductName()}</td>
                                                    <td>${orderDetail.getProductPrice()}</td>
                                                    <td>${orderDetail.getProductQuantity()}</td>
                                                    <td style="width: 150px;">${(orderDetail.getProductQuantity() * orderDetail.getProductPrice())}</td>
                                                </tr>
                                            </#list>
                                        </tbody>
                                    </table>

                                    <div class="am-cf">

                                    </div>
                                    <hr>

                                    <#if orderDTO.getOrderStatusEnum().message == "新订单">
                                        <button class="am-btn am-btn-primary">
                                            <a style="color: white"
                                               href="/admin/order/finish?orderId=${orderDTO.getOrderId()}">完结订单</a>
                                        </button>
                                        <button class="am-btn am-btn-danger">
                                            <a style="color: white"
                                               href="/admin/order/cancel?orderId=${orderDTO.getOrderId()}">取消订单</a>
                                        </button>
                                    </#if>
                                </form>
                            </div>

                        </div>
                    </div>

                </div>
                <div class="tpl-alert"></div>
            </div>

        </div>

        </div>

        <script src="/js/jquery.min.js"></script>
        <script src="/js/admin/amazeui.min.js"></script>
        <script src="/js/admin/app.js"></script>
    </body>

</html>
