<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>书籍列表</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/web/plugins/bootstrap-slider/slider.css">
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
                图书管理 <small>全部书籍</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/adminn/goIndex.do"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/adminBooks/findAll.do">图书管理</a></li>

                <li class="active">全部书籍</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--数据列表-->
                        <table id="dataList"
                               class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="sorting_asc">ID</th>
                                <th class="sorting_desc">书籍名称</th>
                                <th class="sorting_asc sorting_asc_disabled">价格</th>
                                <th class="sorting_desc sorting_desc_disabled">发布用户</th>
                                <th class="sorting_desc sorting_desc_disabled">发布时间</th>
                                <th class="sorting_desc sorting_desc_disabled">状态</th>
                                <th class="text-center">操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${pageInfo.list}" var="book">
                                <tr>
                                    <td>${book.id }</td>
                                    <td>${book.name }</td>
                                    <td>${book.price }</td>
                                    <td>${book.user.username }</td>
                                    <td><fmt:formatDate value="${book.createDate}" pattern="yyyy-MM-dd" /> </td>
                                    <td>${book.offShelfStr }</td>
                                    <td class="text-center">
                                        <a href="${pageContext.request.contextPath}/adminBooks/setOnShelf.do?id=${book.id}"
                                           class="btn bg-olive btn-xs">上架</a>
                                        <a href="${pageContext.request.contextPath}/adminBooks/setOffShelf.do?id=${book.id}"
                                           class="btn bg-olive btn-xs">下架</a>
                                        <a href="${pageContext.request.contextPath}/adminBooks/findById.do?id=${book.id}"
                                           class="btn bg-olive btn-xs">详情</a>
                                        <a href="${pageContext.request.contextPath}/adminBooks/deleteBook.do?id=${book.id}"
                                           class="btn bg-olive btn-xs">移除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <!--
                        <tfoot>
                        <tr>
                        <th>Rendering engine</th>
                        <th>Browser</th>
                        <th>Platform(s)</th>
                        <th>Engine version</th>
                        <th>CSS grade</th>
                        </tr>
                        </tfoot>-->
                        </table>
                        <!--数据列表/-->

                    </div>
                    <!-- 数据表格 /-->

                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共${pageInfo.pages} 页，共${pageInfo.total} 条数据。 每页
                            <select class="form-control" id="changePageSize" onchange="changePageSize()">
                                <c:forEach begin="1" end="5" var="num">
                                    <c:if test="${pageInfo.size == num}">
                                        <option selected>${num}</option>
                                    </c:if>
                                    <c:if test="${pageInfo.size != num}">
                                        <option>${num}</option>
                                    </c:if>
                                </c:forEach>
                            </select> 条
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="${pageContext.request.contextPath}/adminBooks/findAll.do?page=1&size=${pageInfo.pageSize}"
                                   aria-label="Previous">首页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/adminBooks/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                            </li>
                            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                                <li>
                                    <a href="${pageContext.request.contextPath}/adminBooks/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                                </li>
                            </c:forEach>
                            <li>
                                <a href="${pageContext.request.contextPath}/adminBooks/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/adminBooks/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
                                   aria-label="Next">尾页</a>
                            </li>
                        </ul>
                    </div>
                    <!-- /.box-footer-->

                </div>
            </div>
        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2014-2017 <a
                href="http://www.itcast.cn">研究院研发部</a>.
        </strong> All rights reserved.
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
<script
        src="${pageContext.request.contextPath}/web/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/web/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/web/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/web/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/web/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/web/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
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
<script>
    $(document).ready(function () {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });

    function changePageSize() {
        //获取下拉框的值
        var pageSize = $("#changePageSize").val();

        //向服务器发送请求，改变没页显示条数
        location.href = "${pageContext.request.contextPath}/adminBooks/findAll.do?page=1&size="
            + pageSize;
    }

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document)
        .ready(
            function () {

                // 激活导航位置
                setSidebarActive("admin-datalist");

                // 列表按钮 
                $("#dataList td input[type='checkbox']")
                    .iCheck(
                        {
                            checkboxClass: 'icheckbox_square-blue',
                            increaseArea: '20%'
                        });
            });
</script>
</body>

</html>