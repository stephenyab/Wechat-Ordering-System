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
        <script src="/js/echarts.min.js"></script>
        <style>
            .dashboard-stat {
                display: block;
                margin-bottom: 25px;
                overflow: hidden;
                border-radius: 4px;
                padding-bottom: 20px;
            }
        </style>
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
                            <a href="/admin/index" class="nav-link active">
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
                    餐厅 首页
                </div>
                <ol class="am-breadcrumb">
                    <li><a href="/admin/index" class="am-icon-home">首页</a></li>
                </ol>

                <div class="tpl-content-scope">
                    <div class="note note-info">
                        <h3>餐厅首页信息展示
                            <span class="close" data-close="note"></span>
                        </h3>
                        <p> 本页对餐厅的各项数据进行展示，包括每日/每月所有订单、每日/每月所有完结订单，今日/本月销售额，本月新增用户。</p>
                        <p><span class="label label-danger">提示:</span> 通过图标对最近一周内的总订单数、总完结订单数和新增用户数进行可视化，并列出了最新的8条订单数据。
                        </p>
                    </div>
                </div>

                <div class="row">
                    <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                        <div class="dashboard-stat blue">
                            <div class="visual">
                                <i class="am-icon-comments-o"></i>
                            </div>
                            <div class="details">
                                <div class="number">  ${allFinishOrderThisDay} / ${allOrderThisDay}</div>
                                <div class="desc"> 今日完结订单 / 今日所有订单</div>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                        <div class="dashboard-stat red">
                            <div class="visual">
                                <i class="am-icon-bar-chart-o"></i>
                            </div>
                            <div class="details">
                                <div class="number"> ${allFinishOrderThisMonth} / ${allOrderThisMonth}</div>
                                <div class="desc"> 本月完结订单 / 本月所有订单</div>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                        <div class="dashboard-stat green">
                            <div class="visual">
                                <i class="am-icon-apple"></i>
                            </div>
                            <div class="details">
                                <div class="number"> ${totalOrderAmountThisDay} / ${totalOrderAmountThisMonth}</div>
                                <div class="desc"> 今日销售额 / 本月销售额</div>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                        <div class="dashboard-stat purple">
                            <div class="visual">
                                <i class="am-icon-android"></i>
                            </div>
                            <div class="details">
                                <div class="number"> ${allUserThisMonth}</div>
                                <div class="desc"> 本月新增用户</div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="am-u-md-6 am-u-sm-12 row-mb">
                        <div class="tpl-portlet">
                            <div class="tpl-portlet-title">
                                <div class="tpl-caption font-green ">
                                    <i class="am-icon-cloud-download"></i>
                                    <span> 餐厅最近一周 数据统计</span>
                                </div>
                                <div class="actions">
                                </div>
                            </div>

                            <!--此部分数据请在 js文件夹下中的 app.js 中的 “百度图表A” 处修改数据 插件使用的是 百度echarts-->
                            <div class="tpl-echarts" id="tpl-echarts-A">

                            </div>
                        </div>
                    </div>

                    <div class="am-u-md-6 am-u-sm-12 row-mb">
                        <div class="tpl-portlet">
                            <div class="tpl-portlet-title">
                                <div class="tpl-caption font-red ">
                                    <i class="am-icon-bar-chart"></i>
                                    <span> 餐厅最新订单 数据统计</span>
                                </div>
                                <div class="actions">
                                </div>
                            </div>
                            <div class="tpl-scrollable">
                                <div class="number-stats">

                                </div>

                                <table class="am-table tpl-table">
                                    <thead>
                                        <tr class="tpl-table-uppercase">
                                            <th>订单id</th>
                                            <th>创建时间</th>
                                            <th>总金额</th>
                                            <th>订单状态</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <#list latestEightOrder as orderDTO>
                                            <tr>
                                                <td>
                                                    <a class="user-name"
                                                       href="/admin/order/detail?orderId=${orderDTO.getOrderId()}">
                                                        ${orderDTO.getOrderId()}
                                                    </a>
                                                </td>
                                                <td>${orderDTO.getCreateTime()}</td>
                                                <td>￥${orderDTO.getOrderAmount()}</td>
                                                <td class="font-green bold">${orderDTO.getOrderStatusEnum().getMessage()}</td>
                                            </tr>
                                        </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        </div>


        <script src="/js/jquery.min.js"></script>
        <script src="/js/admin/amazeui.min.js"></script>
        <script src="/js/admin/app.js"></script>

        <script>
            var echartsA = echarts.init(document.getElementById('tpl-echarts-A'));
            option = {

                tooltip: {
                    trigger: 'axis',
                },
                legend: {
                    data: ['总订单数', '总完结订单数', '新增用户数']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [{
                    type: 'category',
                    boundaryGap: true,
                    data:
                        [<#list dateStringThisWeek as day>
                            '${day}',
                            </#list>]
                }],

                yAxis: [{
                    type: 'value'
                }],
                series: [{
                    name: '总订单数',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data: [
                        <#list orderNumThisWeek as orderNum>
                        ${orderNum},
                        </#list>
                    ],
                    itemStyle: {
                        normal: {
                            color: '#59aea2'
                        },
                        emphasis: {}
                    }
                },
                    {
                        name: '总完结订单数',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data: [
                            <#list orderFinishThisWeek as orderFinishNum>
                            ${orderFinishNum},
                            </#list>
                        ],
                        itemStyle: {
                            normal: {
                                color: '#e7505a'
                            }
                        }
                    },
                    {
                        name: '新增用户数',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {}},
                        data: [
                            <#list userNumThisWeek as userNum>
                            ${userNum},
                            </#list>
                        ],
                        itemStyle: {
                            normal: {
                                color: '#32c5d2'
                            }
                        }
                    }
                ]
            };
            echartsA.setOption(option);
        </script>
    </body>

</html>
