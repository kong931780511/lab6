<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<link rel="stylesheet" href="./WebContent/css/mystyle.css" type="text/css">
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<title>Insert title here</title>
		<style>
			div {
				display:inline-block;
			}
		</style>
	</head>
	<body background="http://pic.qiantucdn.com/58pic/26/30/69/58d2a33f4de55_1024.jpg!qt324">
	<jsp:include page='header.jsp'/> 
		<h1 align="center">About Us</h1>
		<div class="container-fluid">
    	<div class="col-md-4">
      	<p align="center" style="font-size:24px;">Yao Wei</p>
      	<img src="images/Yao.jpeg" height="200" width="200" style="border-radius:50%;">
    	<p align="center" style="font-size:18px; color: #00A9A5;">CEO </p>
    	<p align="center">CSE major at OSU</p>
    	<p align="center">Internship in ANSYS</p>
    	<ul class="social-list">
        <li><a href="#" class="social-icon icon-gray"><i class="fab fa-facebook"></i></a></li>
        <li><a href="#" class="social-icon icon-gray"><i class="fab fa-twitter"></i></a></li>
        <li><a href="#" class="social-icon icon-gray"><i class="fab fa-google-plus"></i></a></li>
        </ul>
    	</div>
    	<div class="col-md-4" >
      	<p align="center" style="font-size:24px;">Logan McPherson</p>
      	<img src="images/Logan.jpeg" height="200" width="200" style="border-radius:50%;">
    	<p align="center" style="font-size:18px; color: #00A9A5;">CFO </p>
    	<p align="center">CSE major at OSU</p>
    	<p align="center">Internship at GTRI</p>
    	<li><a href="#" class="social-icon icon-gray"><i class="fab fa-facebook"></i></a></li>
        <li><a href="#" class="social-icon icon-gray"><i class="fab fa-twitter"></i></a></li>
        <li><a href="#" class="social-icon icon-gray"><i class="fab fa-google-plus"></i></a></li>
    	</div>
    	<div class="col-md-4" >
      	<p align="center" style="font-size:24px;">Deren Kong</p>
      	<img src="https://cpb-us-w2.wpmucdn.com/u.osu.edu/dist/4/28638/files/2016/10/Image-1-r2tg13.jpeg" height="200" width="200" style="border-radius:50%;">
    	<p align="center" style="font-size:18px; color: #00A9A5;">CFO </p>
    	<p align="center">CEGE major in OSU</p>
    	<p align="center">Intership at MAlong</p>
    	<li><a href="#" class="social-icon icon-gray"><i class="fab fa-facebook"></i></a></li>
        <li><a href="#" class="social-icon icon-gray"><i class="fab fa-twitter"></i></a></li>
        <li><a href="#" class="social-icon icon-gray"><i class="fab fa-google-plus"></i></a></li>
    	</div>
		</div>
		<jsp:include page='footer.jsp'/> 
	</body>
</html>