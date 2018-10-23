<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.osu.cse5234.model.*,edu.osu.cse5234.business.view.Item" %>
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
<body background="http://pic.qiantucdn.com/58pic/26/30/69/58d2a33f4de55_1024.jpg!qt324">
<jsp:include page='header.jsp'/> 
<h3>Order Info</h3>
	<table class="table" >
	<tr>
    <th>Book Name</th>
    <th>Price</th> 
    <th>Quantity</th>
  </tr>
  <%
  	Order order=(Order)(session.getAttribute("order"));
    int totalPrice=0;
    
    for (LineItem item : order.getLineItems()){
    	if(item.getQuantity()>0){%>
    	<tr>
    		<td><%=item.getItemName() %></td>
    		<td><%=item.getPrice() %></td>
	<td><%=item.getQuantity() %></td>
    		</tr>
    	<%  
    	  totalPrice+=item.getPrice()*item.getQuantity();
    	}
    }
    
  %>
  </table>
  <p><b>Total Price</b> <%=totalPrice %> </p>
  <h3>Payment Info</h3>
  <%
  PaymentInfo paymentInfo=(PaymentInfo)(session.getAttribute("paymentInfo"));
  %>
  <table class="table">
		<tr>
			<td>Credit Card Number</td>
			<td><%=paymentInfo.getCreditCardNumber() %></td>
		</tr>
		<tr>
			<td>Expiration Date</td>
			<td><%=paymentInfo.getExpirationDate() %></td>
		</tr>
		<tr>
			<td>CVV Code</td>
			<td>***</td>
		</tr>
		<tr>
			<td>Card Holder Name</td>
			<td><%=paymentInfo.getCardHolderName() %></td>
		</tr>	

    </table>
  <h3>Shipping Info</h3>
   <%
  ShippingInfo shippingInfo=(ShippingInfo)(session.getAttribute("shippingInfo"));
  %>
  <table class="table">
		<tr>
			<td>addressLine1</td>
			<td><%=shippingInfo.getAddressLine1() %></td>
		</tr>
		</tr>
		<tr>
			<td>addressLine2</td>
			<td><%=shippingInfo.getAddressLine2() %></td>
		</tr>
		</tr>
		<tr>
			<td>City</td>
			<td><%=shippingInfo.getCity() %></td>
		</tr>
		</tr>
		<tr>
			<td>State</td>
			<td><%=shippingInfo.getState() %></td>
		</tr>
		</tr>
		<tr>
			<td>Zip Code</td>
			<td><%=shippingInfo.getZip() %></td>
		</tr>
		<tr>
			<td>Country</td>
			<td><%=shippingInfo.getCountry() %></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><%=shippingInfo.getEmail() %></td>
		</tr>
		</tr>

	

    </table>
   <form method="post" action="confirmOrder">
  <input class="btn btn-primary" type="submit" value="Confirm"></td>
</form>
<jsp:include page='footer.jsp'/> 
</body>
</html>