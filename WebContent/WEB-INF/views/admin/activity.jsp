<%@ page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nhân Viên</title>
<link href="<c:url value='/resources/css/theme.css' />" rel="stylesheet">
<link
	href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet">
<link
	href="<c:url value='/resources/bootstrap/css/bootstrap-responsive.min.css' />"
	rel="stylesheet">
<base href="${pageContext.servletContext.contextPath}" />
<link
	href="<c:url value='/resources/images/icons/css/font-awesome.css' />"
	rel="stylesheet">
	<link rel="shortcut icon" href="#">
<link type="text/css"
	href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
	rel='stylesheet'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<style type="text/css">
.input {
	float: right;
}
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
					<i class="icon-reorder shaded"></i>
				</a>

			  	<a class="brand" href="index.html">
			  		Admin
			  	</a>

				<div class="nav-collapse collapse navbar-inverse-collapse">
					<ul class="nav nav-icons">
						<li class="active"><a href="">
							<i class="icon-envelope"></i>
						</a></li>
						<li><a href="">
							<i class="icon-eye-open"></i>
						</a></li>
						<li><a href="">
							<i class="icon-bar-chart"></i>
						</a></li>
					</ul>

					<form class="navbar-search pull-left input-append" action="">
						<input type="text" class="span3" id="myInput" onkeyup="myFunction()">
						<button class="btn" type="button">
							<i class="icon-search"></i>
						</button>
					</form>
				
					<ul class="nav pull-right">
						<li class="dropdown">
							<a href="" class="dropdown-toggle" data-toggle="dropdown">Drops <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="">Action</a></li>
								<li><a href="">Another action</a></li>
								<li><a href="">Something else here</a></li>
								<li class="divider"></li>
								<li class="nav-header">Nav header</li>
								<li><a href="">Separated link</a></li>
								<li><a href="">One more separated link</a></li>
							</ul>
						</li>
						
						<li><a href="">
							Support
						</a></li>
						<li class="nav-user dropdown">
							<a href="" class="dropdown-toggle" data-toggle="dropdown">
								 <img src="<c:url value='/resources/images/user.png' />" class="nav-avatar" />
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="">Your Profile</a></li>
								<li><a href="">Edit Profile</a></li>
								<li><a href="">Account Settings</a></li>
								<li class="divider"></li>
								<li> <form:form action="AT_web_vs_csdl/logout.htm">
                                <button type="submit" style="border: none;margin-top: 20px;" class="widget widget-menu unstyled log"><i class="menu-icon icon-signout"></i>Logout</button> 
                              </form:form></li></li>
							</ul>
						</li>
					</ul>
				</div><!-- /.nav-collapse -->
			</div>
		</div><!-- /navbar-inner -->
	</div><!-- /navbar -->



	<div class="wrapper">
		<div class="container">
			<div class="row">
				<div class="span3">
					<div class="sidebar">
						<ul class="widget widget-menu unstyled">
							<li class="active"><a href="AT_web_vs_csdl/test.htm"><i
									class="menu-icon icon-dashboard"></i>Trang Chủ </a></li>
							<li><a href="AT_web_vs_csdl/nv.htm"><i
									class="menu-icon icon-bullhorn"></i>Nhân Viên </a></li>
							<li><a href="AT_web_vs_csdl/lop.htm"><i
									class="menu-icon icon-inbox"></i>Lớp Học <b
									class="label green pull-right"> 11</b> </a></li>
							<li><a href="AT_web_vs_csdl/sinhvien.htm"><i
									class="menu-icon icon-tasks"></i>Sinh Viên <b
									class="label orange pull-right"> 19</b> </a></li>
						</ul>
						<!--/.widget-nav-->



						<!--/.widget-nav-->
						<ul class="widget widget-menu unstyled">
							<li><a class="collapsed" data-toggle="collapse"
								href="#togglePages"><i class="menu-icon icon-cog"> </i><i
									class="icon-chevron-down pull-right"></i><i
									class="icon-chevron-up pull-right"> </i>Setting </a>
								<ul id="togglePages" class="collapse unstyled">
									<li><a href="other-login.html"><i class="icon-inbox"></i>Login
									</a></li>
									<li><a href="other-user-profile.html"><i
											class="icon-inbox"></i>Profile </a></li>
									<li><a href="other-user-listing.html"><i
											class="icon-inbox"></i>All Users </a></li>
								</ul></li>
							<li> <form:form action="AT_web_vs_csdl/logout.htm">
                                <button type="submit" style="border: none;margin-top: 20px;" class="widget widget-menu unstyled log"><i class="menu-icon icon-signout"></i>Logout</button> 
                              </form:form></li></li>
						</ul>
					</div>
					<!--/.sidebar-->
				</div>


				<div class="span9">
					<div class="content">

						<div class="module">
							<div class="module-head">
								<h3>Nhân Viên</h3>
							</div>

							<div class="module-body">
								<!--THONG TIN NHAN VIEN  -->
								<!-- Them -->
								<div>
									<button type="button" class="btn-lg" data-toggle="modal"
										data-target="#myModal1" class="btnAdd" name="btnAdd"
										style="float: right !important; background-color: #006CCC !important; height: 36px; color: white; text-align: center; margin-bottom: 10px; font-size: 15px; padding-top: 6px;" onclick="check()">ADD</button>
									<!-- Modal thêm chuyến xe-->

									<div class="modal fade" id="myModal1" role="dialog"
										style="background-image: linear-gradient(#7FAFB1, #2D2B32); margin-top: 140px;">
										<div class="modal-dialog modal-sm">
											<div class="modal-content"
												style="width: 500px !important; height: 500px !important;">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														style="float: right !important; color: red; font-size: 60px;">&times;</button>
													<h4 class="modal-title" style="color: white;">Thêm
														Nhân Viên</h4>

												</div>
												<div class="modal-body"
													style="width: 500px !important; height: 400px !important;">
													<form:form action="AT_web_vs_csdl/nv.htm"
														modelAttribute="nhanvien" onsubmit="return validate()"
														method="post">
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Mã Nhân Viên:
																	<form:input path="manv" id="num1" type="text"
																		style="width: 200px;" class="input" maxlength="11"
																		autocomplete="off" />
																</h6>
															</div>
														</div>
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Họ Tên:
																	<form:input path="hoten" id="num2"
																		style="width: 200px;" class="input" maxlength="11"
																		autocomplete="off" />
																	<!-- onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  -->
																</h6>
															</div>
														</div>
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Email:
																	<form:input path="email" id="num3" name="" type="email"
																		style="width: 200px;" class="input" autocomplete="off" />
																</h6>
															</div>
														</div>
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Lương:
																	<form:input path="luong" id="num4" name="" type="text"
																		style="width: 200px;" class="input" autocomplete="off" />
																</h6>
															</div>
														</div>
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Tên Đăng Nhập:
																	<form:input path="tendn" id="num5" name="" type="text"
																		style="width: 200px;" class="input" autocomplete="off" />
																</h6>
															</div>
														</div>
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Mật Khẩu:
																	<form:input path="matkhau" id="num6" name=""
																		type="password" style="width: 200px;" class="input"
																		autocomplete="off" />
																</h6>
															</div>
														</div>
														<br>
														<br>
														<!-- <div class="modal-footer" style="background-image: linear-gradient(#7FAFB1, #2D2B32);"> -->
														<button type="button" class="btn btn-danger"
															data-dismiss="modal"
															style="margin-left: 50px; background-color: red !important; color: black; float: right;" onclick="trang()">Close</button>
														<button name="btnAdd" id="dismiss-popup-btn "
															type="submit" class="btn btn-primary"
															style="background-color: blue !important; color: black; float: right;">Thêm
														</button>
														<!--  </div> -->
													</form:form>
												</div>
											</div>
										</div>
									</div>
									<!--  -->
									<!-- Edit -->
									<div class="modal fade" id="myModal" role="dialog"
										style="background-image: linear-gradient(#7FAFB1, #2D2B32);">
										<div class="modal-dialog modal-sm">
											<div class="modal-content"
												style="width: 500px !important; height: 500px !important;">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														style="float: right !important; color: red; font-size: 60px;">&times;</button>
													<h4 class="modal-title" style="color: white;">Thay đổi
														thông tin nhân viên</h4>

												</div>
												<div class="modal-body"
													style="width: 500px !important; height: 520px !important;">
													<form:form action="/AT_web_vs_csdl/nv.htm"
														modelAttribute="nhanvien" onsubmit="return validate1()"
														method="post">
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Mã Nhân Viên:
																	<form:input path="manv" id="" type="text"
																		style="width: 200px;" class="input" maxlength="11"
																		autocomplete="off" readonly="true"/>
																</h6>
															</div>
														</div>
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Họ Tên:
																	<form:input path="hoten" id="num8"
																		style="width: 200px;" class="input" 
																		autocomplete="off" />
																	<!-- onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  -->
																</h6>
															</div>
														</div>
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Email:
																	<form:input path="email" id="num9" name="" type="email"
																		style="width: 200px;" class="input" autocomplete="off" />
																</h6>
															</div>
														</div>
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Lương:
																	<form:input path="luong" id="num10" name="" type="text"
																		style="width: 200px;" class="input" autocomplete="off" />
																</h6>
															</div>
														</div>
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Tên Đăng Nhập:
																	<form:input path="tendn" id="num11" name="" type="text"
																		style="width: 200px;" class="input" autocomplete="off" />
																</h6>
															</div>
														</div>
														<div class="row no-gutters mb-2"
															style="margin-left: 40px;">

															<div class="col-8 pb-2 d-flex align-items-center">
																<h6 class="text-dark"
																	style="color: white; font-size: 16px;">
																	Mật Khẩu:
																	<form:input path="matkhau" id="num12" name=""
																		type="password" min="2021-06-03" style="width: 200px;"
																		class="input" autocomplete="off" />
																</h6>
															</div>
														</div>
														<br>
														<br>

														<a type="button" class="btn btn-danger"
															href="AT_web_vs_csdl/nv.htm"
															style="margin-left: 50px; background-color: red !important; color: white; float: right;" onclick="trang()">Close</a>
														<button name="btnEdit" id="dismiss-popup-btn "
															type="submit" class="btn btn-primary"
															style="background-color: blue !important; color: black; float: right;">Thay
															đổi</button>
													</form:form>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--  -->
								

								<table class="table table-hover" style="margin-right: 600px;">
									<tr style="background-color: #29B7D3;">
										<th style="text-align: center;">Mã Nhân Viên</th>
										<th style="text-align: center;">Họ Tên</th>
										<th style="text-align: center;">Email</th>
										<th style="text-align: center;">Lương</th>
										<th style="text-align: center;">Tên Đăng Nhập</th>
										<th style="text-align: center;">Mật Khẩu</th>
										<th style="text-align: center;"></th>
										<th style="text-align: center;"></th>
										<th></th>
										<th></th>
									</tr>
									<c:forEach var="nv" items="${anhanvien}">
										<tbody id="myTable">
											<tr>
												<td class="nvnv" style="text-align: center;">${nv.manv}</td>
												<td style="text-align: center;">${nv.hoten}</td>
												<td style="text-align: center;">${nv.email}</td>
												<td style="text-align: center;">*****</td>
												<td style="text-align: center;">*****</td>
												<td style="text-align: center;">*****</td>

												<c:set var="salary" value="${maso}" />
												<c:if test="${nv.manv==salary}">
													<td><a class="btn btn-success" class="btnedit"
														style="text-decoration: none; color: white !important;"
														href="AT_web_vs_csdl/nv/${nv.manv}-${nv.hoten}-${nv.email}.htm?linkEdit">Chọn</a></td>
													
													<td><a onclick="huy()" class="btn btn-danger"
														style="text-decoration: none; margin-bottom: 10px;"
														name="btnDelete"
														href="AT_web_vs_csdl/nv/${nv.manv}.htm?linkDelete"
														role="button" id="dismiss-popup-btn"><i
															style="width: 50px; height: 40px;"
															class="fas fa-trash-alt">Del</i></a></td>
												</c:if>

											
											</tr>
										</tbody>
									</c:forEach>
									<button class="btn btn-success" type="button"
															class="btnedit" data-toggle="modal" onclick="layurl()"
															data-target="#myModal" style="border: none; height: 36px;float: right;margin-right: 60px;">
															<a style="text-decoration: none; color: white !important;"
																href="AT_web_vs_csdl/nv/${nv.manv}-${nv.hoten}-${nv.email}.htm?linkEdit">Edit</a>
															<!-- <a href="javascript:void(0)"></a> -->
														</button>
								</table>
							</div>
							<!--/.module-body-->
						</div>
						<!--/.module-->

					</div>
					<!--/.content-->
				</div>
				<!--/.span9-->
			</div>
		</div>
		<!--/.container-->
	</div>
	<!--/.wrapper-->


	<script type="text/javascript">
    $(document).ready(function(){
 		  $("#myInput").on("keyup", function() {
 		    var value = $(this).val().toLowerCase();
 		    $("#myTable tr").filter(function() {
 		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
 		    });
 		  });
 		});
    function check() {
		var currentLocation = window.location;
		var link="http://localhost:8080/AT_web_vs_csdl/nv.htm";
		if(currentLocation!=link){
			window.location = 'http://localhost:8080/AT_web_vs_csdl/nv.htm';
		}	
	}
	function layurl() {
		var currentLocation = window.location;
		var link="http://localhost:8080/AT_web_vs_csdl/nv.htm";
		if(currentLocation==link){
			alert("Vui lòng chọn nhân viên");
			window.location = 'http://localhost:8080/AT_web_vs_csdl/nv.htm';
		}	
	}
	function trang() {
		
			window.location = 'http://localhost:8080/AT_web_vs_csdl/nv.htm';
			
	}
    function huy() {
    	  alert("Xóa thành công!!!");
    	
    	  } 
    function reset(){
      	 document.getElementById("num1").value="";
      	 document.getElementById("num2").value="";
      	document.getElementById("num3").value="";
      	document.getElementById("num4").value="";
      	document.getElementById("num5").value="";
      	document.getElementById("num6").value="";
      }
    function validate() {
        var n1 = document.getElementById("num1");
        var n2 = document.getElementById("num2");
        var n3 = document.getElementById("num3");
        var n4 = document.getElementById("num4");
        var n5 = document.getElementById("num5");
        var n6 = document.getElementById("num6");
        var ma=document.getElementsByClassName('nvnv');
        var len=document.getElementsByClassName('nvnv').length;
       
       
        
            if (n1.value =="" ) {
                alert("Vui lòng nhập mã nhân viên!!!");
                return false;
            }
            if (n1.value.toLowerCase (). indexOf ( 'script') !=-1 ||n1.value.toLowerCase (). indexOf ( '>') !=-1 
            		|| n1.value.toLowerCase (). indexOf ( '<') !=-1 || n1.value.toLowerCase (). indexOf ( '(') !=-1
            				||n1.value.toLowerCase (). indexOf ( ')') !=-1||n1.value.toLowerCase (). indexOf ( '"') !=-1 ||n1.value.toLowerCase (). indexOf ( '/') !=-1
            				||n1.value.toLowerCase (). indexOf ( 'or') !=-1||n1.value.toLowerCase (). indexOf ( '=') !=-1) {
                alert("Kí tự nhập không hợp lệ!!!");
                document.getElementById("num1").value="";
                return false;
            }
            for(let i=0;i<len;i++){
            	if(n1.value==ma[i].innerHTML){
            		 alert("Mã nhân viên đã tồn tại vui lòng nhập mã khác!!!");
            		 document.getElementById("num1").value="";
                     return false;
            	}
            }
          if(n2.value==""){
        	  alert("Vui lòng nhập họ tên !!!");
              return false;
          }
          if (n2.value.toLowerCase (). indexOf ( 'script') !=-1 ||n2.value.toLowerCase (). indexOf ( '>') !=-1 
          		|| n2.value.toLowerCase (). indexOf ( '<') !=-1 || n2.value.toLowerCase (). indexOf ( '(') !=-1
          				||n2.value.toLowerCase (). indexOf ( ')') !=-1||n2.value.toLowerCase (). indexOf ( '"') !=-1 ||n2.value.toLowerCase (). indexOf ( '/') !=-1
          				||n2.value.toLowerCase (). indexOf ( 'or') !=-1||n2.value.toLowerCase (). indexOf ( '=') !=-1) {
              alert("Kí tự nhập không hợp lệ!!!");
              document.getElementById("num2").value="";
              return false;
          }
          
          if(n3.value==""){
        	  alert("Vui lòng nhập email !!!");
              return false;
          }
          if (n3.value.toLowerCase (). indexOf ( 'script') !=-1 ||n3.value.toLowerCase (). indexOf ( '>') !=-1 
          		|| n3.value.toLowerCase (). indexOf ( '<') !=-1 || n3.value.toLowerCase (). indexOf ( '(') !=-1
          				||n3.value.toLowerCase (). indexOf ( ')') !=-1||n3.value.toLowerCase (). indexOf ( '"') !=-1 ||n3.value.toLowerCase (). indexOf ( '/') !=-1
          				||n3.value.toLowerCase (). indexOf ( 'or') !=-1||n3.value.toLowerCase (). indexOf ( '=') !=-1) {
              alert("Kí tự nhập không hợp lệ!!!");
              document.getElementById("num3").value="";
              return false;
          }
          
          if(n4.value==""){
        	  alert("Vui lòng nhập lương !!!");
              return false;
          }
          if(isNaN(n4.value)){
        	  alert("Lương Không Hợp Lệ !!!");
        	  document.getElementById("num4").value="";
              return false;
          }
          if (n4.value.toLowerCase (). indexOf ( 'script') !=-1 ||n4.value.toLowerCase (). indexOf ( '>') !=-1 
          		|| n4.value.toLowerCase (). indexOf ( '<') !=-1 || n4.value.toLowerCase (). indexOf ( '(') !=-1
          				||n4.value.toLowerCase (). indexOf ( ')') !=-1||n4.value.toLowerCase (). indexOf ( '"') !=-1 ||n4.value.toLowerCase (). indexOf ( '/') !=-1
          				||n4.value.toLowerCase (). indexOf ( 'or') !=-1||n4.value.toLowerCase (). indexOf ( '=') !=-1) {
              alert("Kí tự nhập không hợp lệ!!!");
              document.getElementById("num4").value="";
              return false;
          }
          if(n5.value==""){
        	  alert("Vui lòng nhập tên đăng nhập !!!");
              return false;
          }
          if (n5.value.toLowerCase (). indexOf ( 'script') !=-1 ||n5.value.toLowerCase (). indexOf ( '>') !=-1 
          		|| n5.value.toLowerCase (). indexOf ( '<') !=-1 || n5.value.toLowerCase (). indexOf ( '(') !=-1
          				||n5.value.toLowerCase (). indexOf ( ')') !=-1||n5.value.toLowerCase (). indexOf ( '"') !=-1 ||n5.value.toLowerCase (). indexOf ( '/') !=-1
          				||n5.value.toLowerCase (). indexOf ( 'or') !=-1||n5.value.toLowerCase (). indexOf ( '=') !=-1) {
              alert("Kí tự nhập không hợp lệ!!!");
              document.getElementById("num5").value="";
              return false;
          }
          if(n6.value==""){
        	  alert("Vui lòng nhập mật khẩu !!!");
              return false;
          }
          
          if (n6.value.toLowerCase (). indexOf ( 'script') !=-1 ||n6.value.toLowerCase (). indexOf ( '>') !=-1 
          		|| n6.value.toLowerCase (). indexOf ( '<') !=-1 || n6.value.toLowerCase (). indexOf ( '(') !=-1
          				||n6.value.toLowerCase (). indexOf ( ')') !=-1||n6.value.toLowerCase (). indexOf ( '"') !=-1 ||n6.value.toLowerCase (). indexOf ( '/') !=-1
          				||n6.value.toLowerCase (). indexOf ( 'or') !=-1||n6.value.toLowerCase (). indexOf ( '=') !=-1) {
              alert("Kí tự nhập không hợp lệ!!!");
              document.getElementById("num6").value="";
              return false;
          }
          if (n1.value != "" && n2.value != "" && n3.value != "" && n4.value != ""&& n5.value != ""&& n6.value != "") {
              alert("Thêm Thành Công!!!");
              return true;
          }
          
        }
    
    function validate1() {
        var n8 = document.getElementById("num8");
        var n9 = document.getElementById("num9");
        var n10 = document.getElementById("num10");
        var n11 = document.getElementById("num11");
        var n12 = document.getElementById("num12");
      
       
      
           
          if(n8.value==""){
        	  alert("Vui lòng nhập họ tên !!!");
              return false;
          }
          if (n8.value.toLowerCase (). indexOf ( 'script') !=-1 ||n8.value.toLowerCase (). indexOf ( '>') !=-1 
          		|| n8.value.toLowerCase (). indexOf ( '<') !=-1 || n8.value.toLowerCase (). indexOf ( '(') !=-1
          				||n8.value.toLowerCase (). indexOf ( ')') !=-1||n8.value.toLowerCase (). indexOf ( '"') !=-1 ||n8.value.toLowerCase (). indexOf ( '/') !=-1
          				||n8.value.toLowerCase (). indexOf ( 'or') !=-1||n8.value.toLowerCase (). indexOf ( '=') !=-1) {
              alert("Kí tự nhập không hợp lệ!!!");
              document.getElementById("num8").value="";
              return false;
          }
          
          if(n9.value==""){
        	  alert("Vui lòng nhập email !!!");
              return false;
          }
          if (n9.value.toLowerCase (). indexOf ( 'script') !=-1 ||n9.value.toLowerCase (). indexOf ( '>') !=-1 
          		|| n9.value.toLowerCase (). indexOf ( '<') !=-1 || n9.value.toLowerCase (). indexOf ( '(') !=-1
          				||n9.value.toLowerCase (). indexOf ( ')') !=-1||n9.value.toLowerCase (). indexOf ( '"') !=-1 ||n9.value.toLowerCase (). indexOf ( '/') !=-1
          				||n9.value.toLowerCase (). indexOf ( 'or') !=-1||n9.value.toLowerCase (). indexOf ( '=') !=-1) {
              alert("Kí tự nhập không hợp lệ!!!");
              document.getElementById("num9").value="";
              return false;
          }
          
          if(n10.value==""){
        	  alert("Vui lòng nhập lương !!!");
              return false;
          }
          if(isNaN(n10.value)){
        	  alert("Lương Không Hợp Lệ !!!");
        	  document.getElementById("num10").value="";
              return false;
          }
          if (n10.value.toLowerCase (). indexOf ( 'script') !=-1 ||n10.value.toLowerCase (). indexOf ( '>') !=-1 
          		|| n10.value.toLowerCase (). indexOf ( '<') !=-1 || n10.value.toLowerCase (). indexOf ( '(') !=-1
          				||n10.value.toLowerCase (). indexOf ( ')') !=-1||n10.value.toLowerCase (). indexOf ( '"') !=-1 ||n10.value.toLowerCase (). indexOf ( '/') !=-1
          				||n10.value.toLowerCase (). indexOf ( 'or') !=-1||n10.value.toLowerCase (). indexOf ( '=') !=-1) {
              alert("Kí tự nhập không hợp lệ!!!");
              document.getElementById("num10").value="";
              return false;
          }
          if(n11.value==""){
        	  alert("Vui lòng nhập tên đăng nhập !!!");
              return false;
          }
          if (n11.value.toLowerCase (). indexOf ( 'script') !=-1 ||n11.value.toLowerCase (). indexOf ( '>') !=-1 
          		|| n11.value.toLowerCase (). indexOf ( '<') !=-1 || n11.value.toLowerCase (). indexOf ( '(') !=-1
          				||n11.value.toLowerCase (). indexOf ( ')') !=-1||n11.value.toLowerCase (). indexOf ( '"') !=-1 ||n11.value.toLowerCase (). indexOf ( '/') !=-1
          				||n11.value.toLowerCase (). indexOf ( 'or') !=-1||n11.value.toLowerCase (). indexOf ( '=') !=-1) {
              alert("Kí tự nhập không hợp lệ!!!");
              document.getElementById("num11").value="";
              return false;
          }
          if(n12.value==""){
        	  alert("Vui lòng nhập mật khẩu !!!");
              return false;
          }
          
          if (n12.value.toLowerCase (). indexOf ( 'script') !=-1 ||n12.value.toLowerCase (). indexOf ( '>') !=-1 
          		|| n12.value.toLowerCase (). indexOf ( '<') !=-1 || n12.value.toLowerCase (). indexOf ( '(') !=-1
          				||n12.value.toLowerCase (). indexOf ( ')') !=-1||n12.value.toLowerCase (). indexOf ( '"') !=-1 ||n12.value.toLowerCase (). indexOf ( '/') !=-1
          				||n12.value.toLowerCase (). indexOf ( 'or') !=-1||n12.value.toLowerCase (). indexOf ( '=') !=-1) {
              alert("Kí tự nhập không hợp lệ!!!");
              document.getElementById("num12").value="";
              return false;
          }
          if (n8.value != "" && n9.value != "" && n10.value != "" && n11.value != ""&& n12.value != "") {
              alert("Thay Đổi Thành Công!!!");
              return true;
          }
        }
	</script>

	<script src="<c:url value="/resources/scripts/jquery-1.9.1.min.js" />"></script>
	<script
		src="<c:url value="/resources/scripts/jquery-ui-1.10.1.custom.min.js" />"></script>
	<%-- <script src="<c:url value="/resources/scripts/flot/jquery.flot.js" />"></script> --%>
	<%-- <script
		src="<c:url value="/resources/scripts/flot/jquery.flot.resize.js" />"></script> --%>
	<script
		src="<c:url value="/resources/scripts/datatables/jquery.dataTables.js" />"></script>
	<%-- <script src="<c:url value="/resources/scripts/common.js" />"></script> --%>
	<script
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
</body>