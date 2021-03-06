<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">


    <!-- Logo -->
    <a href="" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>数据</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>二手图书网站</b>后台管理</span>
    </a>


    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${pageContext.request.contextPath}/web/img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs">${msg.username}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="${pageContext.request.contextPath}/web/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                            <p>
                                ${msg.username} - 数据管理员
                            </p>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </nav>
</header>
