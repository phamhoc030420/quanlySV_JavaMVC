<%@ page 
   pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html lang="en">
   <head>
   <meta http-equiv="Content-Security-Policy" content="script-src 'self' https://apis.google.com">
         <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edmin</title>
        <link href="<c:url value='/resources/css/theme.css' />" rel="stylesheet">
        <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
        <link href="<c:url value='/resources/bootstrap/css/bootstrap-responsive.min.css' />" rel="stylesheet">
        <base href="${pageContext.servletContext.contextPath}" />
        <link href="<c:url value='/resources/images/icons/css/font-awesome.css' />" rel="stylesheet">
        <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
            rel='stylesheet'>
      <style type="text/css">
      .log:hover{
     		color: red;
     		font-weight: bold;	
      }
      
      </style>   
    </head>
   
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                        <i class="icon-reorder shaded"></i></a><a class="brand" href="index.html">Edmin </a>
                    <div class="nav-collapse collapse navbar-inverse-collapse">
                        <ul class="nav nav-icons">
                            <li class="active"><a href="#"><i class="icon-envelope"></i></a></li>
                            <li><a href="#"><i class="icon-eye-open"></i></a></li>
                            <li><a href="#"><i class="icon-bar-chart"></i></a></li>
                        </ul>
                        <form class="navbar-search pull-left input-append" action="#">
                        <input type="text" class="span3">
                        <button class="btn" type="button">
                            <i class="icon-search"></i>
                        </button>
                        </form>
                        <ul class="nav pull-right">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown
                                <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Item No. 1</a></li>
                                    <li><a href="#">Don't Click</a></li>
                                    <li class="divider"></li>
                                    <li class="nav-header">Example Header</li>
                                    <li><a href="#">A Separated link</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Support </a></li>
                            <li class="nav-user dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="<c:url value='/resources/images/user.png' />" class="nav-avatar" />
                                <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Your Profile</a></li>
                                    <li><a href="#">Edit Profile</a></li>
                                    <li><a href="#">Account Settings</a></li>
                                    <li class="divider"></li>
                                    
                                    <li> <form:form action="AT_web_vs_csdl/logout.htm">
                                <button type="submit" style="border: none;margin-top: 20px;" class="widget widget-menu unstyled log"><i class="menu-icon icon-signout"></i>Logout</button> 
                              </form:form></li></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <!-- /.nav-collapse -->
                </div>
            </div>
            <!-- /navbar-inner -->
        </div>
        <!-- /navbar -->
        <div class="wrapper">
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <div class="sidebar">
                            <ul class="widget widget-menu unstyled">
                                <li class="active"><a href="AT_web_vs_csdl/test.htm"><i class="menu-icon icon-dashboard"></i>Trang Chủ
                                </a></li>
                                <li><a href="AT_web_vs_csdl/nv.htm"><i class="menu-icon icon-bullhorn"></i>Nhân Viên </a>
                                </li>
                                <li><a href="AT_web_vs_csdl/lop.htm"><i class="menu-icon icon-inbox"></i>Lớp Học <b class="label green pull-right">
                                    11</b> </a></li>
                                <li><a href="AT_web_vs_csdl/sinhvien.htm"><i class="menu-icon icon-tasks"></i>Sinh Viên <b class="label orange pull-right">
                                    19</b> </a></li>
                            </ul>
                            <!--/.widget-nav-->
                            
                            
                      
                            <!--/.widget-nav-->
                            <ul class="widget widget-menu unstyled">
                                <li><a class="collapsed" data-toggle="collapse" href="#togglePages"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>Setting </a>
                                    <ul id="togglePages" class="collapse unstyled">
                                        <li><a href="other-login.html"><i class="icon-inbox"></i>Login </a></li>
                                        <li><a href="other-user-profile.html"><i class="icon-inbox"></i>Profile </a></li>
                                        <li><a href="other-user-listing.html"><i class="icon-inbox"></i>All Users </a></li>
                                    </ul>
                                </li>
                                <li>
                               <form:form action="AT_web_vs_csdl/logout.htm">
                                <button type="submit" style="border: none;margin-top: 20px;" class="widget widget-menu unstyled log"><i class="menu-icon icon-signout"></i>Logout</button> 
                              </form:form></li>
                            </ul>
                             
                              
                        </div>
                        <!--/.sidebar-->
                    </div>
                    <!--/.span3-->
                    <div class="span9">
                        <div class="content">
                            <div class="btn-controls">
                                <div class="btn-box-row row-fluid">
                                    <a href="AT_web_vs_csdl/test.htm" class="btn-box big span4"><i class=" icon-random"></i><b>Mã Nhân Viên</b>
                                        <p class="text-muted">
                                            ${maso}</p>
                                    </a><a href="AT_web_vs_csdl/test.htm" class="btn-box big span4"><i class="icon-user"></i><b>Nhân Viên</b>
                                        <p class="text-muted">
                                            ${hoten}</p>
                                    </a><a href="AT_web_vs_csdl/test.htm" class="btn-box big span4"><i class="icon-money"></i><b>${luong}</b>
                                        <p class="text-muted">
                                            Lương Cơ bản</p>
                                    </a>
                                </div>
                                <div class="btn-box-row row-fluid">
                                    <div class="span8">
                                        <div class="row-fluid">
                                            <div class="span12">
                                                <a href="AT_web_vs_csdl/test.htm" class="btn-box small span4"><i class="icon-envelope"></i><b>${email}</b>
                                                </a><a href="AT_web_vs_csdl/sinhvien.htm" class="btn-box small span4"><i class="icon-group"></i><b>Sinh Viên</b>
                                                </a><a href="AT_web_vs_csdl/lop.htm" class="btn-box small span4"><i class="icon-exchange"></i><b>Lớp Học</b>
                                                </a>
                                            </div>
                                        </div>
                                        <div class="row-fluid">
                                            <div class="span12">
                                                <a href="AT_web_vs_csdl/test.htm" class="btn-box small span4"><i class="icon-save"></i><b>Total Sales</b>
                                                </a><a href="AT_web_vs_csdl/test.htm" class="btn-box small span4"><i class="icon-bullhorn"></i><b>Social Feed</b>
                                                </a><a href="AT_web_vs_csdl/test.htm" class="btn-box small span4"><i class="icon-sort-down"></i><b>Bounce
                                                    Rate</b> </a>
                                            </div>
                                        </div>
                                    </div>
                                    <ul class="widget widget-usage unstyled span4">
                                        <li>
                                            <p>
                                                <strong>${maso}</strong> <span class="pull-right small muted">78%</span>
                                            </p>
                                            <div class="progress tight">
                                                <div class="bar" style="width: 78%;">
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <p>
                                                <strong>${hoten}</strong> <span class="pull-right small muted">56%</span>
                                            </p>
                                            <div class="progress tight">
                                                <div class="bar bar-success" style="width: 56%;">
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <p>
                                                <strong>${email}</strong> <span class="pull-right small muted">44%</span>
                                            </p>
                                            <div class="progress tight">
                                                <div class="bar bar-warning" style="width: 44%;">
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <p>
                                                <strong>${luong}</strong> <span class="pull-right small muted">67%</span>
                                            </p>
                                            <div class="progress tight">
                                                <div class="bar bar-danger" style="width: 67%;">
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            
                            </div>
                            <!--/.module-->
                        </div>
                        <!--/.content-->
                    </div>
                    <!--/.span9-->
                </div>
            </div>
            <!--/.container-->
      
        <!--/.wrapper-->
        <div class="footer">
            <div class="container">
               
            </div>
        </div>
        
        <script src="<c:url value="/resources/scripts/jquery-1.9.1.min.js" />"></script>
         <script src="<c:url value="/resources/scripts/jquery-ui-1.10.1.custom.min.js" />"></script>
         <%--  <script src="<c:url value="/resources/scripts/flot/jquery.flot.js" />"></script>
           <script src="<c:url value="/resources/scripts/flot/jquery.flot.resize.js" />"></script> --%>
            <script src="<c:url value="/resources/scripts/datatables/jquery.dataTables.js" />"></script>
            <%--  <script src="<c:url value="/resources/scripts/common.js" />"></script> --%>
             <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
        <!--  -->
       
        
        
       
      
      
    </body>
