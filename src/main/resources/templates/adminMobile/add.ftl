<!doctype html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>新增菜品</title>
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

            .tpl-page-header-fixed {
                margin-top: 35px;
            }

            .top {
                width: 100%;
                height: 45px;
                position: fixed;
                top: 0;
                z-index: 9999;
                background: #8BB4E7;
            }
        </style>
    </head>

    <body data-type="generalComponents">

        <div class="top">
            <a href="/adminMobile/index">
                <img src="/images/customer/back_white.png"
                     style="margin-top: 13px; margin-left: 20px; float:left;"
                     height="20px" width="20px">
            </a>
            <p style="margin-left: 15px; margin-top: 11px; float:left; font-size: 15px; color: white">
                增加菜品
            </p>
        </div>

        <div class="tpl-page-container tpl-page-header-fixed">
            <div class="tpl-content-wrapper">
                <div class="tpl-content-scope">
                    <div class="note note-info">
                        <h3>新增菜品
                            <span class="close" data-close="note"></span>
                        </h3>
                        <p>在本页可以为餐厅添加新的菜品，请在下方填写新菜品的相关信息。</p>
                        <p><span class="label label-danger">提示:</span>
                            可以上传本地图片也可以使用网络图片链接。
                        </p>
                    </div>
                </div>

                <div class="tpl-portlet-components">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            <span class="am-icon-code"></span> 菜品详情
                        </div>
                    </div>

                    <div class="tpl-block ">

                        <div class="am-g tpl-amazeui-form">

                            <div class="am-u-sm-12 am-u-md-9">
                                <form class="am-form am-form-horizontal" method="post"
                                      action="/adminMobile/product/save">

                                    <div class="am-form-group">
                                        <label for="product-name" class="am-u-sm-3 am-form-label">名称</label>
                                        <div class="am-u-sm-9">
                                            <input type="text" id="product-name" name="productName"
                                                   placeholder="名称 / Name" value="">
                                            <!-- <small>输入商品的名称</small>-->
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="product-price" class="am-u-sm-3 am-form-label">价格</label>
                                        <div class="am-u-sm-9">
                                            <input type="text" id="product-price" name="productPrice"
                                                   placeholder="价格 / Price"
                                                   value="">
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="product-description" class="am-u-sm-3 am-form-label">描述</label>
                                        <div class="am-u-sm-9">
                                            <input type="text" id="product-description" name="productDescription"
                                                   placeholder="请输入商品描述"
                                                   value="">
                                            </textarea>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="product-icon" class="am-u-sm-3 am-form-label">图片</label>
                                        <div class="am-u-sm-9">
                                            <input name="productIcon" type="text" id="product-icon"
                                                   placeholder="图片地址" value="">
                                            <img style="margin-top: 10px;width: 200px; height: 200px; display: none"
                                                 id="preview_photo"
                                                 src="">

                                            <div style="margin-top: 15px;">
                                                <a href="javascript:void(0);" onclick="uploadPhoto();"
                                                   class="am-btn am-btn-primary">选择图片</a>
                                                <input type="file" id="photoFile" style="display: none;">
                                            </div>

                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="product-category" class="am-u-sm-3 am-form-label">类目</label>
                                        <div class="am-u-sm-9">
                                            <select name="categoryType" id="product-category">
                                                <#list categoryList as category>
                                                    <option value="${category.getCategoryType()}">
                                                        ${category.getCategoryName()}
                                                    </option>
                                                </#list>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                            <button type="submit" class="am-btn am-btn-primary">新增</button>
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
                    url: "http://${webSocketUrl}/adminMobile/image/uploadPhoto",
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
