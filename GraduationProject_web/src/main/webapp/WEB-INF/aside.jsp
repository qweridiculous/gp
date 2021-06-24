<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/web/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${msg.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- search form -->
        <!--<form action="#" method="get" class="sidebar-form">
    <div class="input-group">
        <input type="text" name="q" class="form-control" placeholder="搜索...">
        <span class="input-group-btn">
        <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
        </button>
      </span>
    </div>
</form>-->
        <!-- /.search form -->


        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="${pageContext.request.contextPath}/adminn/goIndex.do"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>
            <li ><a href="${pageContext.request.contextPath}/adminUser/findAll.do"><i class="fa fa-user"></i> <span>用户管理</span></a></li>
            <li ><a href="${pageContext.request.contextPath}/adminBooks/findAll.do"><i class="fa fa-book"></i> <span>图书管理</span></a></li>
            <li ><a href="${pageContext.request.contextPath}/adminComment/findAll.do"><i class="fa fa-comment"></i> <span>评论管理</span></a></li>
            <li ><a href="${pageContext.request.contextPath}/adminMajor/findAll.do"><i class="fa fa-map"></i> <span>类别管理</span></a></li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>