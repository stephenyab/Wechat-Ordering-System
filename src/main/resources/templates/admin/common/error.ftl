<html>
    <head>
        <meta charset="UTF-8">
        <title>
            错误提示
        </title>
        <link rel="icon" type="image/png" href="/images/admin/favicon.png">
        <script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
        <link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
        <script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    </head>
    <body>
        <div style="margin-top: 300px" class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="alert alert-dismissable alert-danger">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4>
                            错误！
                        </h4>
                        <strong>${msg!""}</strong>
                        <br><br>
                        <a href="${url}" class="alert-link">两秒后自动跳转</a>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script>
        setTimeout('location.href="${url}"', 2000);
    </script>

</html>
