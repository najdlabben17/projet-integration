<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>

<html>
<head>
<title>HOME PAGE</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css" />
</head>
<body>

	<div>
		<h2>PRODUCT MANAGEMENT</h2>
	</div>
	
	<div>
		
		<s:form modelAttribute="product" action="save" method="post">
		
			<table>
				
				<tr>
					<td>SERIAL NUMBER:</td>
					<td><s:input path="serialNumber"/></td>
					<td><s:errors path="serialNumber" cssClass="error"/></td>
				</tr>
				<tr>
					<td>DESIGNATION:</td>
					<td><s:input path="designation"/></td>
					<td><s:errors path="designation" cssClass="error"/></td>
				</tr>
				<tr>
					<td>UNIT PRICE:</td>
					<td><s:input path="price"/></td>
					<td><s:errors path="price" cssClass="error"/></td>
				</tr>
				<tr>
					<td>QUANTITY:</td>
					<td><s:input path="quantity"/></td>
					<td><s:errors path="quantity" cssClass="error"/></td>
				</tr>												
				<tr>
					<td><input type="submit" value="Save"/> </td>
				</tr>
				
			</table>
			
		</s:form>
		
	
	</div>

	<div>
		<table class="tableStyle">
			<tr>
				<th>SERIAL NUMBER</th>
				<th>DESIGNATION</th>
				<th>UNIT PRICE</th>
				<th>QUANTITY</th>
			</tr>

			<c:forEach items="${products}" var="p">

				<tr>
					<td>${p.serialNumber}</td>
					<td>${p.designation}</td>
					<td>${p.price}</td>
					<td>${p.quantity}</td>
					<td>
						<form action="selectForUpdate" method="post">
							<input type="hidden" value="${p.serialNumber}" name="selectedProd">
							<input type="submit" value="select">
						</form>
					</td>
					<td>
						<form action="delete" method="post">
							<input type="hidden" value="${p.serialNumber}" name="selectedProd">
							<input type="submit" value="delete">
						</form>
					</td>

					
					
					
				</tr>

			</c:forEach>

		</table>
	</div>

</body>
</html>