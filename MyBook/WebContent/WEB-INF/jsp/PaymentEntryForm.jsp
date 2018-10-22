<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body background="http://ichef.bbci.co.uk/wwfeatures/wm/live/1280_640/images/live/p0/2v/dp/p02vdpfn.jpg">
<jsp:include page='header.jsp'/> 
<form:form modelAttribute="paymentInfo" method="post" action="submitPayment">

    <table class="table">
    <caption>Payment Info</caption>
		<tr>
			<td>Credit Card Number</td>
			<td><form:input  class="form-control" required="true" path="CreditCardNumber"  /></td>
		</tr>
		<tr>
			<td>Expiration Date</td>
			<td><form:input class="form-control" type="date" required="true" path="ExpirationDate"  /></td>
		</tr>
		<tr>
			<td>CVV Code</td>
			<td><form:input class="form-control" type="password" required="true" path="cvvCode"  /></td>
		</tr>
		<tr>
			<td>Card Holder Name</td>
			<td><form:input class="form-control" required="true" path="CardHolderName"  /></td>
		</tr>

	  <tr>
		<td colspan="2"><input class="btn btn-primary" type="submit" value="submit"></td>
	  </tr>
	

    </table>
</form:form>
<jsp:include page='footer.jsp'/> 
</body>
