<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>书籍详情</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                图书管理
                <small>书籍信息</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/adminn/goIndex.do"><i class="fa fa-dashboard"></i>
                    首页</a></li>
                <li><a href="${pageContext.request.contextPath}/adminBooks/findAll.do">图书管理</a></li>
                <li class="active">书籍信息</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">
            <!--书籍信息-->
            <div class="panel panel-default">
                <div class="panel-heading">书籍信息</div>
                <div class="row data-type">
                    <form id="book_form" action="${pageContext.request.contextPath}/adminBooks/updateBook.do">
                        <div class="col-md-2 title">书籍名称</div>
                        <input hidden name="id" value="${book.id}">
                        <div class="col-md-4 data">
                            <input name="name" type="text" class="form-control" placeholder="书籍名称" value="${book.name}">
                        </div>

                        <div class="col-md-2 title">创建时间</div>
                        <div class="col-md-4 data">
                            <input type="text" disabled class="form-control pull-right" value="<fmt:formatDate value="${book.createDate}" pattern="yyyy-MM-dd" />">
                        </div>
                        <div class="col-md-2 title">书籍价格（元）</div>
                        <div class="col-md-4 data">
                            <input type="text" name="price" class="form-control" placeholder="书籍价格" value="${book.price}">
                        </div>

                        <div class="col-md-2 title">所属分类</div>
                        <div class="col-md-4 data">
                            <select class="form-control"  name="mid" style="width: 100%;">
                                <option value ="1" id="1">计算机科学与信息工程学院</option>
                                <option value ="2" id="2">机械工程学院</option>
                                <option value="3" id="3">电子信息与电气工程学院</option>
                                <option value="4" id="4">土木与建筑工程学院</option>
                                <option value="5" id="5">化学与环境工程学院</option>
                                <option value="6" id="6">材料科学与工程学院</option>
                                <option value="7" id="7">生物与食品工程学院</option>
                                <option value="15" id="15">文法学院</option>
                                <option value="16" id="16">经管学院</option>
                                <option value="17" id="17">外国语学院</option>
                                <option value="18" id="18">艺术设计学院</option>
                                <option value="12" id="12">数学与信息科学学院</option>
                                <option value="13" id="13">飞行学院</option>
                                <option value="19" id="19">公修科目</option>
                                <option value="20" id="20">考公书籍</option>
                                <option value="21" id="21">考研书籍</option>
                                <option value="22" id="22">四六级书籍</option>
                                <option value="23" id="23">计算机二级书籍</option>
                            </select>
                        </div>
                        <div class="col-md-2 title rowHeight2x">书籍介绍</div>
                        <div class="col-md-10 data rowHeight2x">
                            <textarea name="introduce" class="form-control" rows="3" placeholder="书籍介绍">${book.introduce}</textarea>
                        </div>
                    </form>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">书籍图片</div>
                <div class="row data-type">
                    <div class="col-lg-3">
                        <img style="height: 200px;width: 150px" src="../${book.img}" alt="product img">
                    </div>
                    <c:forEach items="${book.imgs}" var="img">
                        <div class="col-lg-3">
                            <img style="height: 200px;width: 150px" src="../${img.img}" alt="product img">
                        </div>
                    </c:forEach>
                </div>

            </div>
            <!--发布人信息-->
            <div class="panel panel-default">
                <div class="panel-heading">发布人信息</div>
                <div class="row data-type">

                    <div class="col-md-2 title">用户名</div>
                    <div class="col-md-4 data text">
                        ${book.user.username}
                    </div>

                    <div class="col-md-2 title">学号</div>
                    <div class="col-md-4 data text">
                        ${book.user.studentNum}
                    </div>

                    <div class="col-md-2 title">邮箱</div>
                    <div class="col-md-4 data text">
                        ${book.user.email}
                    </div>

                    <div class="col-md-2 title">已发布数量</div>
                    <div class="col-md-4 data text">
                        ${book.user.sellCount}
                    </div>

                </div>
            </div>

            <!--工具栏-->
            <div class="box-tools text-center">
                <button type="button" id="sub_form" class="btn bg-maroon">保存</button>
                <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
            </div>
            <!--工具栏/-->

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2014-2017 <a href="">研究院研发部</a>.</strong> All rights reserved.
    </footer>
    <!-- 底部导航 /-->

</div>


<script src="${pageContext.request.contextPath}/web/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $(document).ready(function () {
        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });

    $(function () {
        $("#"+${book.mid}).attr("selected","selected");

        $("#sub_form").click(function () {
            $("#book_form").submit();
        })

    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }


    $(document).ready(function () {
        // 激活导航位置
        setSidebarActive("order-manage");
    });
</script>
</body>

</html>