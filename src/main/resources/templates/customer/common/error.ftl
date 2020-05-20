<!doctype html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
        <title>出现错误</title>
        <script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
        <link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
        <script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
        <style>
            p {
                text-align: center;
            }

            .line-limit-length {
                overflow: hidden;
                text-overflow: ellipsis;
                display: -webkit-box;
                -webkit-line-clamp: 3;
                /* 可以显示的行数，超出部分用...表示*/
                -webkit-box-orient: vertical;
            }
        </style>
    </head>

    <body>

        <div style="text-align: center; width: 100%; height: 250px;">
            <img src="/images/customer/error.png" style="margin-top: 100px;">
        </div>

        <p style="font-size: 18px; color: red;">系统出现错误，错误信息：</p>
        <div style="text-align: center; padding: 0 40px; margin: 20px 0;">
            <p class="line-limit-length">${msg}</p>
        </div>

        <div style="text-align: center; margin-top: 40px;">
            <span id="second">5</span>
            <a href="">秒后自动跳转</a>
        </div>

        <script>
            var second = document.getElementById("second");
            var num = 5;
            var timer = setInterval(function () {
                num--;
                second.innerText = num;
                if (num == 0) {
                    location.replace('${url!"/customer/index"}');
                }
            }, 1000);
        </script>

    </body>

</html>
