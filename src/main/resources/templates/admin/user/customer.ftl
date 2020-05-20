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
                    </li>

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
                            <a href="/admin/user/customer/list" class="nav-link active">
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
                    餐厅 顾客列表
                </div>
                <ol class="am-breadcrumb">
                    <li><a href="/admin/index" class="am-icon-home">首页</a></li>
                    <li class="am-active">顾客列表</li>
                </ol>
                <div class="tpl-portlet-components">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            <span class="am-icon-code"></span> 顾客列表
                        </div>
                    </div>

                    <div class="tpl-block">
                        <div class="am-g">

                        </div>
                        <div class="am-g">
                            <div class="am-u-sm-12">
                                <form class="am-form">
                                    <table class="am-table am-table-striped am-table-hover table-main">
                                        <thead>
                                            <tr>
                                                <th class="table-author am-hide-sm-only">openid</th>
                                                <th class="table-author am-hide-sm-only">用户名</th>
                                                <th class="table-author am-hide-sm-only">用户头像</th>
                                                <th class="table-author am-hide-sm-only">联系电话</th>
                                                <th class="table-author am-hide-sm-only">性别</th>
                                                <th class="table-author am-hide-sm-only">国家</th>
                                                <th class="table-author am-hide-sm-only">省份</th>
                                                <th class="table-author am-hide-sm-only">城市</th>
                                                <th class="table-date am-hide-sm-only">注册时间</th>
                                                <th class="table-set">操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <#list customerPage.content as userInfo>
                                                <tr>
                                                    <td style="width: 300px">${userInfo.getUserOpenid()}</td>
                                                    <td>${userInfo.getUserName()}</td>
                                                    <td width="150px">
                                                        <img height="80" width="80"
                                                             src="${(userInfo.getUserHeadimgurl())!""}"
                                                             alt="用户头像">
                                                    </td>
                                                    <td style="width: 150px">${userInfo.getUserPhone()!""}</td>
                                                    <td>${(userInfo.getUserSexEnum().getMessage())!""}</td>
                                                    <td>${(userInfo.getUserCountry())!"未知"}</td>
                                                    <td>${(userInfo.getUserProvince())!"未知"}</td>
                                                    <td>${(userInfo.getUserCity())!"未知"}</td>
                                                    <td width="190px">${userInfo.getRegisterTime()}</td>
                                                    <td style="width: 80px;">
                                                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary">
                                                            <a href="/admin/user/customer/detail?openid=${userInfo.getUserOpenid()}">详情</a>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </#list>

                                        </tbody>
                                    </table>
                                    <div class="am-cf">
                                        <#-- 分页 -->
                                        <div class="am-fr">
                                            <ul class="am-pagination tpl-pagination">
                                                <#if customerPage.getTotalElements() lte 0>
                                                    <li class="am-disabled"><a href="#">«</a></li>
                                                    <li class="am-disabled"><a href="#">»</a></li>
                                                <#else>
                                                    <#if currentPage lte 1>
                                                        <li class="am-disabled"><a
                                                                    href="#">«</a>
                                                        </li>
                                                    <#else>
                                                        <li><a href="list?page=${currentPage-1}&size=${size}">«</a>
                                                        </li>
                                                    </#if>

                                                <#-- 如果页数超过3页 -->
                                                    <#if customerPage.getTotalPages() gt 3>
                                                        <#if (currentPage - 1 gt 1 && currentPage + 1 lt customerPage.getTotalPages())>
                                                            <li><a href="#">...</a></li>
                                                            <li>
                                                                <a href="list?page=${currentPage-1}&size=${size}">${currentPage-1}</a>
                                                            </li>
                                                            <li class="am-active"><a
                                                                        href="list?page=${currentPage}&size=${size}">${currentPage}</a>
                                                            </li>
                                                            <li>
                                                                <a href="list?page=${currentPage+1}&size=${size}">${currentPage+1}</a>
                                                            </li>
                                                            <li><a href="#">...</a></li>
                                                        <#elseif currentPage - 1 lte 1>
                                                            <#list 1..3 as num>
                                                                <#if currentPage == num>
                                                                    <li class="am-active"><a href="#">${num}</a></li>
                                                                <#else>
                                                                    <li>
                                                                        <a href="list?page=${num}&size=${size}">${num}</a>
                                                                    </li>
                                                                </#if>
                                                            </#list>
                                                            <li><a href="#">...</a></li>
                                                        <#elseif currentPage + 1 gte customerPage.getTotalPages()>
                                                            <li><a href="#">...</a></li>
                                                            <#list customerPage.getTotalPages()-2..customerPage.getTotalPages() as num>
                                                                <#if currentPage == num>
                                                                    <li class="am-active"><a href="#">${num}</a></li>
                                                                <#else>
                                                                    <li>
                                                                        <a href="list?page=${num}&size=${size}">${num}</a>
                                                                    </li>
                                                                </#if>
                                                            </#list>
                                                        </#if>

                                                    <#-- 如果页数没有超过3页 -->
                                                    <#else>
                                                        <#list 1..customerPage.getTotalPages() as index>
                                                            <#if currentPage == index>
                                                                <li class="am-active"><a href="#">${index}</a></li>
                                                            <#else>
                                                                <li>
                                                                    <a href="list?page=${index}&size=${size}">${index}</a>
                                                                </li>
                                                            </#if>
                                                        </#list>
                                                    </#if>

                                                    <#if currentPage gte customerPage.getTotalPages()>
                                                        <li class="am-disabled"><a href="#">»</a></li>
                                                    <#else>
                                                        <li><a href="list?page=${currentPage + 1}&size=${size}">»</a>
                                                        </li>
                                                    </#if>
                                                </#if>


                                            </ul>
                                        </div>
                                    </div>
                                    <hr>

                                </form>
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
