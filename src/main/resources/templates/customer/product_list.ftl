<!DOCTYPE html>

<html class="js cssanimations">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>点餐DEMO</title>
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="renderer" content="webkit">
        <meta http-equiv="Cache-Control" content="no-siteapp">
        <link href="/css/customer/style2.css" rel="stylesheet">
        <style type="text/css">
            .shop {
                position: fixed;
                bottom: 0px;
                width: 70%;
                height: 50px;
                background: #070f1a;
                transition: all 0.5s ease 0s;
                transition: all 0.5s ease 0s;
            }

            .shop-bottom {
                position: fixed;
                float: right;
                bottom: 0px;
                width: 100%;
                height: 50px;
                background: #070f1a;
                transition: all 0.5s ease 0s;
                transition: all 0.5s ease 0s;
            }

            .shop .shopico {
                position: relative;
                width: 70px;
                height: 70px;
                border-radius: 50%;
                float: left;
                background: #070f1a;
                margin: -15px 0 0 10px;
            }

            .shop .shopico i {
                width: 50px;
                height: 50px;
                background: url(/images/customer/shop.png) no-repeat;
                background-size: contain;
                display: inline-block;
                margin: 8px 0 0 10px;
                overflow: hidden;
                border-radius: 50px;
            }

            .shop .shopprice {
                float: left;
                line-height: 50px;
                font-size: 18px;
                font-weight: bold;
                color: #FFF;
                margin-left: 10px;
            }

            .shop-shopbut {
                background: #f55331;
                float: right;
                width: 30%;
                text-align: center;
                color: #FFF;
                font-size: 16px;
                font-weight: bold;
                line-height: 50px;
            }

            .shop .numspan {
                position: absolute;
                top: -5px;
                right: 5px;
                width: 20px;
                height: 20px;
                text-align: center;
                font-size: 12px;
                line-height: 20px;
                color: #FFF;
                border-radius: 50%;
                background: -webkit-linear-gradient(left top, #f07c49, #ff0000);
                /* Safari 5.1 - 6.0 */
                background: -o-linear-gradient(bottom right, #f07c49, #ff0000);
                /* Opera 11.1 - 12.0 */
                background: -moz-linear-gradient(bottom right, #f07c49, #ff0000);
                /* Firefox 3.6 - 15 */
                background: linear-gradient(to bottom right, #f07c49, #ff0000);
                /* 标准的语法 */
            }

            .mask {
                width: 100%;
                background: #000;
                opacity: 0.5;
                top: 0;
                height: 100%;
                display: none;
                position: fixed;
            }

            .popup {
                position: fixed;
                width: 100%;
                height: 300px;
                background: #FFF;
                bottom: -300px;
                transition: all 0.5s ease 0s;
                transition: all 0.5s ease 0s;
            }

            .popup .uptitle {
                height: 40px;
                line-height: 40px;
                padding: 0 15px;
                border-bottom: solid 1px #f9f9f9;
            }

            .popup .uptitle span {
                font-size: 16px;
                color: #000;
            }

            .popup .uptitle .tb {
                height: 16px;
                line-height: 20px;
                font-size: 13px;
                float: right;
                margin: 0;
                background: url(/images/customer/del.png) no-repeat left center;
                background-size: contain;
                padding-left: 20px;
                color: #a1a1a1;
                margin: 13px 0 0 0;
            }

            .popup .uplist {
                width: 100%;
                height: 270px;
                overflow-y: scroll;
            }

            .popup .uplist ul li {
                width: 100%;
                height: auto;
                overflow: hidden;
                margin: 10px 0;
            }

            .popup .uplist .uppic {
                width: 80px;
                height: 40px;
                float: left;
                margin: 10px 10px 10px 15px;
            }

            .popup .uplist .listtitle {
                width: 40%;
                float: left;
                margin: 10px 0 0 0;
                line-height: 25px;
            }

            .popup .uplist .listtitle h1 {
                font-size: 16px;
                font-weight: bold;
                color: #000;
            }

            .popup .uplist .listtitle h2 {
                font-size: 14px;
                font-weight: bold;
                color: #f60002;
            }

            .popup .uplist .listright {
                width: 30%;
                height: auto;
                float: right;
                margin: 20px 0 0 0;
            }

            .popup .uplist .listright span {
                display: block;
                width: 30px;
                height: 30px;
                float: left;
            }

            .popup .uplist .listright p {
                width: 30px;
                float: left;
                font-size: 14px;
                text-align: center;
                line-height: 30px;
            }

            .addnum {
                background: url(/images/customer/jiah.png) no-repeat;
                background-size: contain;
            }

            .lessnum {
                background: url(/images/customer/jianh.png) no-repeat;
                background-size: contain;
            }

        </style>
    </head>

    <body>

        <div class="header">
            <div style="width: 100%; height: 45px;">
                <a href="/customer/index">
                    <img src="/images/customer/back_white.png"
                         style="margin-top: 13px; margin-left: 15px; float:left; width: 20px; height: 20px">
                </a>
                <p style="margin-left: 26px; margin-top: 15px; float:left; font-size: 15px;color: white">
                    点餐
                </p>
            </div>

            <div class="leftlogo"></div>
            <div class="righttitle">
                <h1>${restInfoDTO.getRestName()}</h1>
                <h2>${restInfoDTO.getRestAddress()}</h2>
                <h2 style="margin-top: 0px;">${(restInfoDTO.getRestDescription())!""}</h2>
            </div>
            <div class="bulletin">
                <span class="bulletin-title"></span>
                ${(restInfoDTO.getRestAnnouncement())!""}
            </div>
        </div>

        <div class="swiper-container">
            <!--<ul class="swiper-container-ul" style="">
              <li class="swiper-container-ul-li actives">商品</li>
              <li class="swiper-container-ul-li">店铺</li>
            </ul>-->

            <#--            左侧边栏-->
            <div class="swiper-wrapper">
                <div class="swiper-slide">
                    <div class="content" style="height: 760px;">
                        <div id="left" class="left" style="">
                            <ul>
                                <#list categoryVOList as categoryVO>
                                    <li>${categoryVO.getCategoryName()}</li>
                                </#list>
                            </ul>
                        </div>
                        <div id="right" class="right" style="">
                            <ul>
                                <#list categoryVOList as categoryVO>
                                    <li>
                                        <div class="class-title">${categoryVO.getCategoryName()}</div>
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
                                                    <div id="${productVO.getProductId()}"
                                                         style="margin-top: 40px; margin-right: 15px; float: right; ">
                                                        <span class="item-add-less lessnum" style="display:none"
                                                              onclick="deleteProductFromCart(this,${productVO.getProductId()})"></span>
                                                        <span style="float:left;margin-top: 24px;font-size: 16px;display:none">0</span>
                                                        <span class="item-add-less addnum"
                                                              onclick="addProductToCart(this,${productVO.getProductId()},'${productVO.getProductName()}',${productVO.getProductPrice()})"></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </#list>
                                    </li>
                                </#list>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="mask"></div>

        <#--        购物车-->
        <div class="popup">
            <div class="uptitle"><span>已选菜品</span>
                <#--                <div class="tb" id="clearCart">清空</div>-->
            </div>
            <div class="uplist">
                <ul id="cart">

                </ul>
            </div>
        </div>

        <div class="shop-bottom">
            <div class="shop">
                <div class="shopico"><i></i>
                    <div class="numspan" id="productNum">0</div>
                </div>
                <div class="shopprice" id="cartAmount">¥ 0.0</div>
            </div>
            <div class="shop-shopbut" onclick="postOrder()">提交订单</div>
        </div>
        <script src="/js/jquery.min.js"></script>

        <script>
            $(function () {
                var oldHeight = $('.content').height();
                var newHeight = oldHeight + ${totalProductNum} * 90;
                $('.content').height(newHeight);

                changeCartAmount();
            })

            //提交订单
            function postOrder() {
                var arr = cookieUtil.getCookie("car");
                if (arr) {
                    arr = JSON.parse(arr);
                    for (var i = 0; i < arr.length; i++) {
                        var goods = arr[i];
                        if (goods.num > 0) {
                            location.href = '/customer/order/create';
                            break;
                        } else {
                            alert("购物车中没有商品！");
                            break;
                        }
                    }
                }

            }

            //清空购物车
            $(function () {
                $('#clearCart').click(function () {
                    cookieUtil.unsetCookie('car');
                    location.reload();
                })
            })

            //点击打开底部购物车栏
            function showCart() {
                var arr = cookieUtil.getCookie("car");
                var cart = document.getElementById("cart");
                cart.innerHTML = "";
                if (arr) {
                    arr = JSON.parse(arr);
                    for (var i = 0; i < arr.length; i++) {
                        var goods = arr[i];
                        if (goods.num > 0) {
                            var firstItem = document.getElementById(goods.g_id).parentNode.firstChild.nextSibling;
                            var html = "<li>\n" +
                                "<div class=\"uppic\"><img src=\"" + firstItem.firstChild.nextSibling.firstChild.src + "\"></div>\n" +
                                "<div class=\"listtitle\">\n" +
                                "<h1>" + goods.g_name + "</h1>\n" +
                                "<h2>￥ " + goods.g_price + "</h2>" +
                                "</div><div class=\"listright\"><span class=\"lessnum\" onclick=\"deleteProductOnCart(this," + goods.g_id + ")\"></span>\n" +
                                "<p>" + goods.num + "</p>\n" +
                                "<span class=\"addnum\" onclick=\"addProductOnCart(this," + goods.g_id + ")\"></span>\n" +
                                "</div></li>";
                            var li = document.createElement("li");
                            li.innerHTML = html;
                            cart.appendChild(li);
                        }
                    }
                }
            }

            $(function () {

            })

            //在购物车中点击增加按钮
            function addProductOnCart(item, g_id) {
                var arr = JSON.parse(cookieUtil.getCookie("car"))
                for (var i = 0; i < arr.length; i++) {
                    if (arr[i].g_id == g_id) {
                        //已经存在该商品，商品数量+1
                        arr[i].num++;
                        item.previousSibling.previousSibling.innerHTML = arr[i].num;
                        document.getElementById(g_id).children[1].innerText = arr[i].num;
                        break;//立即结束遍历
                    }
                }

                saveArrToCookie(JSON.stringify(arr));
                changeCartAmount();
            }

            function saveArrToCookie(carJson) {
                var date = new Date();
                date.setDate(date.getDate() + 10); //保存十天
                //保存cookie
                cookieUtil.setCookie("car", carJson, date);
            }

            //在购物车中点击删除按钮
            function deleteProductOnCart(item, g_id) {
                var arr = JSON.parse(cookieUtil.getCookie("car"));
                for (var i = 0; i < arr.length; i++) {
                    if (arr[i].g_id == g_id) {
                        if (arr[i].num > 0) {
                            arr[i].num--;
                            item.nextSibling.nextSibling.innerHTML = arr[i].num;
                            document.getElementById(g_id).children[1].innerText = arr[i].num;

                        }
                        if (arr[i].num <= 0) {
                            document.getElementById(g_id).children[0].style.display = "none";
                            document.getElementById(g_id).children[1].style.display = "none";
                            var parent = item.parentNode.parentNode.parentNode;
                            var deleteItem = item.parentNode.parentNode;
                            parent.removeChild(deleteItem);
                        }
                        break;//立即结束遍历
                    }
                }

                saveArrToCookie(JSON.stringify(arr));
                changeCartAmount();
            }

            //动态改变底栏数量和总价
            function changeCartAmount() {
                var productNum = 0;
                var amount = 0;
                var arr = cookieUtil.getCookie("car");
                if (arr) {
                    arr = JSON.parse(arr);
                    for (var i = 0; i < arr.length; i++) {
                        var goods = arr[i];
                        if (goods.num > 0) {
                            try {
                                var secondChild = setItemBlock(document.getElementById(goods.g_id));
                                secondChild.innerText = goods.num;
                                productNum += goods.num;
                                amount += goods.num * goods.g_price;
                            } catch (err) {
                                deleteDownProductFromCart(goods.g_id);
                            }
                        }
                    }
                    amount = amount.toFixed(1);
                    document.getElementById("productNum").innerHTML = productNum;
                    document.getElementById("cartAmount").innerHTML = "¥ " + amount;
                }
            }

            function deleteDownProductFromCart(g_id) {
                var arr = JSON.parse(cookieUtil.getCookie("car"));
                for (var i = 0; i < arr.length; i++) {
                    if (arr[i].g_id == g_id) {
                        while (arr[i].num > 0) {
                            arr[i].num--;
                        }
                    }
                }
                saveArrToCookie(JSON.stringify(arr));
            }

            //显示删除按钮
            function setItemBlock(parentItem) {
                var firstChild = parentItem.firstChild.nextSibling;
                var secondChild = firstChild.nextSibling.nextSibling;
                firstChild.style.display = "block";
                secondChild.style.display = "block";
                return secondChild;
            }

            //点餐 数量+1
            function addProductToCart(addItem, g_id, g_name, g_price) {
                var secondChild = setItemBlock(addItem.parentNode);

                var arr = cookieUtil.getCookie("car") ? JSON.parse(cookieUtil.getCookie("car")) : [];
                for (var i = 0; i < arr.length; i++) {
                    if (arr[i].g_id == g_id) {
                        //已经存在该商品，商品数量+1
                        arr[i].num++;
                        secondChild.innerText = arr[i].num;
                        break;//立即结束遍历
                    }
                }

                if (i == arr.length) {
                    var goods = {
                        "g_id": g_id,
                        "g_name": g_name,
                        "g_price": g_price,
                        num: 1
                    }
                    arr.push(goods);
                }

                saveArrToCookie(JSON.stringify(arr));
                changeCartAmount();
            }

            //点餐 数量-1
            function deleteProductFromCart(addItem, g_id) {
                var parent = addItem.parentNode;
                var firstChild = parent.firstChild.nextSibling;
                var secondChild = firstChild.nextSibling.nextSibling;
                var arr = cookieUtil.getCookie("car");
                if (arr) {
                    arr = JSON.parse(arr);
                    for (var i = 0; i < arr.length; i++) {
                        var goods = arr[i];
                        if (goods.g_id == g_id) {
                            if (goods.num > 0) {
                                goods.num--;
                                secondChild.innerText = goods.num;
                                arr[i] = goods;
                            }
                            if (goods.num <= 0) {
                                firstChild.style.display = "none";
                                secondChild.style.display = "none";
                            }
                        }

                    }
                }
                saveArrToCookie(JSON.stringify(arr));
                changeCartAmount();
            }

            //cookie Util
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

        <script type="text/javascript">
            $(function () {
                $('.content').css('height', $('.right').height());
                $('.left ul li').eq(0).addClass('active');
                $(window).scroll(function () {
                    if ($(window).scrollTop() >= 150) {
                        $('.swiper-container-ul').css('position', 'fixed');
                        $('.left').css('position', 'fixed');
                        $('.right').css('margin-left', $('.left').width());
                    } else {
                        $('.swiper-container-ul').css('position', '');
                        $('.left').css('position', '');
                        $('.right').css('margin-left', '');
                    }
                    ;
                    //滚动到标杆位置,左侧导航加active
                    $('.right ul li').each(function () {
                        var target = parseInt($(this).offset().top - $(window).scrollTop() - 150);
                        //alert(target);
                        var i = $(this).index();
                        if (target <= 0) {
                            $('.left ul li').removeClass('active');
                            $('.left ul li').eq(i).addClass('active');
                        }
                    });
                });
                $('.left ul li').click(function () {
                    var i = $(this).index('.left ul li');
                    $('body, html').animate({scrollTop: $('.right ul li').eq(i).offset().top - 40}, 500);
                });
                //购物车点击
                $('.shop').click(function () {
                    $('.mask').show();
                    $('.popup').css("bottom", "50px");
                    showCart();
                    stopBodyScroll(true);
                });
                $('.mask').click(function () {
                    $('.mask').hide();
                    $('.popup').css("bottom", "-300px");
                    stopBodyScroll(false);
                });
            });
        </script>

        //购物车弹出后禁止底层滑动
        <script>
            var bodyEl = document.body;
            var height = 0;

            function stopBodyScroll(isFixed) {
                if (isFixed) {
                    height = window.scrollY;

                    bodyEl.style.position = 'fixed';
                    bodyEl.style.top = -height + 'px';
                } else {
                    bodyEl.style.position = '';
                    bodyEl.style.top = '';

                    window.scrollTo(0, height); // 回到原先的top
                }
            }
        </script>

    </body>

</html>
