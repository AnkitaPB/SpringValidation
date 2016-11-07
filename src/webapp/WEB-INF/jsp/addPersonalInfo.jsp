<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Info Page</title>
<style>
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
<body>
<h2><spring:message code="lbl.page" text="personal Info Page"/></h2>
<form:form method="post" modelAttribute="pesronalVO">
<table>
	<tr>
	<td><spring:message code="lbl.firstName" text="First Name"/></td>
	<td><form:form path="firstName"/></td>
	<td><form:errors path="firstName" cssClass="error" /></td>
	
	</tr>
	<tr>
	<td><spring:message code="lbl.middleName" text="Middle Name"/></td>
	<td><form:form path="middleName"/></td>
	</tr>
	<tr>
	<td><spring:message code="lbl.last Name" text="Last Name"/></td>
	<td><form:form path="lastName"/></td>
	</tr>
	<tr>
	<td><spring:message code="lbl.gender" text="Gender"/></td>
	<td><form:radiobutton path="gender" value="male"/>Male
			<form:radiobutton path="gender" value="fename"/>Female
	  </td>
	</tr>
	<tr>
	<td colspan="2">
	<input type="submit" value="Add Personal details"> 
	</td>
	</tr>
</table>
</form:form>

</body>
</html>