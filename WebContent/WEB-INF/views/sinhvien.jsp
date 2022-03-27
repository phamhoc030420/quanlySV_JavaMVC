<%@ page 
   pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
      <meta name="generator" content="Hugo 0.80.0">
      <meta http-equiv="Content-Security-Policy" content="script-src 'self' https://apis.google.com">
      <title>Chuyến Xe</title>
      <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/navbar-static/">
      <link rel="preconnect" href="https://fonts.gstatic.com">
      <link href="https://fonts.googleapis.com/css2?family=Dancing+Script&display=swap" rel="stylesheet">
      <link href="<c:url value='/resources/assets/dist/css/bootstrap.min.css' />" rel="stylesheet">
      <link href="<c:url value='/resources/fontawesome-free-5.15.1-web/css/all.css'></c:url>" rel="stylesheet">
      <link rel="canonical" href="https://www.wrappixel.com/templates/ample-admin-lite/" />
      <link href="<c:url value='/resources/admin/css/style.min.css' />">
      <link href="<c:url value='/resources/admin/css/style.css' />">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     
      
      <link href="<c:url value="/resources/assets/dist/css/navbar-top.css"/>" rel="stylesheet">
   </head>
 
   <body>
		   <c:forEach var="sv" items="${sinhvien}">
                   <tbody id="myTable">
                     <tr>
                        <td style="text-align: center;">${sv.masv}</td>
                        <td style="text-align: center;">${sv.hoten}</td>
                        <td style="text-align: center;">${sv.ngaysinh}</td>
                        <td style="text-align: center;">${sv.lop.malop}</td>
                        <td style="text-align: center;">${sv.tendn}</td>
                        <td style="text-align: center;">${sv.matkhau}</td>
               
                     
                     </tr>
                     </tbody>
                  </c:forEach>
   </body>
</html>