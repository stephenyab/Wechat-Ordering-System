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
        <link rel="stylesheet" href="/css/admin/cropper.min.css">
        <link rel="stylesheet" href="/css/admin/ImgCropping.css">
        <style>
            img[src=""], img:not([src]) {
                opacity: 0;
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
                            <a href="/admin/product/detail" class="nav-link active">
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
                    餐厅 商品详情
                </div>
                <ol class="am-breadcrumb">
                    <li><a href="/admin/index" class="am-icon-home">首页</a></li>
                    <li class="am-active">商品详情</li>
                </ol>
                <div class="tpl-portlet-components">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            <span class="am-icon-code"></span> 商品详情
                        </div>
                    </div>

                    <div class="tpl-block ">

                        <div class="am-g tpl-amazeui-form">

                            <div class="am-u-sm-12 am-u-md-9">
                                <form class="am-form am-form-horizontal" method="post" action="/admin/product/save">

                                    <div class="am-form-group" hidden="hidden">
                                        <div class="am-u-sm-9">
                                            <input hidden="hidden" type="text" name="productId"
                                                   value="${(productInfo.getProductId())!""}">
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="product-name" class="am-u-sm-3 am-form-label">名称 /
                                            Name</label>
                                        <div class="am-u-sm-9">
                                            <input type="text" id="product-name" name="productName"
                                                   placeholder="名称 / Name" value="${(productInfo.getProductName())!""}">
                                            <!-- <small>输入商品的名称</small>-->
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="product-price" class="am-u-sm-3 am-form-label">价格 /
                                            Price</label>
                                        <div class="am-u-sm-9">
                                            <input type="text" id="product-price" name="productPrice"
                                                   placeholder="价格 / Price"
                                                   value="${(productInfo.getProductPrice())!""}">
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="product-description" class="am-u-sm-3 am-form-label">描述 /
                                            Description</label>
                                        <div class="am-u-sm-9">
                                            <input type="text" id="product-description" name="productDescription"
                                                   placeholder="请输入商品描述"
                                                   value="${(productInfo.getProductDescription())!""}">
                                            </textarea>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="product-icon" class="am-u-sm-3 am-form-label">图片 /
                                            Icon</label>
                                        <div class="am-u-sm-9">
                                            <input name="productIcon" type="text" id="product-icon"
                                                   placeholder="图片 / Icon" value="${(productInfo.getProductIcon())!""}">
                                            <img style="margin-top: 10px;width: 200px; height: 200px;"
                                                 id="preview_photo"
                                                 src="${(productInfo.getProductIcon())!""}">

                                            <#if productExist == "false">
                                                <div style="margin-top: 15px;">
                                                    <a href="javascript:void(0);" onclick="uploadPhoto();"
                                                       class="am-btn am-btn-primary">选择图片</a>
                                                    <input type="file" id="photoFile" style="display: none;">
                                                </div>
                                            </#if>

                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="product-category" class="am-u-sm-3 am-form-label">类目 /
                                            Category</label>
                                        <div class="am-u-sm-9">
                                            <select name="categoryType" id="product-category">
                                                <#list categoryList as category>
                                                    <option value="${category.getCategoryType()}"
                                                            <#if (productInfo.categoryType)?? && productInfo.getCategoryType()==category.getCategoryType()>
                                                                selected="selected"
                                                            </#if>
                                                    >${category.getCategoryName()}
                                                    </option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                            <button type="submit" class="am-btn am-btn-primary">保存修改</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <!--图片裁剪框 start-->
        <div style="display: none" class="tailoring-container">
            <div class="black-cloth" onclick="closeTailor(this)"></div>
            <div class="tailoring-content">
                <div class="tailoring-content-one">

                    <div class="close-tailoring" onclick="closeTailor(this)">×</div>
                </div>

                <div class="tailoring-content-two">
                    <div class="tailoring-box-parcel">
                        <img id="tailoringImg">
                    </div>
                    <div class="preview-box-parcel">
                        <p>图片预览：</p>
                        <div class="square previewImg"></div>
                        <!--  <div class="circular previewImg"></div>-->
                    </div>
                </div>

                <div class="tailoring-content-three">
                    <button class="l-btn cropper-reset-btn">复位</button>
                    <button class="l-btn cropper-rotate-btn">旋转</button>
                    <button class="l-btn cropper-scaleX-btn">换向</button>
                    <button class="l-btn sureCut" id="sureCut">确定</button>
                </div>
            </div>
        </div>
        <!--图片裁剪框 end-->

        <script src="/js/jquery.min.js"></script>
        <script src="/js/admin/amazeui.min.js"></script>
        <script src="/js/admin/app.js"></script>
        <script src="/js/admin/cropper.min.js"></script>

        <script>
            //剪裁图片弹出框水平垂直居中
            (window.onresize = function () {
                var win_height = $(window).height();
                var win_width = $(window).width();
                if (win_width <= 768) {
                    $(".tailoring-content").css(
                        {
                            "top": (win_height - $(".tailoring-content")
                                .outerHeight()) / 2,
                            "left": 0
                        });
                } else {
                    $(".tailoring-content").css(
                        {
                            "top": (win_height - $(".tailoring-content")
                                .outerHeight()) / 2,
                            "left": (win_width - $(".tailoring-content")
                                .outerWidth()) / 2
                        });
                }
            })();

            //隐藏图片显示区域
            <#if productExist == "false">
            $("#preview_photo").hide();
            </#if>

            //点击选择图片
            uploadPhoto = function () {
                $("#photoFile").click();
            };

            //裁切压缩图片并上传到服务器
            $("#photoFile").change(function (e) {
                $(".tailoring-container").toggle();

                var reader = new FileReader();
                img = new Image();
                file = e.target.files[0];

                //判断文件的是不是图片
                if (!/image\/\w+/.test(file.type)) {
                    alert("上传的文件格式不对,请重新上传...");
                    return false;
                }

                reader.readAsDataURL(file);
                reader.onload = function (e) {
                    var replaceSrc = e.target.result;
                    // 更换cropper的图片
                    $('#tailoringImg').cropper('replace', replaceSrc, false);// 默认false，适应高度，不失真
                };

                img = cropperImage(img);

                compressImageUseCanvas(img);

            });

            // cropper图片裁剪
            function cropperImage(img) {
                $('#tailoringImg').cropper({
                    aspectRatio: 1 / 1,// 默认比例
                    preview: '.previewImg',// 预览视图
                    guides: false, // 裁剪框的虚线(九宫格)
                    autoCropArea: 0.5, // 0-1之间的数值，定义自动剪裁区域的大小，默认0.8
                    movable: false, // 是否允许移动图片
                    dragCrop: true, // 是否允许移除当前的剪裁框，并通过拖动来新建一个剪裁框区域
                    movable: true, // 是否允许移动剪裁框
                    resizable: true, // 是否允许改变裁剪框的大小
                    zoomable: false, // 是否允许缩放图片大小
                    mouseWheelZoom: false, // 是否允许通过鼠标滚轮来缩放图片
                    touchDragZoom: true, // 是否允许通过触摸移动来缩放图片
                    rotatable: true, // 是否允许旋转图片
                    crop: function (e) {
                        // 输出结果数据裁剪图像。
                    }
                });

                // 图片剪裁框确定按钮点击事件
                $("#sureCut").on("click", function () {
                    if ($("#tailoringImg").attr("src") == null) {
                        return false;
                    } else {
                        var cas = $('#tailoringImg').cropper('getCroppedCanvas');// 获取被裁剪后的canvas
                        img.src = cas.toDataURL("image/png");

                        closeTailor();// 关闭裁剪框
                    }
                });

                return img;
            }

            // 旋转
            $(".cropper-rotate-btn").on("click", function () {
                $('#tailoringImg').cropper("rotate", 45);
            });
            // 复位
            $(".cropper-reset-btn").on("click", function () {
                $('#tailoringImg').cropper("reset");
            });
            // 换向
            var flagX = true;
            $(".cropper-scaleX-btn").on("click", function () {
                if (flagX) {
                    $('#tailoringImg').cropper("scaleX", -1);
                    flagX = false;
                } else {
                    $('#tailoringImg').cropper("scaleX", 1);
                    flagX = true;
                }
                flagX != flagX;
            });

            // 关闭裁剪框
            function closeTailor() {
                $(".tailoring-container").toggle();
            }

            /**
             * 压缩图片
             */
            function compressImageUseCanvas(img) {
                var canvas = document.createElement('canvas');
                var context = canvas.getContext('2d');
                img.onload = function () {
                    // 图片原始尺寸
                    var originWidth = this.width;
                    var originHeight = this.height;
                    // 最大尺寸限制
                    var maxWidth = 400, maxHeight = 400;
                    // 目标尺寸
                    var targetWidth = originWidth, targetHeight = originHeight;
                    // 图片尺寸超过400x400的限制
                    if (originWidth > maxWidth || originHeight > maxHeight) {
                        if (originWidth / originHeight > maxWidth / maxHeight) {
                            // 更宽，按照宽度限定尺寸
                            targetWidth = maxWidth;
                            targetHeight = Math.round(maxWidth * (originHeight / originWidth));
                        } else {
                            targetHeight = maxHeight;
                            targetWidth = Math.round(maxHeight * (originWidth / originHeight));
                        }
                    }// canvas对图片进行缩放
                    canvas.width = targetWidth;
                    canvas.height = targetHeight;
                    // 清除画布
                    context.clearRect(0, 0, targetWidth, targetHeight);
                    // 图片压缩
                    context.drawImage(img, 0, 0, targetWidth, targetHeight);
                    //canvas转为blob并上传
                    canvas.toBlob(function (blob) {
                        uploadImage(blob);
                    }, file.type || 'image/png');
                };
            }

            /**
             * 上传图片
             */
            function uploadImage(photo) {
                let file2 = new File([photo], 'a.jpg', {type: 'image/jpg'})

                // ajax上传文件不能像上传普通对象那样，得用上FormData
                let formData = new FormData()
                formData.append('photo', file2)
                $.ajax({
                    url: "http://${webSocketUrl}/admin/image/uploadPhoto",
                    type: "post",
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: function (data) {
                        if (data.type == "success") {
                            $("#preview_photo").show();
                            $("#preview_photo").attr("src", data.photoUrl);
                            $("#product-icon").val(data.photoUrl);
                        } else {
                            alert(data.msg);
                        }
                    },
                    error: function (data) {
                        alert("上传失败");
                    }
                });
            }


        </script>

    </body>

</html>
