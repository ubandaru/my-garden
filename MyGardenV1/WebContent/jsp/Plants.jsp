<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to My Plants</title>
</head>
<body bgcolor="#196F3D">

<h1 style="color:#D5F5E3"> Welcome to My Garden ! </h1>

<form method="get" action="getplants">
    <c:choose>
    		<c:when test="${plants==null}">
		<h4 style="color:#D5F5E3"> Please enter your zipcode below: </h4> <br><br>
		<div align="center">
			<input type=text name="zipcode" size = "20"></input><br><br>
			<input type =submit name="ask" value="GO"></input>
		</div>
	   </c:when>
	   
	   <c:otherwise>
			<h4 style="color:#D5F5E3">List of Plants in the area:</h4>
			<table>
				<c:forEach var="plant" items="${plants}">
				<tr>
					<td>
						<font style="color:#D5F5E3">${plant}</font>
						</td>
				</tr>
				</c:forEach>
			</table>
			<input type=submit name="back" value="BACK"></input>
     </c:otherwise>
  </c:choose>   
</form>

</body>
</html>