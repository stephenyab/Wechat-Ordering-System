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
                    <li class="tpl-left-nav-item">
                        <a href="/admin/index" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-angle-right"></i>
                            <span>首页</span>
                        </a>
                    </li>

                    <ul class="tpl-left-nav-menu">
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
                            <a href="/admin/user/staff/list" class="nav-link active">
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
                            <a href="/admin/logout" class="nav-link tpl-left-nav-link-list">
                                <i class="am-icon-angle-right"></i>
                                <span>登出</span>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>


            <div class="tpl-content-wrapper">
                <div class="tpl-content-page-title">
                    餐厅 员工列表
                </div>
                <ol class="am-breadcrumb">
                    <li><a href="/admin/index" class="am-icon-home">首页</a></li>
                    <li class="am-active">员工列表</li>
                </ol>
                <div class="tpl-portlet-components">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            <span class="am-icon-code"></span> 员工列表
                        </div>
                    </div>

                    <div class="tpl-block">

                        <div class="am-g">
                            <div class="am-u-sm-12 am-u-md-3">
                                <div style="margin-left: 8px" class="am-input-group am-input-group-sm">
                                    <input id="userPhone" placeholder="输入需要添加员工的联系电话" type="text"
                                           class="am-form-field">
                                    <span class="am-input-group-btn">
                                        <button style="margin-left: 5px"
                                                onclick="findUserByPhone()"
                                                class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
                                                type="button">
                                        </button>
                                    </span>

                                </div>
                            </div>
                        </div>

                        <div class="am-g" style="margin-top: 20px;">
                            <div class="am-u-sm-12">
                                <form class="am-form">
                                    <table class="am-table am-table-striped am-table-hover table-main">
                                        <thead>
                                            <tr>
                                                <th class="table-author am-hide-sm-only">openid</th>
                                                <th class="table-author am-hide-sm-only">员工名</th>
                                                <th class="table-author am-hide-sm-only">性别</th>
                                                <th class="table-author am-hide-sm-only">员工职位</th>
                                                <th class="table-author am-hide-sm-only">联系电话</th>
                                                <th class="table-date am-hide-sm-only">入职时间</th>
                                                <th class="table-set">操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <#list waiterList as userInfo>
                                                <tr>
                                                    <td style="width: 300px">${userInfo.getUserOpenid()}</td>
                                                    <td>${userInfo.getUserName()}</td>
                                                    <td>${userInfo.getUserSexEnum().getMessage()}</td>
                                                    <td>${userInfo.getUserIdentityEnum().getMessage()}</td>
                                                    <td>${userInfo.getUserPhone()!""}</td>
                                                    <td>${userInfo.getRegisterTime()}</td>
                                                    <td style="width: 170px">
                                                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary">
                                                            <a href="/admin/user/staff/fire?openid=${userInfo.getUserOpenid()}">解雇</a>
                                                        </button>
                                                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary">
                                                            <a href="/admin/user/staff/change?openid=${userInfo.getUserOpenid()}">设为厨师</a>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </#list>

                                            <#list chiefList as userInfo>
                                                <tr>
                                                    <td style="width: 300px">${userInfo.getUserOpenid()}</td>
                                                    <td>${userInfo.getUserName()}</td>
                                                    <td style="width: 180px">${userInfo.getUserSexEnum().getMessage()}</td>
                                                    <td style="width: 180px">${userInfo.getUserIdentityEnum().getMessage()}</td>
                                                    <td style="width: 250px">${userInfo.getUserPhone()}</td>
                                                    <td style="width: 250px">${userInfo.getRegisterTime()}</td>
                                                    <td style="width: 170px">
                                                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary">
                                                            <a href="/admin/user/staff/fire?openid=${userInfo.getUserOpenid()}">解雇</a>
                                                        </button>
                                                        <button class="am-btn am-btn-default am-btn-xs am-text-secondary">
                                                            <a href="/admin/user/staff/change?openid=${userInfo.getUserOpenid()}">设为服务员</a>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </#list>

                                        </tbody>
                                    </table>
                                    <div class="am-cf">

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

        <script>
            function findUserByPhone() {
                var phone = document.getElementById("userPhone").value;
                if (!(/^1[3456789]\d{9}$/.test(phone))) {
                    alert("手机号码有误，请重填");
                    return false;
                } else {
                    window.location.href = 'find?phone=' + phone;
                }
            }
        </script>

        <script src="/js/jquery.min.js"></script>
        <script src="/js/admin/amazeui.min.js"></script>
        <script src="/js/admin/app.js"></script>
    </body>

</html>
