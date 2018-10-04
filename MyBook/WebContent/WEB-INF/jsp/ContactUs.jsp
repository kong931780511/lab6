<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
		<link rel="stylesheet" href="./WebContent/css/mystyle.css" type="text/css">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<title>Insert title here</title>
</head>
<body background="http://ichef.bbci.co.uk/wwfeatures/wm/live/1280_640/images/live/p0/2v/dp/p02vdpfn.jpg">
<jsp:include page='header.jsp'/> 
<div id="contact">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div id="contact-left">
                            <h1>Our Information</h1>
                            <div id="contact-info">
                                <div id="phone-fax-email">
                                    <p>
                                        <strong>Phone:</strong><span>(614)696-3210</span>
                                        <strong>Fax:</strong><span>(614)696-3210</span>
                                        <strong>Email:</strong><span>kongosu325@gmail.com</span>
                                    </p>
                                </div>
                                </div>
                                <ul class="social-list">
                                <li><a href="#" class="social-icon icon-white"><i class="fab fa-facebook"></i></a></li>
                                <li><a href="#" class="social-icon icon-white"><i class="fab fa-twitter"></i></a></li>
                                <li><a href="#" class="social-icon icon-white"><i class="fab fa-google-plus"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6 ">
                        <div id="contact-right">
                            <h3>Contact Us</h3>
                            <form action="#">
                                <input type="text" name="full-name" placeholder="full Name" class="form-control">
                                <input type="text" name="email" placeholder="Email Address" class="form-control">
                                <textarea rows="5" name="message" placeholder="Message..." class="form-control"></textarea>
                                <div id="send-btn">
                                    <a class="btn btn-lg btn-general btn-white" href="#" role="button">SEND</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="footer-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div id="footer-copyrights">
                            <p>Copyrights &copy; 2018 ALL Rights Reseved</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
 <jsp:include page='footer.jsp'/> 
</body>
</html>
