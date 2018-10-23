<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body background="http://ichef.bbci.co.uk/wwfeatures/wm/live/1280_640/images/live/p0/2v/dp/p02vdpfn.jpg">
<jsp:include page='header.jsp'/> 
<h4 align="center">Programming Books</h4>
<form:form modelAttribute="order" method="post" action="/MyBook/purchase/submitItems">
    <table class="table">
        	<td>Product Name</td><td>Price</td><td>Quantity</td>
	<c:forEach items="${order.lineItems}" var="lineItem" varStatus="loop">
		<tr>
			<td><c:out value="${lineItem.itemName}"></c:out></td>
			<td><c:out value="$${lineItem.price}"></c:out></td>
			<td><form:input class="form-control" type="number" min="0" required="true" path="lineItems[${loop.index}].quantity" /></td>
			<td hidden="true"><form:input path="lineItems[${loop.index}].itemName" value="${lineItem.itemName}" /></td>
			<td hidden="true"><form:input path="lineItems[${loop.index}].price" value="${lineItem.price}"/></td>
			<td hidden="true"><form:input path="lineItems[${loop.index}].itemNumber" value="${lineItem.itemNumber}"/></td>
		</tr>
	</c:forEach>
    <tr>
		<td colspan="2"><input class="btn btn-primary" type="submit" value="Add to order" style="width:100px;height:30px;"></td>
	</tr>
	</table>
</form:form>
<jsp:include page='footer.jsp'/> 
</body>
</html>
